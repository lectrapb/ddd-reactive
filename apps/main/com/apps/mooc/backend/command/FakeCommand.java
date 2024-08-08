package com.apps.mooc.backend.command;

import org.springframework.stereotype.Service;
import tv.codely.shared.infra.cli.ConsoleCommand;

@Service
public class FakeCommand extends ConsoleCommand {

    @Override
    public void execute(String[] args){
        info("this is a fake command");
    }
}
