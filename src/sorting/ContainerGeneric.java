package sorting;

import java.util.*;
import java.util.function.Function;

@Deprecated
public class ContainerGeneric<T> {
    ArrayList<T> list;
    private Scanner scanner;
    private Comparator<T> comparator;
    private String dtype;
    private String adjective;

    ContainerGeneric(String dtype, String adjective, Scanner scanner, Comparator<T> comp){
        this.scanner = scanner;
        this.comparator = comp;
        this.dtype = dtype;
        this.adjective = adjective;
        this.list = new ArrayList<>();
    }

    public void getInputs(Function<Scanner, Boolean> checkFunc, Function<Scanner, T> getFunc) {
        while(checkFunc.apply(scanner)) {
            T item = getFunc.apply(scanner);
            list.add(item);
        }
    }

    public int size() {
        return list.size();
    }

    public T max() {
        return Collections.max(list, comparator);
    }

    public int maxCount() {
        T m = this.max();
        int count = 0;
        for(T item : list) {
            if(item.equals(m)) {
                count++;
            }
        }
        return count;
    }

    public void describe() {
        T m = this.max();
        int count = maxCount();
        int maxPercentage = count * 100 / size();
        String extra = dtype.equals("line") ? "\n" : " ";
        System.out.printf("Total %ss: %d.\nThe %s %s:" + extra + "%s" + extra + "(%d time(s), %d%%).",
                dtype, size(), adjective, dtype, m.toString(), count, maxPercentage);


    }



}
