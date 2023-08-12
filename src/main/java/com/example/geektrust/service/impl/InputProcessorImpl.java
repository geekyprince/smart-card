package com.example.geektrust.service.impl;

import com.example.geektrust.commands.CommandExecutor;
import com.example.geektrust.contract.input.Input;
import com.example.geektrust.service.InputParser;
import com.example.geektrust.service.InputProcessor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;


@Component
public class InputProcessorImpl implements InputProcessor {

    private static final Logger logger = LoggerFactory.getLogger(InputProcessorImpl.class);

    @Autowired
    private InputParser inputParser;
    @Autowired
    private CommandExecutor commandExecutor;


    @Override
    public void processFilePath(String filePath) {
        try {
            List<String> allLines = Files.readAllLines(Paths.get(filePath));
            for (String line : allLines) {
                logger.info("Processing line: {}", line);
                processLine(line);
            }
        } catch (IOException e) {
            logger.error("IO exception occurred while processing line", e);
            e.printStackTrace();
        }
    }

    @Override
    public void processLine(String line) {
        Input input = inputParser.parse(line);
        commandExecutor.execute(input);
    }
}
