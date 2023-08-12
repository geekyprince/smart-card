package com.example.geektrust.commands.parsers.impl;

import com.example.geektrust.commands.CommandType;
import com.example.geektrust.commands.parsers.Parser;
import com.example.geektrust.contract.input.impl.BalanceInput;

public class BalanceInputParser implements Parser<BalanceInput> {
    @Override
    public BalanceInput parseInput(String[] input) {
        return new BalanceInput(input[1], Double.valueOf(input[2]));
    }

    @Override
    public CommandType commandType() {
        return CommandType.BALANCE;
    }
}
