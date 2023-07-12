public class PolymorphismChallenge {
    public static void main(String[] args) {
        Car1 car = new Car1("2023 Blue Ferrari 296 GTS");
        runRace(car);

        Car1 ferrari = new GasPoweredCar("2022 Blue Ferrari 296 GTS",
                15.4, 6);
        runRace(ferrari);

        Car1 tesla = new ElectricCar("2022 Red Tesla Model 3",
                568, 75);
        runRace(tesla);

        Car1 ferrariHybrid = new HybridCar("2022 Black ferrari SF90 Stradale",
                16, 8, 8);
        runRace(ferrariHybrid);

    }

    public static void runRace(Car1 car) {
        car.startEngine();
        car.drive();
    }
}
