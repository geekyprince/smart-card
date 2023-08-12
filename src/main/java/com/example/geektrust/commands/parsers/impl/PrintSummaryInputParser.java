package com.example.geektrust.commands.parsers.impl;

import com.example.geektrust.commands.CommandType;
import com.example.geektrust.commands.parsers.Parser;
import com.example.geektrust.contract.input.impl.PrintSummaryInput;

public class PrintSummaryInputParser implements Parser<PrintSummaryInput> {
    @Override
    public PrintSummaryInput parseInput(String[] input) {
        return new PrintSummaryInput(CommandType.PRINT_SUMMARY);
    }

    @Override
    public CommandType commandType() {
        return CommandType.PRINT_SUMMARY;
    }
}
