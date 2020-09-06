package main;

import counter.AnimalCounter;
import counter.ICounter;
import loader.ILoader;
import loader.Loader;

public class Main {
    public static void main(String[] args) {
        final ILoader loader = new Loader();
        final String[] data = loader.load("input\\animals.txt");
        final String[] rules = loader.load("input\\rules.txt");

        final ICounter counter = new AnimalCounter();
        counter.count(data, rules);
        counter.printValues();
    }
}
