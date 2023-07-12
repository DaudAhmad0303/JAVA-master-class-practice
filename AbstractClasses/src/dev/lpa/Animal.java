package dev.lpa;

abstract class Mammmal extends Animal{

    public Mammmal(String type, String size, double weight) {
        super(type, size, weight);
    }

    @Override
    public void move(String speed) {
        System.out.print(getExplicitType() + " ");
        System.out.printf(speed.equals("slow") ? "walk" : "runs");
    }

    public abstract void shedHair();

}

public abstract class Animal {
    protected String type;
    private String size;
    private double weight;

    public Animal(String type, String size, double weight) {
        this.type = type;
        this.size = size;
        this.weight = weight;
    }

//    Abstract methods
    public abstract void move(String speed);

    public abstract void makeNoise();

    //    Concrete method
    //    Here final means, the concrete classes wouldn't be able to Override this method, and use it as it is.
    public final String getExplicitType() {
        return getClass().getSimpleName() + " (" + type + ") ";
    }


}
