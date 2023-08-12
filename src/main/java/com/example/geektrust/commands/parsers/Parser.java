package com.example.geektrust.commands.parsers;

import com.example.geektrust.commands.CommandType;
import com.example.geektrust.contract.input.Input;

public interface Parser<T extends Input> {
    T parseInput(String[] input);

    CommandType commandType();

}
