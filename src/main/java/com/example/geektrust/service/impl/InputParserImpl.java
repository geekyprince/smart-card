package com.example.geektrust.service.impl;

import com.example.geektrust.commands.CommandType;
import com.example.geektrust.commands.parsers.Parser;
import com.example.geektrust.commands.parsers.impl.BalanceInputParser;
import com.example.geektrust.commands.parsers.impl.CheckInInputParser;
import com.example.geektrust.commands.parsers.impl.PrintSummaryInputParser;
import com.example.geektrust.contract.input.Input;
import com.example.geektrust.exception.InvalidCommandException;
import com.example.geektrust.service.InputParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


@Component
public class InputParserImpl implements InputParser {

    private final HashMap<CommandType, Parser> inputParsers = new HashMap<>();

    @Autowired
    public InputParserImpl() {
        List<Parser> parsers = new ArrayList<>();
        parsers.add(new BalanceInputParser());
        parsers.add(new CheckInInputParser());
        parsers.add(new PrintSummaryInputParser());
        parsers.forEach(parser -> inputParsers.put(parser.commandType(), parser));
    }
    @Override
    public Input parse(String line) {
        String[] input = line.split(" ");
        CommandType commandType = CommandType.valueOf(input[0]);
        if (!inputParsers.containsKey(commandType)) {
            throw new InvalidCommandException(String.format("Invalid command %s", commandType.name()));
        }
        Parser parser = inputParsers.get(commandType);
        return parser.parseInput(input);
    }
}
