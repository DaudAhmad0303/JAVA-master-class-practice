package dev.lpa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class LambdaExpressionChallenge2 {

    private static Random random = new Random();
    public static void main(String[] args) {
        String[] strings = {"Anna", "Bob", "Carel", "david", "emme"};
//        Arrays.asList(strings).forEach(s -> System.out.println(s.toUpperCase()));

        System.out.println("--> Transform to Uppercase");
        Arrays.setAll(strings, i -> strings[i].toUpperCase());
        System.out.println(Arrays.toString(strings));

        List<String> backedByArray = Arrays.asList(strings);

        System.out.println("--> Add random middle initial");
        backedByArray.replaceAll(s -> s += " " + getRandomChar('A', 'D') + ".");
        System.out.println(Arrays.toString(strings));

        System.out.println("--> Add reversed name as last name");
        backedByArray.replaceAll(s -> s += " " + getReversedName(s.split(" ")[0]));
        Arrays.asList(strings).forEach(s -> System.out.println(s));

        List<String> newList = new ArrayList<>(List.of(strings));
        System.out.println("--> Removed all names whose first and last name match");
//        backedByArray.removeIf(s -> {
//            String firstName = s.split(" ")[0];
//            String lastName = s.split(" ")[s.split(" ").length - 1];
//            System.out.println(firstName + " -- " + lastName);
//            System.out.println(getReversedName(firstName).compareTo(lastName));
//            return false;
//        });
//        backedByArray.forEach(s -> System.out.println(s));

        newList.removeIf(s -> s.substring(0, s.indexOf(" ")).equals(
                s.substring(s.lastIndexOf(" ") + 1)
        ));
        newList.forEach(s -> System.out.println(s));




    }

    public static char getRandomChar(char startChar, char endChar) {
        return (char) random.nextInt((int) startChar, (int) endChar + 1);
    }

    public static String getReversedName(String firstName) {
        return new StringBuilder(firstName).reverse().toString();
    }
}
