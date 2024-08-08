package com.apps;



import com.apps.mooc.MoocBackendApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.context.ConfigurableApplicationContext;
import tv.codely.shared.infra.cli.ConsoleCommand;

import java.util.Arrays;
import java.util.HashMap;

/**
 * To run mooc backend app optional --info label
 api only run the app
 gradle  :run --args="mooc_backend api" --info
 gradle  :run --args="mooc_backend Fake"

 **/
public class Starter {
    public static void main(String[] args) {
        if (args.length < 2) {
            throw new RuntimeException("There are not enough arguments");
        }

        String  applicationName = args[0];
        String  commandName     = args[1];
        boolean isApiCommand    = commandName.equals("api");

        ensureApplicationExist(applicationName);
        ensureCommandExist(applicationName, commandName);

        Class<?> applicationClass = applications().get(applicationName);

        SpringApplication app = new SpringApplication(applicationClass);

        if (!isApiCommand) {
            app.setWebApplicationType(WebApplicationType.NONE);
        }

        ConfigurableApplicationContext context = app.run(args);

        if (!isApiCommand) {
            Object commandBean = context.getBean(commands().get(applicationName).get(commandName));
            if (commandBean instanceof ConsoleCommand) {
                var command = (ConsoleCommand) commandBean;
                command.execute(Arrays.copyOfRange(args, 2, args.length));
            } else {
                throw new ClassCastException("The command bean is not an instance of ConsoleCommand");
            }
        }
    }

    private static void ensureApplicationExist(String applicationName) {
        if (!applications().containsKey(applicationName)) {
            throw new RuntimeException(String.format(
                    "The application <%s> doesn't exist. Valids:\n- %s",
                    applicationName,
                    String.join("\n- ", applications().keySet())
            ));
        }
    }

    private static void ensureCommandExist(String applicationName, String commandName) {
        if (!"api".equals(commandName) && !existCommand(applicationName, commandName)) {
            throw new RuntimeException(String.format(
                    "The command <%s> for application <%s> doesn't exist. Valids (application.command):\n- api\n- %s",
                    commandName,
                    applicationName,
                    String.join("\n- ", commands().get(applicationName).keySet())
            ));
        }
    }

    private static HashMap<String, Class<?>> applications() {
        HashMap<String, Class<?>> applications = new HashMap<>();

        applications.put("mooc_backend", MoocBackendApplication.class);

        return applications;
    }

    private static  HashMap<String, HashMap<String, Class<?>>> commands() {
        HashMap<String, HashMap<String, Class<?>>> commands = new HashMap<>();

        commands.put("mooc_backend", MoocBackendApplication.commands());

        return commands;
    }

    private static Boolean existCommand(String applicationName, String commandName) {
        HashMap<String, HashMap<String, Class<?>>> commands = commands();

        return commands.containsKey(applicationName) && commands.get(applicationName).containsKey(commandName);
    }

    private static String commandKey(String contextName, String commandName) {
        return String.format("%s.%s", contextName, commandName);
    }
}