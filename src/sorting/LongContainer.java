package sorting;

import java.util.*;

public class LongContainer implements Container{
    private ArrayList<Long> list;
    private Scanner scanner;
    private HashMap<Long, Integer> counter;
    public LongContainer(Scanner scanner) {
        this.list = new ArrayList<>();
        this.scanner = scanner;
        this.counter = new HashMap<>();
    }

    @Override
    public void getInputs() {
        while(scanner.hasNextLong()) {
            long l = scanner.nextLong();
            list.add(l);
            counter.put(l, counter.getOrDefault(l, 0) + 1);
        }
    }

    @Override
    public void sortByCount(){

        ArrayList<Long> keys = new ArrayList<>(counter.keySet());
        keys.sort(Comparator.naturalOrder());
        keys.sort(Comparator.comparingInt(o -> counter.get(o)));

        for(Long l : keys) {
            int count = counter.get(l);
            int percentage = count * 100 / list.size();
            System.out.printf("%d: %d time(s), %d%%\n",
                    l, count, percentage);
        }
    }

    @Override
    public void sortNatural(){
        list.sort((o1, o2) -> (int)(o1-o2));
        System.out.print("Sorted data:");
        for(Long l : list) {
            System.out.print(' ');
            System.out.print(l);
        }
    }

    @Override
    public void describe() {
        System.out.printf("Total numbers: %d.\n", list.size());
    }
}
