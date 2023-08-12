package com.example.geektrust.commands;

import com.example.geektrust.contract.input.impl.PrintSummaryInput;
import com.example.geektrust.service.SummaryService;
import org.springframework.stereotype.Component;

@Component
public class PrintSummaryCommand implements Command<PrintSummaryInput> {
    private final SummaryService summaryService;

    public PrintSummaryCommand(SummaryService summaryService) {
        this.summaryService = summaryService;
    }

    @Override
    public void execute(PrintSummaryInput input) {
        summaryService.printSummary();
    }

    @Override
    public CommandType commandType() {
        return CommandType.PRINT_SUMMARY;
    }
}
