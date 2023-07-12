package dev.lpa;

import java.util.Arrays;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class MiniLambdaChallenges {
    public static void main(String[] args) {

        String words = "Hello to the world of Programming";

        Consumer<String> printWords = new Consumer<String>() {
            @Override
            public void accept(String s) {
                String[] parts = s.split(" ");
                for (String part : parts) {
                    System.out.println(part);
                }
            }
        };
        printWords.accept(words);

        Consumer<String> printWordsLambda = s -> {
            String[] parts = s.split(" ");
            for (String part : parts) {
                System.out.println(part);
            }
        };
        printWordsLambda.accept(words);

        Consumer<String> printWordsForEach = s -> {
            String[] parts = s.split(" ");
            Arrays.asList(parts).forEach((word) -> System.out.println(word));
        };
        printWordsForEach.accept(words);

        Consumer<String> printWordsConcise = s -> {
            Arrays.asList(s.split(" ")).forEach((word) -> System.out.println(word));
        };
        printWordsConcise.accept(words);



//        ------------------------------------------------------------------------

        UnaryOperator<String> myEverySecondChar = source -> {
            StringBuilder returnVal = new StringBuilder();
            for (int i = 0; i < source.length(); i++) {
                if (i % 2 == 1) {
                    returnVal.append(source.charAt(i));
                }
            }
            return returnVal.toString();
        };

        System.out.println("-".repeat(30));
//        Arrays.asList(myEverySecondChar.apply(words)).forEach(w -> System.out.println(w));
        System.out.println(myEverySecondChar.apply(words));

        System.out.println(myEverySecondChar.apply("1234567890"));

        System.out.println(everySecondCharacter("ABCDEFGHIJKLMNOPQRSTUVWXYZ", myEverySecondChar));

//        ----------------------------------------------------------------
        Supplier<String> iLoveJava = () -> "I love Java!";

        System.out.println(iLoveJava.get());




    }

    public static String everySecondChar(String source) {

        StringBuilder returnVal = new StringBuilder();
        for (int i = 0; i < source.length(); i++) {
            if (i % 2 == 1) {
                returnVal.append(source.charAt(i));
            }
        }
        return returnVal.toString();
    }

    public static String everySecondCharacter(String source, UnaryOperator<String> operator) {
        return operator.apply(source);
    }

}
