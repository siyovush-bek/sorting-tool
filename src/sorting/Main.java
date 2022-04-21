package sorting;

import java.util.*;

public class Main {
    public static void main(final String[] args) {
        String dataType = "", sortingType = "";

        for (int i = 0; i < args.length; i++) {
            if(args[i].equals("-dataType")) {
                i++;
                dataType = args[i];
            } else if(args[i].equals("-sortingType")){
                i++;
                sortingType = args[i];
            }
        }

        dataType = dataType.equals("") ? "long" : dataType;
        sortingType = sortingType.equals("") ? "natural" : sortingType;

        Scanner scanner = new Scanner(System.in);
        Container container = Container.create(dataType, scanner);

        container.getInputs();
        container.describe();
        container.sort(sortingType);

    }
}
