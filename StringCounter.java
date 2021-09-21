package Task09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class StringCounter {
    public static final int NUMBER_OF_REPEATED_STRINGS = 2;

    public static void main(String[] args) throws IOException {
        Map<String, Integer> map = new HashMap<>();

        System.out.println("Вводите строки. Для выхода напишите end");

        while (true) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String str = reader.readLine();
            if (!str.equals("end")) {
                if (map.containsKey(str)) {
                    map.put(str, map.get(str) + 1);
                } else {
                    map.put(str, 1);
                }
            } else {
                break;
            }
        }

        System.out.println("Количество введенных строк: \n" + map);

        TreeSet<Element> set = new TreeSet<>(new Comparator<>() {
            @Override
            public int compare(Element o1, Element o2) {
                return Integer.compare(o2.freq, o1.freq);
            }
        });
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            Element curr = new Element(entry.getKey(), entry.getValue());
            set.add(curr);
        }

        int index = 0;
        System.out.println("\n" + NUMBER_OF_REPEATED_STRINGS + " строки, которые вводились чаще остальных: ");
        for (Element element : set) {
            System.out.println(element.value + " ");
            index++;
            if (index == NUMBER_OF_REPEATED_STRINGS)
                break;
        }
    }

    static class Element {
        String value;
        int freq;

        public Element(String value, int freq) {
            this.value = value;
            this.freq = freq;
        }
    }
}



