package dev.lpa;

//Interfaces vs. Abstract Class Lecture

//https://www.udemy.com/course/java-the-complete-java-developer-course/learn/lecture/36166882#overview

//When to use Abstract Class when
//- You want to share code, among several closely related classes (Anima for examples, with fields, name, age...)
//- You expect classes that extend your abstract class, to have many common methods or fields, or require access modifiers other than public.
//- You want to declare non-static or non-final fields (for example, name, age) os this enables you to define methods, that can access and modify the state of an object (getNAme, setNAme).
//- You have a requirement for your base class, to provide a default implementation of certain methods, but other methods should be open to being overridden by child classes.
//Summery: An Abstract class provides a common definition, as a base class, that multiple, derived classes can share.

//When to use Interface when
//- You expect that unrelated classes will implement your interface. For example, two of JAVA's own interfaces are Comparable and Cloneable, can be implemented by many unrelated classes.
//- You want to specify the behavior of a particular data type, but you're not concerned about who implements its behavior.
//- You want to separate different behavior.

public class Test {
    public static void main(String[] args) {
        inFlight(new Jet());

//        OrbitEarth.log("Testing " + new Satellite());
        orbit(new Satellite());

    }

    private static void inFlight(FlightEnabled flier) {
        flier.takeOff();
        flier.transition(
                flier.transition(
                        flier.transition(
                                FlightStages.LAUNCH)));
        flier.fly();
        if (flier instanceof Trackable tracked)
            tracked.track();
        flier.land();
    }

    private static void orbit(OrbitEarth flier) {
        System.out.println("-".repeat(30));
        flier.takeOff();

        System.out.println("-".repeat(30));
        flier.fly();

        System.out.println("-".repeat(30));
        flier.land();

        System.out.println("-".repeat(30));
    }
}