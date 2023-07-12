import java.util.Scanner;

public class ControlFlowChallenges {
    public static void main(String[] args) {
//        System.out.println(getDaysInMonth(1, 2020));
//        System.out.println(getDaysInMonth(2, 2020));
//        System.out.println(getDaysInMonth(2, 2018));
//        System.out.println(getDaysInMonth(-1, 2020));
//        System.out.println(getDaysInMonth(1, -2020));
//        System.out.println(getDaysInMonth(9, 2010));


//        For loop
//        for (double rate = 7.5; rate <= 10; rate+=0.25){
//            System.out.println("100 at " + rate + "% interest = " + calculateInterest(100, rate));
//        }

//        For Loop Challenge
//        int counter = 0;
//        for (int num = 500; num <= 1000; num++){
//            if (isPrime(num)){
//                System.out.println(num + " is Prime.");
//                counter++;
//                if (counter == 3) break;
//            }
//        }

//        Another for loop Challenge
//        int sum = 0, count = 0;
//        for (int i = 1; i <= 1000; i++){
//            if (i % 3 == 0 && i % 5 == 0){
//                System.out.println(i);
//                sum += i;
//                count++;
//            }
//        }
//        System.out.println("Sum of Number are: " + sum + ".\nWhile total numbers are " + count);

//        While Loop
//        int number = 1001, sum = 0;
//        while (number > 0){
//            sum += number % 10;
//            number = number / 10;
//        }
//        System.out.println(sum);

//        Exercises
//        System.out.println(reverse(-199));
//        numberToWords(0);

//        Console input Test
//        try {
//            System.out.println(getInputFromConsole());
//        }catch (NullPointerException e){
//            System.out.println(getInputFromScanner());
//        }
//        System.out.println(canPack(1,0,4)); //false
//        System.out.println(canPack(1,0,5)); //true
//        System.out.println(canPack(0,5,4)); //true
//        System.out.println(canPack(2,2,11)); ///true
//        System.out.println(canPack(-3,2,12)); ///false

//        System.out.println(getLargestPrime(21));

//        Reading User input Challenge
//        int sum = 0;
//        for (int i = 0; i < 5; i ++){
//            System.out.print("Enter number # " + (i+1) + ":");
//            sum += inputNumber();
//        }
//        System.out.print(sum);

//        Another Challenge for Reading Input
        Scanner scanner = new Scanner(System.in);
//        double min = 0, max = 0, loopCount = 0;
//        while(true){
//            try{
//                System.out.print("Enter number: ");
//                double number = Double.parseDouble(scanner.next());
//                if (loopCount == 0 || number < min){
//                    min = number;
//                }
//                if (loopCount == 0 || number > max) {
//                    max = number;
//                }
//                loopCount++;
//            }catch (NumberFormatException E){
//                break;
//            }
//        }
//        System.out.println("Max: " + max + ", Min: " + min);

//        InputCalculator
        System.out.println(Math.round(11.0/3.0));
    }

    public static int inputNumber(){
        Scanner scanner = new Scanner(System.in);
        boolean isValid = false;
        int number = Integer.MAX_VALUE;
        do {
            try {
                number = Integer.parseInt(scanner.next());
                isValid = true;
            } catch (NumberFormatException badUserData) {
                System.out.println("Invalid number!!! Try Again.");
            }
        }while (!isValid);
        return number;
    }

    public static int getLargestPrime(int number){
        if (number <= 0){
            return -1;
        }
        for (int i = number - 1; i >= 1; i--){
            if (number % i == 0){
//                if (number == 2){
//                    return -1;
//                }
                for(int divisior = 2; divisior <= number / 2; divisior++){
                    if (number % divisior == 0){
                        continue;
                    }
                }
                return i;
            }
        }
        return -1;
    }

