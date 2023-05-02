package io.github.lantalex;

import org.junit.jupiter.api.Test;
import org.openjdk.jol.info.ClassLayout;
import org.openjdk.jol.info.GraphLayout;

import java.util.HashMap;
import java.util.Map;

public class JolSampleTest {

    @Test
    void classTest() {
        System.out.println(ClassLayout.parseClass(Int2IntMapImpl.class).toPrintable());
        System.out.println(ClassLayout.parseClass(HashMap.class).toPrintable());
    }


    @Test
    void instanceTest() {

        Int2IntMap map = new Int2IntMapImpl(10, 0.75f);
        for (int i = 0; i < 10000; i++) {
            map.put(i, i + 1);
        }

        System.out.println(GraphLayout.parseInstance(map).toFootprint());

        Map<Integer, Integer> values = new HashMap<>();
        map.forEntries(values::put);

        System.out.println(GraphLayout.parseInstance(values).toFootprint());
    }
}
