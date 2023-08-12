package com.example.geektrust.commands;

public interface Command<INPUT>{
    void execute(INPUT input);
    CommandType commandType();
}
