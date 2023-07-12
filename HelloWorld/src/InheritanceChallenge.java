public class InheritanceChallenge  extends Object{
    public static void main(String[] args) {
//        Student1 max = new Student1("Max", 21);
//        System.out.println(max.toString());
//        System.out.println(max);
//
//        PrimarySchoolStudent jimmy = new PrimarySchoolStudent("Jimmy", 8,
//                "carole");
//        System.out.println(jimmy);

//        SalariedEmployee person1 = new SalariedEmployee("Ali", "01/01/1990",
//                "", 1236, "",0,false);

        Employee tim = new Employee("Tim", "11/01/1985", "01/01/2020");


        System.out.println("Age = " + tim.getAge());
        System.out.println("Pay = " + tim.collectPay());
        System.out.println(tim);

        SalariedEmployee joe = new SalariedEmployee("Joe", "11/11/1990",
                "03/03/2020", 35000, false);
        System.out.println(joe);
        System.out.println("joe's Paycheck = $" + joe.collectPay());

        joe.retire();
        System.out.println("Joe's Pension check = $" + joe.collectPay());



    }
}
class Worker{
    private String name;
    private String birthDate;
    protected String endDate;

    public Worker(){

    }
    public Worker(String name, String birthDate) {
        this.name = name;
        this.birthDate = birthDate;
    }

    public int getAge(){
        int currentYear = 2025;
        int birthYear = Integer.parseInt(birthDate.substring(6));
        return (currentYear - birthYear);
    }

    public double collectPay(){
        return 0.0;
    }

    public void terminate(String endDate){
        this.endDate = endDate;
    }

    @Override
    public String toString() {
        return "Worker{" +
                "name='" + name + '\'' +
                ", birthDate='" + birthDate + '\'' +
                ", endDate='" + endDate + '\'' +
                '}';
    }
}

class Employee extends Worker{
    private long employeeId;
    private String hireDate;

    private static int employeeNo = 1;

    public Employee(String name, String birthDate, String hireDate) {
        super(name, birthDate);
        this.employeeId = Employee.employeeNo++;
        this.hireDate = hireDate;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeId=" + employeeId +
                ", hireDate='" + hireDate + '\'' +
                "} " + super.toString();
    }
}

class SalariedEmployee extends Employee{
    private double annualSalary;
    private boolean isRetired;

    public SalariedEmployee(String name, String birthDate, String hireDate, double annualSalary, boolean isRetired) {
        super(name, birthDate, hireDate);
        this.annualSalary = annualSalary;
        this.isRetired = isRetired;
    }

    @Override
    public double collectPay() {
        double paycheck = (annualSalary / 26);
        double adjustedPay = (isRetired) ? 0.9 * paycheck : paycheck;
        return (int) adjustedPay;
    }

    public void retire(){
        terminate("12/12/20025");
        this.isRetired = true;
    }

    @Override
    public String toString() {
        return "SalariedEmployee{" +
                "annualSalary=" + annualSalary +
                ", isRetired=" + isRetired +
                "} " + super.toString();
    }
}



//class Student1 {
//    private String name;
//    private int age;
//
//    Student1(String name, int age) {
//        this.age = age;
//        this.name = name;
//    }
//
//    @Override
//    public String toString() {
//        return name + " is " + age;
//    }
//}
//
//class PrimarySchoolStudent extends  Student1 {
//    private String parentName;
//
//    public PrimarySchoolStudent(String name, int age, String parentName) {
//        super(name, age);
//        this.parentName = parentName;
//    }
//
//    @Override
//    public String toString() {
//        return parentName + "\'s kid, " + super.toString();
//    }
//}