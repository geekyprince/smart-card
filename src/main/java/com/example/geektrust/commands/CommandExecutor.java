package com.example.geektrust.commands;


import com.example.geektrust.contract.input.Input;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class CommandExecutor {
    private  final List<Command> commands;
    private  final HashMap<CommandType, Command> commandsMap = new HashMap<>();

    @Autowired
    public CommandExecutor(List<Command> commands) {
        this.commands = commands;
        commands.forEach(command -> commandsMap.put(command.commandType(), command));

    }

    public void execute (Input input) {
        if (commandsMap.containsKey(input.commandType())) {
            Command command = commandsMap.get(input.commandType());
            command.execute(input);
        } else {
            throw new IllegalArgumentException(String.format("Invalid input %s", input));
        }
    }

}