package counter;

import parser.Parser;

import java.util.HashMap;

public class AnimalCounter implements ICounter {
    final HashMap<String, Integer> values;

    public AnimalCounter() {
        this.values = new HashMap<>();
    }

    /**
     * Метод считает животных, удовлетворяющих правилам, и записывает в values
     *
     * @param data  - массив строк, характеристики одного животного - отдельная строка
     * @param rules - массив строк, одно правило - отдельная строка
     */
    @Override
    public void count(final String[] data, final String[] rules) {
        for (final String rule : rules) {
            int countAnimal = 0;
            for (final String animal : data) {
                if (Parser.parse(animal.toLowerCase(), rule.toLowerCase())) {
                    countAnimal++;
                }
            }
            values.put(rule, countAnimal);
        }
    }

    @Override
    public HashMap<String, Integer> getValues() {
        return values;
    }

    @Override
    public void printValues() {
        for (final String rule : values.keySet()) {
            System.out.println(rule + " - " + values.get(rule));
        }
    }

    @Override
    public void clear() {
        values.clear();
    }
}
