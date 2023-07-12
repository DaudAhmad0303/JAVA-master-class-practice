package dev.lpa;

import java.util.Arrays;
import java.util.Scanner;

public class Main2 {
    public static void main(String... args) {
        System.out.println("Hello World again");

        String[] splitStrings = "Hello World again".split(" ");
        printText(splitStrings);

        System.out.println("-".repeat(20));
        printText("Hello");

        System.out.println("-".repeat(20));
        printText("Hello", "World", "Again");

        System.out.println("-".repeat(20));
        printText();

        String[] sArray = {"first", "second", "third", "fourth", "fifth"};
        System.out.println(String.join("-", sArray));

//        System.out.println(Arrays.toString(readIntegers()));

//        System.out.println("Minimum Number entered: "+findMin(readIntegers()));

//        int[] intList = {0, 1, 2, 3, 4, 5};
//        System.out.println("Array before reverse: " + Arrays.toString(intList));
//        reverse(intList);
//        System.out.println("Array after reverse: " + Arrays.toString(intList));

        int[][] array2 = new int[4][4];
        System.out.println(Arrays.toString(array2));
        System.out.println("array2.length = " + array2.length);


        for (int[] outer : array2) {
            System.out.println(Arrays.toString(outer));
        }

        for (int i = 0; i < array2.length; i++) {
            var innerArray = array2[i];
            for (int j = 0; j < innerArray.length; j++) {
//                System.out.print(array2[i][j] + " ");
                array2[i][j] = (i * 10) + (j + 1);
            }
//            System.out.println();
        }
        System.out.println("-".repeat(20));

        for (var outer : array2) {
            for (var element : outer) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
        System.out.println("-".repeat(20));

        System.out.println(Arrays.deepToString(array2));

        System.out.println("-".repeat(20));

//        Multi-Dimensional arrays

        array2[1] = new int[]{10, 120, 30};
        System.out.println(Arrays.deepToString(array2));

        System.out.println("-".repeat(20));

        Object[] anyArray = new Object[3];
        System.out.println(Arrays.toString(anyArray));

        anyArray[0] = new String[]{"a", "b", "c"};

        System.out.println(Arrays.deepToString(anyArray));

        anyArray[1] = new String[][]{
                {"1", "2"},
                {"3", "4", "5"},
                {"6", "7", "8", "9"}
        };
        System.out.println(Arrays.deepToString(anyArray));

        anyArray[2] = new int[2][2][2];
        System.out.println(Arrays.deepToString(anyArray));

        for (Object element : anyArray) {
            System.out.println("Element type = " + element.getClass().getSimpleName());
            System.out.println("Element toString() = " + element);
            System.out.println(Arrays.deepToString((Object[]) element));
        }

    }

    private static void printText(String... args) {
        for (String arg : args) {
            System.out.println(arg);
        }
    }

    private static int[] readIntegers(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a list of integers, separated by commas: ");
        String input = scanner.nextLine();
        String[] stringNum = input.split(",");
        int[] listToReturn = new int[stringNum.length];
        for (int i = 0; i < stringNum.length; i++) {
            listToReturn[i] = Integer.parseInt(stringNum[i].trim());
        }
        return listToReturn;
    }

    private static int findMin(int[] array) {
        int temp = Integer.MAX_VALUE;
        for (int i = 0; i < array.length; i++) {
            if (array[i] < temp) {
                temp = array[i];
            }
        }
        return temp;
    }

    private static void reverse(int[] array) {
        int temp;
        int l = array.length;
        for (int i = 0; i < (l/2); i++) {
            temp = array[l - i - 1];
            array[l - i - 1] = array[i];
            array[i] = temp;
        }
    }

    private static int[] reverseCopy(int[] array) {
        int[] reversedArray = new int[array.length];
        int maxIndex = array.length - 1;
        for (int el : array) {
            reversedArray[maxIndex--] = el;
        }

        return reversedArray;
    }
}
