package tv.codely.shared.infra.bus.command;

import tv.codely.shared.domain.bus.command.Command;
import tv.codely.shared.domain.bus.command.CommandHandler;
import tv.codely.shared.domain.bus.command.CommandNotRegisteredError;

import java.util.HashMap;

public class CommandHandlerInformation {

    HashMap<Class<? extends Command>, Class<? extends CommandHandler>> indexedCommandHandlers;


    public Class<? extends CommandHandler> search(Class<? extends Command> commandClass) throws CommandNotRegisteredError {
        Class<? extends CommandHandler> commandHandlerClass = indexedCommandHandlers.get(commandClass);

        if (null == commandHandlerClass) {
            throw new CommandNotRegisteredError(commandClass);
        }

        return commandHandlerClass;
    }
}
