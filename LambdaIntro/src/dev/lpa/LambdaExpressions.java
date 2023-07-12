package dev.lpa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Supplier;

public class LambdaExpressions {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>(List.of(
                "alpha", "bravo", "charlie", "delta"));

        for (String s : list) {
            System.out.println(s);
        }

        System.out.println("_".repeat(30));
        list.forEach((myString) -> System.out.println(myString));


        System.out.println("_".repeat(30));
        String prefix = "nato";
        list.forEach((var myString) -> {
            char first = myString.charAt(0);
            System.out.println(prefix + " " + myString + " means " + first);
        });
//        If we use any variable in Lambda expression, it should be final.
//        We cannot make changes to this variable afterwards.
//        prefix = "NATO";

//        --------------------------------------------------------------------------

        int result = calculator((a, b) -> a - b, 5, 2);
        var result2 = calculator((Double a, Double b) -> a / b, 10.0, 2.5);
        var result3 = calculator(
                (a, b) -> a.toUpperCase() + " " + b.toUpperCase(), "Ralph", "Kramden");

        // return statement is mandatory if we write our expression in curly braces.
        var result4 = calculator((var a, var b) -> {
            int c = a + b;
            return c;}, 10, 3);

        System.out.println("_".repeat(30));

//        ------------------------------------------------------------------------
//        BiConsumer Lambda Expressions
        var coords = Arrays.asList(
                new double[]{47.2160, -95.2348},
                new double[]{29.1566, -89.2495},
                new double[]{35.1556, -90.0659});

        coords.forEach(s -> System.out.println(Arrays.toString(s)));

        BiConsumer<Double, Double> p1 = (lat, lng) ->
                System.out.printf("[lat:%.3f lon:%.3f]%n", lat, lng);

        var firstPoint = coords.get(0);
        processPoint(firstPoint[0], firstPoint[1], p1);

        System.out.println("_".repeat(30));
        coords.forEach(s -> processPoint(s[0], s[1], p1));
        coords.forEach(s -> processPoint(s[0], s[1],
                (lat, lng) ->
                        System.out.printf("[lat:%.3f lon:%.3f]%n", lat, lng)));

        System.out.println("_".repeat(30));
//        -----------------------------------------------------------------------
//        Predicate Lambda Expression
        list.removeIf(s -> s.equalsIgnoreCase("bravo"));
        list.forEach(s -> System.out.println(s));

        list.addAll(List.of("echo", "easy", "earnest"));
        list.forEach(s -> System.out.println(s));

        System.out.println("_".repeat(30));
        list.removeIf(s -> s.startsWith("ea"));
        list.forEach(s -> System.out.println(s));

        System.out.println("_".repeat(30));

//        Function Lambda Expression
//        This is a type of unary operator, since we get the same data type
//        returned as we pass to it.
        list.replaceAll((s -> s.charAt(0) + " - " + s.toUpperCase()));
        list.forEach(s -> System.out.println(s));

        String[] emptyStrings = new String[10];
        System.out.println(Arrays.toString(emptyStrings));
        Arrays.fill(emptyStrings, "");
        System.out.println(Arrays.toString(emptyStrings));

        Arrays.setAll(emptyStrings, (i) -> (i + 1) + ". ");
        System.out.println(Arrays.toString(emptyStrings));

        Arrays.setAll(emptyStrings, (i) -> (i + 1) + ". "
                + switch (i) {
            case 0 -> "one";
            case 1 -> "two";
            case 2 -> "three";
            default -> "";
        });
        System.out.println(Arrays.toString(emptyStrings));

        String[] names = {"Anna", "Bob", "Carol", "David", "Ed", "Fred"};
        String[] randomList = randomlySelectedValues(15, names,
                () -> new Random().nextInt(0, names.length));
        System.out.println(Arrays.toString(randomList));


    }

    public static <T> T calculator(BinaryOperator<T> function, T value1, T value2) {
        T result = function.apply(value1, value2);
        System.out.println("Result of operation: " + result);
        return result;
    }

//    public static <T> T calculator(Operation<T> function, T value1, T value2) {
//        T result = function.operate(value1, value2);
//        System.out.println("Result of operation: " + result);
//        return result;
//    }

//    Types of functional interfaces in java.util.function
//    1. Consumer  | void accept(T t)   | execute code without returning data
//    2. Function  | R apply(T t)       | return a result of an operation or function
//    3. Predicate | boolean test(T t)  | test if a condition is true or false
//    4. Supplier  | T get()            | return an instance of something

    public static <T> void processPoint(T t1, T t2, BiConsumer<T, T> consumer){
        consumer.accept(t1, t2);
    }

//    This method returns an array of strings by randomly selected strings
//    from the array of strings passed of the specified length.
    public static String[] randomlySelectedValues(int count,
                                                  String[] values,
                                                  Supplier<Integer> s) {
        String[] selectedValues = new String[count];
        for (int i = 0; i < count; i++) {
            selectedValues[i] = values[s.get()];
        }
        return selectedValues;
    }

}
