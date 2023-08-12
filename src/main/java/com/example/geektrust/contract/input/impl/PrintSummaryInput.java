package com.example.geektrust.contract.input.impl;

import com.example.geektrust.commands.CommandType;
import com.example.geektrust.contract.input.Input;

public class PrintSummaryInput implements Input {
    private final CommandType type;

    public PrintSummaryInput(CommandType type) {
        this.type = type;
    }
    @Override
    public CommandType commandType() {
        return CommandType.PRINT_SUMMARY;
    }

}