    public static boolean isLeapYear(int year){
        if (year>=1 && year<=9_999) {
            if (year % 4 == 0) {
                if (year % 100 == 0) {
                    if (year % 400 == 0) {
                        return true;
                    }
                    else{
                        return false;
                    }
                }
                else {
                    return true;
                }
            } else {
                return false;
            }
        }else {
            return false;
        }
    }
    public static int getDaysInMonth(int month, int year){
        if (month < 1 || month > 12 || year < 1 || year > 9_999){
            return -1;
        }
        else {
            switch (month){
                case 4, 6, 9, 11 -> {
                    return 30;
                }
                case 1, 3, 5, 7, 8, 10, 12 -> {
                    return 31;
                }
                case 2 -> {
                    if (isLeapYear(year)) return 29;
                    else return 28;
                }
                default -> {
                    return -1;
                }

            }
        }
    }
    public static double calculateInterest(double amount, double interestRate){
        return (amount * (interestRate / 100));
    }
    public static boolean isPrime(int wholeNumber){
        if (wholeNumber <= 2){
            return (wholeNumber == 2);
        }

        for(int divisior = 2; divisior <= wholeNumber / 2; divisior++){
            if (wholeNumber % divisior == 0){
                return false;
            }
        }
        return true;
    }
    public static void numberToWords (int num) {
        if (num < 0){
            System.out.println("Invalid Value");
            return;
        }
        int digit = 0, curr_count = 0, numCopy = num;
        num = reverse(num);
        while (num!=0){
            digit = num % 10;
            num /= 10;
            digitToWord(digit);
            curr_count++;
        }
//        System.out.println(num + "-" + numCopy + "-" + curr_count);
        for (int i=curr_count; i < getDigitCount(numCopy); i++){
            System.out.println("Zero");
        }
        /*int reverse = 0, b = 0;
        int temp = num;
        while(temp>0){
            b = (temp%10);
//            digitToWord(b);
            reverse = reverse * 10 + b;
//            System.out.println(b);
            temp /= 10;
        }

        temp = reverse;
        reverse = 0;
        while(temp>0){
            b = (temp%10);
            digitToWord(b);
            reverse = reverse * 10 + b;
//            System.out.println(b);
            temp /= 10;
        }
        return reverse;*/
    }
    public static void digitToWord(int s) {
        switch (s) {
            case 0:
                System.out.println("Zero");
                break;
            case 1:
                System.out.println("One");
                break;
            case 2:
                System.out.println("Two ");
                break;
            case 3:
                System.out.println("Three");
                break;
            case 4:
                System.out.println("Four");
                break;
            case 5:
                System.out.println("Five");
                break;
            case 6:
                System.out.println("Six");
                break;
            case 7:
                System.out.println("Seven");
                break;
            case 8:
                System.out.println("Eight");
                break;
            case 9:
                System.out.println("Nine");
                break;
            default:
                System.out.println("Invalid");
                break;
        }
    }
    public static int reverse(int num){
        int rev = 0, temp = 0;
        while (num!=0){
            temp = num % 10;
            rev = rev * 10 + temp;
            num /= 10;
        }
        return rev;
    }
    public static int getDigitCount(int num){
        int count = 0;
        if (num == 0) return 1;
        while (num!=0){
            num /= 10;
            count++;
        }
        return count;
    }

    public static String getInputFromConsole(){
        String name = System.console().readLine("Hi, What's your name? ");
        System.out.println("Hi, " + name + ", Welcome in the course!");

        String dateOfBirth = System.console().readLine("What year were you born? ");
        int age = 2023 - Integer.parseInt(dateOfBirth);
        return  "You are " + age + " years old.";
    }

    private static String getInputFromScanner() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Hi, What's your name? ");
        String name = scanner.nextLine();
        System.out.println("Hi, " + name + ", Welcome to the course.");

        System.out.println("What year were your born? ");

        boolean validDOB = false;
        int age = 0;
        do {
            System.out.println("Enter a year of birth >= " +
                    (2023 - 125) + " and <= " + 2023);
            try {
                age = checkData(2023, scanner.nextLine());
                validDOB = age < 0 ? false : true;
            } catch (NumberFormatException badUserData){
                System.out.println("Characters not Allowed!!! Try AGAIN.");
            }
        }while (!validDOB);

        return "So you are " + age + " years old.";
    }

    public static int checkData(int currentYear, String dateOfBirth) {
        int dob = Integer.parseInt((dateOfBirth));
        int minimumYear = currentYear - 125;

        if ((dob < minimumYear) || (dob > currentYear)){
            return -1;
        }

        return (currentYear - dob);
    }

    public static boolean canPack(int bigCount, int smallCount, int goal){
        if (bigCount < 0 || smallCount < 0 || goal < 0){
            return false;
        }

        int goal_remaining = goal - (goal % 5);
        int goal_factors = goal / 5;
        goal_factors -= bigCount;
        System.out.println("BigCount: " + bigCount + ", smallCount: " + smallCount + ", goal: " + goal + " , goal_remaining: " + goal_remaining + ", gaolFactors: " + goal_factors);
        if (((bigCount * 5) + smallCount) >= goal){
            if (goal_factors <= bigCount){
                if (goal_remaining == 0 && goal_factors == 0 && goal > 0) return false;
                else if (goal_remaining <= smallCount){
                    return true;
                }
                else{
                    return false;
                }
            }
            else{
                return false;
            }
        }
        else{
            return false;
        }
    }
}
