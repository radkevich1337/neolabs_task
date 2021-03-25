package parser;

import java.util.*;

public class AnimalParser implements IParser {

    /**
     * Метод проверяет животное на соответствие правилу
     *
     * @param data - строка с параметрами животного
     * @param rule - строка с правилом
     */
    public boolean parse(final String data, final String rule) {
        final List<String> dataSet = Arrays.asList(data.split(","));

        return Arrays.stream(rule.split(" или ")).anyMatch(ruleSplitOr ->
                Arrays.stream(ruleSplitOr.split(" и ")).allMatch(
                        ruleSplitAnd -> checkContains(dataSet, ruleSplitAnd)
                )
        );
    }

    /**
     *  Метод проверяет на (не) принадлежность признака животному
     *
     * @param data - список свойств животного
     * @param rule - односложное правило для проверки
     */
    private boolean checkContains(final Collection<String> data, final String rule) {
        return  ((rule.contains("не ") && !data.contains(rule.split("не ")[1].trim())) ||
                (!rule.contains("не ") && data.contains(rule.trim())));
    }
}
