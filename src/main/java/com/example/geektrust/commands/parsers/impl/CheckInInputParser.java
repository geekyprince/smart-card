package com.example.geektrust.commands.parsers.impl;

import com.example.geektrust.commands.CommandType;
import com.example.geektrust.commands.parsers.Parser;
import com.example.geektrust.contract.input.impl.CheckInInput;
import com.example.geektrust.entity.enums.PassengerType;

public class CheckInInputParser implements Parser<CheckInInput> {
    @Override
    public CheckInInput parseInput(String[] input) {
        return new CheckInInput(input[1], PassengerType.valueOf(input[2]), input[3]);
    }

    @Override
    public CommandType commandType() {
        return CommandType.CHECK_IN;
    }
}
