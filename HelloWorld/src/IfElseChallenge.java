public class IfElseChallenge {
    public static void main(String[] args) {
//        boolean gameOver = true;
//        int score = 10_000;
//        int levelCompleted = 8;
//        int bonus = 200;
//
//        int finalScore = score;
//
//        if (gameOver) {
//            finalScore += (levelCompleted * bonus);
//            System.out.println("Your final score was " + finalScore);
//        }
//        calculateScore(true, 800, 5, 100);
//        calculateScore(true, 10_000, 8, 200);

        System.out.println(calculateHighScorePosition(1500));
        System.out.println(calculateHighScorePosition(1000));
        System.out.println(calculateHighScorePosition(500));
        System.out.println(calculateHighScorePosition(100));
        System.out.println(calculateHighScorePosition(25));
        displayHighScorePosition("Daud", 2);
    }

    public static void calculateScore(boolean gameOver, int score, int levelCompleted, int bonus){
        int finalScore = score;

        if(gameOver){
            finalScore += (levelCompleted * bonus);
            finalScore += 1000;
            System.out.println("Your final score was " + finalScore);
        }
    }

    public static void displayHighScorePosition(String Pname, int Pposition){
        System.out.println(Pname + " managed to get position " + Pname + " on the high score list.");
        return;
    }

    public static int calculateHighScorePosition(int Pscore){
        if (Pscore >= 1000){
            return 1;
        } else if ((Pscore >= 500) && (Pscore < 1000)) {
            return 2;
        } else if ((Pscore >= 100) && (Pscore < 500)) {
            return 3;
        } else  {
            return 4;
        }
    }
}
