package main;

import counter.AnimalCounter;
import counter.ICounter;
import loader.ILoader;
import loader.DataFileLoader;
import parser.AnimalParser;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        final ILoader loader = new DataFileLoader();
        final ICounter counter = new AnimalCounter(new AnimalParser());
        final String[] data;
        final String[] rules;

        try {
            data = loader.load("input\\animals.txt");
            rules = loader.load("input\\rules.txt");
            counter.count(data, rules);
            counter.printValues();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
