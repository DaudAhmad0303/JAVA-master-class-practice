public class ControlFlow {
    public static void main(String[] args) {
        int switchValue = 1;
        switch (switchValue){
            case 1:
                System.out.println("Value was 1");
                break;
            case 2:
                System.out.println("Value was 2");
                break;
            case 3: case 4: case 5:
                System.out.println("Value was 3 or 4 or 5");
                break;
            default:
                System.out.println("Was not 1, 2, 3, 4, 5 or 6");
                break;
        }

        switch (switchValue) {
            case 1 -> System.out.println("Value was 1");
            case 2 -> System.out.println("Value was 2");
            case 3, 4, 5 -> System.out.println("Value was 3 or 4 or 5");
            default -> System.out.println("Was not 1, 2, 3, 4, 5 or 6");
        }
        String month = "APRIL";
//        System.out.println(getQuarter(month));

//        Traditional Switch Challenge
        /*char letter = 'A';
        switch (letter){
            case 'A':
                System.out.println("Able");
                break;
            case 'B':
                System.out.println("Baker");
                break;
            case 'C':
                System.out.println("Charlie");
                break;
            case 'D':
                System.out.println("Dog");
                break;
            case 'E':
                System.out.println("Easy");
                break;
            default:
                System.out.println("Invalid Character");
                break;
        }*/

//      Expression switch Challenge
        printDayOfWeek(23);
    }

    public static String getQuarter(String month){
        return switch (month) {
            case "JANUARY", "FEBRUARY", "MARCH" -> "1st";
            case "APRIL", "MAY", "JUN" -> "2nd";
            case "JULY", "AUGUST", "SEPTEMBER" -> "3rd";
            case "OCTOBER", "NOVEMBER", "DECEMBER" -> "4th";
//            default -> "Invalid";
            default -> {
                String badResponse = month + " is bad";
                yield badResponse;
            }
        };
    }

    public static void printDayOfWeek(int day){
        String dayOfWeek = switch (day){
            case 0 -> "Sunday";
            case 1 -> "Monday";
            case 2 -> "Tuesday";
            case 3 -> "Wednesday";
            case 4 -> "Thursday";
            case 5 -> "Friday";
            case 6 -> "Saturday";
            default -> "Invalid day";
        };
        System.out.println(day + " stands for " + dayOfWeek);
    }
}
