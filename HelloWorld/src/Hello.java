public class Hello {
    public static void main(String [] args){

//        System.out.println("Hello there");
//        boolean isAlien = true;
//        if (isAlien == false)
//            System.out.println("It is not an Alien");
//
//        int topScore = 80;
//        if (topScore < 100){
//            System.out.println("You have got the high score");
//        }
//
//        int secondTopScore = 81;
//        if ((topScore > secondTopScore) && (topScore < 100)){
//            System.out.println("Greater than second top score and less than 100");
//        }
//
//        if ((topScore > 90) || (secondTopScore <= 90)){
//            System.out.println("Either or both of the conditions are true");
//        }
//
//        int newValue = 50;
//        if (newValue == 50){
//            System.out.println("This is true");
//        }
//
//        boolean isDomestic = true;
//        String s = (isDomestic) ? "This car is domestic" : "This car is not domestic";
//        System.out.println(s);

//        Challenge
        double doubleVar1 = 20.00, doubleVar2 = 80.00;
        double result =( doubleVar1 + doubleVar2 ) * 100.00;
        double remainderVal = result % 40.00;
        boolean boolVar = (remainderVal == 0.00) ? true : false;
        System.out.println(boolVar);
        if (!boolVar) {
            System.out.println("got some remainder");
        }

    }
}
