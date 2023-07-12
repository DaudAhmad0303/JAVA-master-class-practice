package dev.lpa;

import java.util.ArrayList;
import java.util.Arrays;

public class AutoBoxingUnBoxing {
    public static void main(String[] args) {

//        We can not do the following. (using the primitive data type in for LinkedList)
//        LinkedList<int> MyIntegers = new LinkedList<>();

//        Wrapper class for the int / "manually boxing"
//        We can create the int wrapper instance in this way
        Integer boxedInt = Integer.valueOf(15);


//        This is the deprecated way since JAVA 9
        Integer boxedInt1 = new Integer(15);

//        But the preferred way is:  this is also called auto boxing
        Integer autoBoxedInt = 15;


//        UnBoxing is getting the primitive value from the instance of the class
        int unboxedInt = boxedInt.intValue();
        int autoUnboxedInt = autoBoxedInt;


//        AUtoBoxing and unboxing example
        Double result = getLiteralDoublePrimitive();
        double resultUnboxed = getDoubleObject();

        Integer[] wrapperArray = new Integer[5];
        wrapperArray[0] = 50;
        System.out.println(Arrays.toString(wrapperArray));

        System.out.println(wrapperArray[0].getClass().getName());

        Character[] characterArray = {'a', 'b', 'c', 'd'};
        System.out.println(Arrays.toString(characterArray));

        var outList = getList(1, 2, 3, 4, 5);
        System.out.println(outList);


//        AutoBoxing is used in JAVA, where we need to use the object instead of primitive data type
//        Wrapper classes in JAVA like Integer returns an object of that class,
//        making sure we are using object. But at the same time, we can convert
//        this object to primitive data type called autoUnBoxing. These objects can also be null,
//        while the primitive data types can not be null.

    }

    private static ArrayList<Integer> getList(Integer... vararg) {
        ArrayList<Integer> aList = new ArrayList<>();
        for (int i : vararg) {
            aList.add(i);
        }
        return aList;
    }

    private static int returnAnInt(Integer i) {
        return i;
    }

    private static Integer returnAnInteger(int i) {
        return i;
    }

    private static Double getDoubleObject() {
        return 111.00;
    }

    private static double getLiteralDoublePrimitive() {
        return Double.valueOf(100.00);
    }




}
