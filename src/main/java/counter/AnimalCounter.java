package counter;


import parser.IParser;
import java.util.Arrays;
import java.util.HashMap;

public class AnimalCounter implements ICounter {
    final HashMap<String, Integer> values;
    final IParser parser;

    public AnimalCounter(final IParser parser) {
        this.values = new HashMap<>();
        this.parser = parser;
    }

    /**
     * Метод считает животных, удовлетворяющих правилам, и записывает в values
     *
     * @param data  - массив строк, характеристики одного животного - отдельная строка
     * @param rules - массив строк, одно правило - отдельная строка
     */
    @Override
    public void count(final String[] data, final String[] rules) {
        Arrays.stream(rules).
                forEach(rule -> values.put(rule, (int)Arrays.stream(data).
                        filter(x -> parser.parse(x.toLowerCase(), rule.toLowerCase())).
                        count())
                );
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
