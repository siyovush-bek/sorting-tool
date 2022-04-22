package sorting;

import java.io.*;
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
            case "-inputFile":
                r = "input file";
                break;
            case "-outputFile":
                r = "output file";
                break;
        }
        return r;
    }

    public static void main(final String[] args) {

        Set<String> set = Set.of("-dataType", "-sortingType",
                "-inputFile", "-outputFile");
        for(String arg : args) {
            if(arg.startsWith("-") && !set.contains(arg)) {
                System.out.printf("\"%s\" is not a valid parameter. It will be skipped.", arg);
            }
        }

        Map<String, Integer> indexMap = new HashMap<>();
        for(int i = 0; i < args.length; i++) {
            if(set.contains(args[i])) {
                indexMap.put(args[i], i);
            }
        }

        Map<String, String> map = new HashMap<>();

        indexMap.forEach((k, v) -> {
            if(args.length - 1 > v + 1 && args[v+1].startsWith("-")){
                System.out.println("No " + getName(k) + " defined!");
                System.exit(0);
            } else if(args.length - 1 >= v + 1) {
                map.put(k, args[v+1]);
            }
        });


        String dataType = map.getOrDefault("-dataType", "long");
        String sortingType = map.getOrDefault("-sortingType", "natural");

        String inputFile = map.getOrDefault("-inputFile", "");
        String outputFile = map.getOrDefault("-outputFile", "");


        // specify input source
        Scanner scanner;
        PrintWriter writer = null;
        boolean writeToFile = false;
        if(!outputFile.equals("")) {
            File f = new File(outputFile);
            writeToFile = true;
            try {
                f.createNewFile();
                writer = new PrintWriter(f);
            } catch (FileNotFoundException e) {
                System.out.println("File not found");
            } catch (IOException e) {
                System.out.println("IO error occured");
            }
        }
        else {
            writer = new PrintWriter(System.out, true);
        }
        
        // and output destiny
        if(!inputFile.equals("")) {
            File f = new File(inputFile);

            scanner = new Scanner(inputFile);
        } else {
            scanner = new Scanner(System.in);
        }

        Container container = Container.create(dataType, scanner, writer);

        container.getInputs();
        container.describe();
        container.sort(sortingType);


        scanner.close();
        if(writeToFile) {
            writer.close();
        }


    }
}
