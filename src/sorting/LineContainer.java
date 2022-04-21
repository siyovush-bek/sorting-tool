package sorting;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Scanner;

public class LineContainer extends WordContainer {


    public LineContainer(Scanner scanner) {
        super(scanner);
    }

    @Override
    public void getInputs() {
        while(scanner.hasNextLine()) {
            String next = scanner.nextLine();
            list.add(next);
            counter.put(next, counter.getOrDefault(next, 0) + 1);
        }
    }

    @Override
    public void describe() {
        System.out.printf("Total lines: %d.\n", list.size());
    }
    
}
