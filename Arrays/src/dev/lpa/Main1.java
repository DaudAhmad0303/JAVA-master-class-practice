package dev.lpa;

import java.util.Arrays;

public class Main1 {
    public static void main(String[] args) {
        int[] randArray = new int[10];
        randArray = Main.getRandomArray(10);
        System.out.println(Arrays.toString(randArray));
        Arrays.sort(randArray);

        int[] sortedArray = new int[10];
        for(int i = 0; i < randArray.length; i++){
            sortedArray[i] = randArray[randArray.length - i - 1];
        }

        System.out.println(Arrays.toString(randArray));
        System.out.println(Arrays.toString(sortedArray));

        int[] mySortedArray = sortIntegers(new int[] {7, 30, 35});
        System.out.println(Arrays.toString(mySortedArray));

    }

    private static int[] sortIntegers(int[] array){

        System.out.println(Arrays.toString(array));
        int[] sortedArray = Arrays.copyOf(array, array.length);
        boolean flag = true;
        int temp;
        while (flag) {
            flag = false;
            for (int i = 0; i < sortedArray.length - 1; i++) {
                if (sortedArray[i] < sortedArray[i + 1]) {
                    temp = sortedArray[i];
                    sortedArray[i] = sortedArray[i + 1];
                    sortedArray[i + 1] = temp;
                    flag = true;
                    System.out.println("----->" + Arrays.toString(sortedArray));
                }
            }
            System.out.println("--->" + Arrays.toString(sortedArray));
        }

        return sortedArray;
    }
}
