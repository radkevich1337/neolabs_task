package counter;

import org.junit.Assert;
import org.junit.Test;

public class AnimalCounterTest {
    @Test
    public void countTest() {
        ICounter counter = new AnimalCounter();

        String[] data1 = {"ЛЕГКОЕ,МАЛЕНЬКОЕ,ВСЕЯДНОЕ", "ТЯЖЕЛОЕ,МАЛЕНЬКОЕ,ТРАВОЯДНОЕ", "ТЯЖЕЛОЕ,НЕВЫСОКОЕ,ТРАВОЯДНОЕ"};
        String[] rules1 = {"ТРАВОЯДНОЕ"};
        counter.count(data1, rules1);
        Assert.assertEquals(2, (long) counter.getValues().get("ТРАВОЯДНОЕ"));
        counter.clear();

        String[] data2 = {"СРЕДНЕЕ,МАЛЕНЬКОЕ,ТРАВОЯДНОЕ", "ЛЕГКОЕ,МАЛЕНЬКОЕ,ВСЕЯДНОЕ",
                "ТЯЖЕЛОЕ,НЕВЫСОКОЕ,ПЛОТОЯДНОЕ", "СРЕДНЕЕ,БОЛЬШОЕ,ТРАВОЯДНОЕ"};
        String[] rules2 = {"ТЯЖЕЛОЕ И НЕ МАЛЕНЬКОЕ"};
        counter.count(data2, rules2);
        Assert.assertEquals(1, (long) counter.getValues().get("ТЯЖЕЛОЕ И НЕ МАЛЕНЬКОЕ"));
        counter.clear();

        String[] data3 = {"ЛЕГКОЕ,НЕВЫСОКОЕ,ПЛОТОЯДНОЕ", "СРЕДНЕЕ,БОЛЬШОЕ,ПЛОТОЯДНОЕ", "ЛЕГКОЕ,МАЛЕНЬКОЕ,ВСЕЯДНОЕ",
                "СРЕДНЕЕ,НЕВЫСОКОЕ,ТРАВОЯДНОЕ", "ЛЕГКОЕ,МАЛЕНЬКОЕ,ТРАВОЯДНОЕ", "ТЯЖЕЛОЕ,БОЛЬШОЕ,ВСЕЯДНОЕ"};
        String[] rules3 = {"ЛЕГКОЕ И НЕ НЕВЫСОКОЕ ИЛИ СРЕДНЕЕ И ПЛОТОЯДНОЕ ИЛИ ТЯЖЕЛОЕ"};
        counter.count(data3, rules3);
        Assert.assertEquals(4, (long) counter.getValues().get("ЛЕГКОЕ И НЕ НЕВЫСОКОЕ ИЛИ СРЕДНЕЕ И ПЛОТОЯДНОЕ ИЛИ ТЯЖЕЛОЕ"));
        counter.clear();

        String[] data4 = { };
        String[] rules4 = {"ТЯЖЕЛОЕ"};
        counter.count(data4, rules4);
        Assert.assertEquals(0, (long) counter.getValues().get("ТЯЖЕЛОЕ"));
    }
}
