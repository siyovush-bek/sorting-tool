package sorting;

import java.util.*;

public class Main {

    public static String getName(String name) {
        String r = "";
        switch(name){
            case "-dataType":
                r = "data type";
                break;
            case "-sortingType":
                r = "sorting type";
                break;
        }
        return r;
    }

    public static void main(final String[] args) {
        String dataType = "", sortingType = "";

        Set<String> set = Set.of("-dataType", "-sortingType");
        for(String arg : args) {
            if(arg.startsWith("-") && !set.contains(arg)) {
                System.out.printf("\"%s\" is not a valid parameter. It will be skipped.", arg);
            }
        }

        Map<String, Integer> map = new HashMap<>();
        for(int i = 0; i < args.length; i++) {
            if(set.contains(args[i])) {
                map.put(args[i], i);
            }
        }

        Map<String, String> stringMap = new HashMap<>();

        map.forEach((k, v) -> {
            if(args.length - 1 > v + 1 && args[v+1].startsWith("-")){
                System.out.println("No " + getName(k) + " defined!");
                System.exit(0);
            } else if(args.length - 1 >= v + 1) {
                stringMap.put(k, args[v+1]);
            }
        });


        dataType = stringMap.getOrDefault("-dataType", "long");
        sortingType = stringMap.getOrDefault("-sortingType", "natural");

        Scanner scanner = new Scanner(System.in);
        Container container = Container.create(dataType, scanner);

        container.getInputs();
        container.describe();
        container.sort(sortingType);

    }
}
