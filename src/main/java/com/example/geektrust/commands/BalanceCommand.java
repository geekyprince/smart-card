package com.example.geektrust.commands;

import com.example.geektrust.contract.input.impl.BalanceInput;
import com.example.geektrust.service.impl.CardServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class BalanceCommand implements Command<BalanceInput> {
    private final CardServiceImpl cardService;

    public BalanceCommand(CardServiceImpl cardService) {
        this.cardService = cardService;
    }

    @Override
    public void execute(BalanceInput input) {
        cardService.createCard(input.getCardId(), input.getAmount());
    }

    @Override
    public CommandType commandType() {
        return CommandType.BALANCE;
    }
}
