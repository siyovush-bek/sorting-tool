package sorting;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Scanner;

public class WordContainer implements Container{
    protected ArrayList<String> list;
    protected HashMap<String, Integer> counter;
    protected Scanner scanner;
    public WordContainer(Scanner scanner) {
        this.list = new ArrayList<>();
        this.scanner = scanner;
        this.counter = new HashMap<>();
    }

    @Override
    public void getInputs() {
        while(scanner.hasNext()) {
            String next = scanner.next();
            list.add(next);
            counter.put(next, counter.getOrDefault(next, 0) + 1);
        }
    }

    @Override
    public void sortByCount() {
        ArrayList<String> keys = new ArrayList<>(counter.keySet());
        keys.sort(Comparator.naturalOrder());
        keys.sort(Comparator.comparingInt(o -> counter.get(o)));

        for(String s : keys) {
            int count = counter.get(s);
            int percentage = count * 100 / list.size();
            System.out.printf("%s: %d time(s), %d%%\n",
                    s, count, percentage);
        }
    }

    @Override
    public void sortNatural() {
        list.sort(String::compareTo);
        System.out.print("Sorted data:");
        for(String s : list) {
            System.out.print(' ');
            System.out.print(s);
        }
    }

    @Override
    public void describe() {
        System.out.printf("Total words: %d.\n", list.size());
    }
}
