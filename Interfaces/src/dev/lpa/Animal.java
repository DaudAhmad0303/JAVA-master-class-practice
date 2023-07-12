package dev.lpa;

enum FlightStages implements Trackable {GROUNDED, LAUNCH, CRUISE, DATA_COLLECTION;

    @Override
    public void track() {
        if (this != GROUNDED) {
            System.out.println("Monitoring " + this);
        }
    }

    public FlightStages getNextStages() {
        FlightStages[] allStages = values();
        return allStages[(ordinal() + 1) % allStages.length];
    }
}

record DragonFly(String name, String type) implements FlightEnabled {

    @Override
    public void takeOff() {

    }

    @Override
    public void land() {

    }

    @Override
    public void fly() {

    }
}

class Satellite implements OrbitEarth {

    FlightStages stage = FlightStages.GROUNDED;
    @Override
    public void achieveOrbit() {
        transition("Orbit achieved!");
    }

    @Override
    public void takeOff() {
        transition("Taking Off");
    }

    @Override
    public void land() {
        transition("Landing");
    }

    @Override
    public void fly() {
        achieveOrbit();
        transition("Data Collection while Orbiting");
    }

    public void transition(String description) {

        System.out.println(description);
        stage = transition(stage);
        stage.track();
    }
}

interface OrbitEarth extends FlightEnabled {
    void achieveOrbit();

    private static void log(String description) {
        var today = new java.util.Date();
        System.out.println(today + ": " + description);
    }

    private void logStage(FlightStages stage, String description) {
        description = stage + ": " + description;
        log(description);
    }

    @Override
    default FlightStages transition(FlightStages stage) {
        FlightStages nextStage = FlightEnabled.super.transition(stage);
        logStage(stage, "Beginning Transition to " + nextStage);
        return nextStage;
    }
}


interface FlightEnabled {
//    All the items in Interfaces are declared public, abstract and constant
//    A final method cannot be Overridden by a subclass
//    We cannot instantiate the interfaces
//    The primitive variables declared here are also static and final by default
//    Means we can use them just by using the name of interface
//    along with the variable name
    double MILES_TO_KM = 1.60934;
    double KM_TO_MILES = 0.621371;
    void takeOff();
    void land();
    void fly();

//    We can implement the methods as default in interfaces, so that
//    if we want to implement some functionality. We can. Or alternatively, we can
//    Override this functionality in the extended classes.
    default FlightStages transition(FlightStages stage) {
//        System.out.println("Transition not implemented on " + getClass().getName());
//        return null;

        FlightStages nextStage = stage.getNextStages();
        System.out.println("Transitioning from " + stage + " to " + nextStage);
        return nextStage;

    }
}

interface Trackable {
    void track();
}

public abstract class Animal {
    public abstract void move();
}
