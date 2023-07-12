public class Customer {

//    Implemented in Inheritance.java
    private String name;
    private double creditLimit;
    private String email;

    public Customer(String name, long creditLimit, String email) {
        this.name = name;
        this.creditLimit = creditLimit;
        this.email = email;
    }

    public Customer() {
        this("Bob", 100_000, "bob@email.com");
    }

    public Customer(String name, String email) {
        this(name, 100_000, email);
    }

    public String getName() {
        return name;
    }

    public double getCreditLimit() {
        return creditLimit;
    }

    public String getEmail() {
        return email;
    }
}
