package counter;

import java.util.HashMap;

public interface ICounter {
    void count(String[] data, String[] rules);
    HashMap<String, Integer> getValues();
    void printValues();
    void clear();
}
