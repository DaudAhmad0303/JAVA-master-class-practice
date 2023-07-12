package dev.lpa;

import java.util.ArrayList;

public class ArrayListChallenge {
    public static void main(String[] args) {
        String promptToDisplay = """
                Available actions:
                0 - to shutdown
                1 - to add item(s) to list (comma delimited list)
                2 - to remove any items (comma delimited list)
                3 - to display the list
                Enter a number for which action you want to do:""";
        int input = 0;
        ArrayList<String> grocery = new ArrayList<>();
//        do {
//            System.out.print(promptToDisplay + " ");
//            Scanner scanner = new Scanner(System.in);
//            input = Integer.parseInt(scanner.nextLine());
//
//            if (input == 0){
//                break;
//            }
//            else if (input == 1) {
//                System.out.print("Enter comma delimited list of groceries: ");
//                String commaDelimitedItems = scanner.nextLine();
//                String[] list = commaDelimitedItems.split(",");
//                for (int i = 0; i < list.length; i++) {
//                    String item = list[i].trim();
//                    if (grocery.contains(item)) {
//                        System.out.println(item + " is already in the list...!");
//                    }else {
//                        grocery.add(item);
//                    }
//                }
//                System.out.println("Items in the Grocery List: " + grocery);
//            }
//            else if (input == 2) {
//                System.out.print("Enter comma delimited list of groceries to remove: ");
//                String commaDelimitedItems = scanner.nextLine();
//                String[] list = commaDelimitedItems.split(",");
//                for (int i = 0; i < list.length; i++) {
//                    String item = list[i].trim();
//                    if (grocery.contains(item)) {
//                        grocery.remove(item);
//                    }else {
//                        System.out.printf("'%s' is not in list...!%n", item);
//                    }
//                }
//                System.out.println("Items in the Grocery List: " + grocery);
//            } else if (input == 3) {
//                System.out.println("Items in the Grocery List: " + grocery);
//            } else {
//                System.out.println("Invalid input! Enter from menu...!");
//            }
//        } while (true);

        ArrayList<Integer> intList = new ArrayList<>(10);
        for (int i = 0; i < 7; i++) {
            intList.add((i + 1) * 5);
        }
        System.out.println(intList);



    }
}
