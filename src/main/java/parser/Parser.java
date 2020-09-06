package parser;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Parser {

    /**
     * Метод проверяет животное на соответствие правилу
     *
     * @param data - строка с параметрами животного
     * @param rule - строка с правилом
     */
    public static boolean parse(final String data, final String rule) {
        final Set<String> dataSet = new HashSet<>(Arrays.asList(data.split(",")));
        boolean flag = false;
        boolean flagOr;

        for (final String ruleOr : rule.split(" или ")) {
            flagOr = true;
            for (final String ruleAnd : ruleOr.split(" и ")) {
                if (!ruleAnd.contains("не ")) {
                    if (!dataSet.contains(ruleAnd.trim())) {
                        flagOr = false;
                    }
                } else {
                    if (dataSet.contains(ruleAnd.split("не ")[1].trim())) {
                        flagOr = false;
                    }
                }
            }
            flag |= flagOr;
        }

        return flag;
    }
}
