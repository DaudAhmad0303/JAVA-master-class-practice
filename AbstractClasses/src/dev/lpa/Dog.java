package dev.lpa;

public class Dog extends Mammmal {


    public Dog(String type, String size, double weight) {
        super(type, size, weight);
    }

    @Override
    public void move(String speed) {
        if (speed.equalsIgnoreCase("Slow")) {
            System.out.println(getExplicitType() + " Walking");
        } else {
            System.out.println(getExplicitType() + " Running");
        }
    }

    @Override
    public void shedHair() {
        System.out.println(getExplicitType() + " shed hair all the time");
    }

    @Override
    public void makeNoise() {
        if (type.equalsIgnoreCase("Wolf")) {
            System.out.println("Howling! ");
        } else {
            System.out.println("Woof! ");
        }

    }
}
