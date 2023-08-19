package com.example.geektrust;

import com.example.geektrust.service.InputProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Geektrust implements CommandLineRunner {

    @Autowired
    InputProcessor inputProcessor;

    public static void main(String[] args) {
        SpringApplication.run(Geektrust.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
//        if(args.length < MIN_ARGS) {
//            throw new Exception("Please mention the input file");
//        }
//        inputProcessor.processFilePath(args[FIRST_ARG]);
        inputProcessor.processFilePath("src/main/resources/input1.txt");

    }
}
