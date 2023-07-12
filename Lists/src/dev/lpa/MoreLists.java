package dev.lpa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MoreLists {
    public static void main(String[] args) {
        String[] items = {"apples", "bananas", "milk", "eggs"};

        List<String> list = List.of(items);
        System.out.println(list);

        System.out.println(list.getClass().getName());
//        list.add("yogurt");

        ArrayList<String> groceries = new ArrayList<>(list);
        groceries.add("yogurt");
        System.out.println(groceries);

        ArrayList<String> nextList = new ArrayList<>(
                List.of("pickles", "mustard", "cheese")
        );
        System.out.println(nextList);

        groceries.addAll(nextList);
        System.out.println(groceries);

//        Accessing elements in ArrayList
        System.out.println("Third item = " + groceries.get(4));


//        Further methods related to ArrayList
        if (groceries.contains("mustard")) {
            System.out.println("List contains mustard");
        }

        groceries.add("yogurt");
        System.out.println("first = " + groceries.indexOf("yogurt"));
        System.out.println("last = " + groceries.lastIndexOf("yogurt"));

        System.out.println(groceries);
//        removing element using index
        groceries.remove(1);
        System.out.println(groceries);
//        removing element using object/literal
        groceries.remove("yogurt");
        System.out.println(groceries);

//        removing multiple elements from ArrayList
        groceries.removeAll(List.of("apples", "eggs"));
        System.out.println(groceries);

        groceries.retainAll(List.of("apples", "milk", "mustard",
                "cheese"));
        System.out.println(groceries);

        groceries.clear();
        System.out.println(groceries);
        System.out.println("isEmpty = " + groceries.isEmpty());

//        adding to ArrayList using List factory method
        groceries.addAll(List.of("apples", "milk", "mustard",
                "cheese"));
//        adding to ArrayList using Array factory method
        groceries.addAll(Arrays.asList("eggs", "pickles", "mustard", "ham"));

        System.out.println(groceries);

//        Sort method on ArrayList
        groceries.sort(Comparator.naturalOrder());
        System.out.println(groceries);

        groceries.sort(Comparator.reverseOrder());
        System.out.println(groceries);

//        converting ArrayList to Array
        var groceryArray = groceries.toArray(new String[groceries.size()]);
        System.out.println(Arrays.toString(groceryArray));
        System.out.println(groceryArray.getClass().getSimpleName());

//        We can only create ArrayList of non-primitive data types.
//        Since, String is a non-primitive data type. So we were working with it.

//        If we provide the size in the method toArray less than the actual ArrayList size
//        then the size of the array will expand to the size of original ArrayList
        ArrayList<String> stringLists = new ArrayList<>((List.of("Jan", "Feb", "Mar")));
        String[] stringArray = stringLists.toArray(new String[0]);
        System.out.println(Arrays.toString(stringArray) + " --- " + stringArray.getClass().getSimpleName());

    }
}
