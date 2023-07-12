public class Inheritance {
    public static void main(String[] args) {
//        Car car = new Car();
//        car.describeCar();
//        car.setMake("Maserati");
//        car.setColor("White");
//        System.out.println("make = " + car.getMake());
//        System.out.println("Model = " + car.getModel());
//        car.describeCar();

//        Object Oriented Challenge
//        Account account = new Account("Ali", "ali@email.com", "(92) 12348-546453");
//        account.setAccountNumber("PK NBPA 0333 4578435453");
//        account.setName("Daud Ahmad");
//        account.setEmail("abc@JFreaks.come");
//        account.setPhoneNumber("+92 303 4551058");
//        System.out.println("Name: " + account.getName());
//        System.out.println("Name: " + account.getAccountNumber());
//        System.out.println("Name: " + account.getEmail());
//        System.out.println("Name: " + account.getPhoneNumber());
//        account.withdrawFund(5000);
//        account.depositFund(100_000);
//        account.withdrawFund(5000);

//        Customer Class Example
//        Customer customer = new Customer("Tim",
//                "tim@email.com");
//        System.out.println("Customer name: " + customer.getName());
//        System.out.println("Credit Limit: " + customer.getCreditLimit());
//        System.out.println("Customer Email: " + customer.getEmail());

//        Student Class Example for POJO
//        for(int i = 1; i <= 5; i++){
//            LPAStudent s = new LPAStudent("S92300" + i,
//                    switch (i) {
//                        case 1 -> "Marry";
//                        case 2 -> "Carol";
//                        case 3 -> "Tim";
//                        case 4 -> "Harry";
//                        case 5 -> "Lisa";
//                        default -> "Anonymous";
//                    },
//                    "05/11/2000",
//                    "JAVA MasterClass");
//            System.out.println(s);
//        }

//        Student pojoStudent = new Student("S923006", "Ann",
//                "05/11/2001", "Java Masterclass");
//        LPAStudent recordStudent = new LPAStudent("S923007", "Bill",
//                "05/11/2000", "Java Masterclass");

//        System.out.println(pojoStudent);
//        System.out.println(recordStudent);

//        pojoStudent.setClassList(pojoStudent.getClassList() + ", JAVA OCP Exam 829");

//        Cannot do this because the fields in record are immutable.
//        recordStudent.setClassList(pojoStudent.getClassList() + ", JAVA OCP Exam 829");

//        System.out.println(pojoStudent.getName() + " is taking " +
//                pojoStudent.getClassList());
//        System.out.println(recordStudent.name() + " is taking " +
//                recordStudent.classList());

//        Animal and Dog class implementation
        Animal animal = new Animal("Generic Animal", "Huge", 400);
        doAnimalStuff(animal, "slow");

        Dog dog = new Dog();
        doAnimalStuff(dog, "fast");

        Dog yorkie = new Dog("Yorkie", 15);
        doAnimalStuff(yorkie, "fast");

        Dog retriever = new Dog("Labrador Retriever", 65,
                "Floppy", "Swimmer");
        doAnimalStuff(retriever, "slow");

        Dog wolf = new Dog("Wolf", 40);
        doAnimalStuff(wolf, "slow");

        Fish goldie = new Fish("Goldfish", 0.25, 2, 3);
        doAnimalStuff(goldie, "fast");

    }

    public static void doAnimalStuff(Animal animal, String speed){
        animal.makeNoise();
        animal.move(speed);
        System.out.println(animal);
        System.out.println("___________________");
    }

}
