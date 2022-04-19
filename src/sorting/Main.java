package sorting;

import java.util.*;

public class Main {
    public static void main(final String[] args) {
        String dtype = "";
        if(args.length > 1) {
            dtype = args[1];
        }
        boolean sortIntegers =  Arrays.asList(args).contains("-sortIntegers");
        Scanner scanner = new Scanner(System.in);
        if(sortIntegers) {
            ArrayList<Long> list = new ArrayList<>();
            while(scanner.hasNextLong()) {
                list.add(scanner.nextLong());
            }
            list.sort(((o1, o2) -> (int) (o1-o2)));
            System.out.printf("Total numbers: %d.\n", list.size());
            System.out.print("Sorted data:");
            for(int i = 0; i < list.size(); i++) {
                System.out.print(" ");
                System.out.print(list.get(i));
            }
        } else {
            if(dtype.equals("long")) {
                Container<Long> container = new Container<>("number", "greatest", scanner,
                        (o1, o2) -> (int)(o1 - o2));

                container.getInputs(Scanner::hasNextLong, Scanner::nextLong);
                container.describe();
            } else if(dtype.equals("line")) {
                Container<String> container = new Container<>("line", "longest", scanner,
                        Comparator.comparingInt(String::length));

                container.getInputs(Scanner::hasNextLine, Scanner::nextLine);
                container.describe();
            } else if(dtype.equals("word")) {
                Container<String> container = new Container<>("word", "longest", scanner,
                        Comparator.comparingInt(String::length));

                container.getInputs(Scanner::hasNext, Scanner::next);
                container.describe();
            }
        }



    }
}
