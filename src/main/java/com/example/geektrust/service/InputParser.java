package com.example.geektrust.service;

import com.example.geektrust.contract.input.Input;

public interface InputParser {
    Input parse(String line);
}
