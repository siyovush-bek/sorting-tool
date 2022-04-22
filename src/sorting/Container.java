package sorting;

import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.Scanner;

public interface Container {

    void getInputs();
    void sortByCount();
    void sortNatural();
    void describe();

    static Container create(String dataType, Scanner scanner, PrintWriter writer) {
        Container container;
        switch (dataType) {
            case "line":
                container = new LineContainer(scanner, writer);
                break;
            case "word":
                container = new WordContainer(scanner, writer);
                break;
            case "long":
                container = new LongContainer(scanner, writer);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + dataType);
        }
        return container;
    }

    default void sort(String sortType) {
        if(sortType.equals("natural")){
            sortNatural();
        } else  if(sortType.equals("byCount")) {
            sortByCount();
        }
    }
}
