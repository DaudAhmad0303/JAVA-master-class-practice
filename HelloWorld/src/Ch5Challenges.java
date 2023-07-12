public class Ch5Challenges {
    public static void main(String[] args) {
        printConversion(1.5);
//        printMegaBytesAndKiloBytes(2500);
//        System.out.println(isLeapYear(2100));
//        String st = getDureationString(220,3661);
    }
    public static long toMilesPerHour(double kilometersPerHour){
        if (kilometersPerHour < 0){
            return -1;
        }
        else{
            double intMilesPerHour = kilometersPerHour/1.609;
            return (long) Math.round(intMilesPerHour);
        }
    }

    public static void printConversion(double kilometersPerHour){
        if (kilometersPerHour < 0){
            System.out.println("Invalid Value");
        }
        else{
            System.out.println(kilometersPerHour + " km/h = " + toMilesPerHour(kilometersPerHour) + " mi/h");
        }
    }
//--------------------------------------------------------
    public static void printMegaBytesAndKiloBytes(int kiloBytes){
        if(kiloBytes<0){
            System.out.println("Invalid Value");
        } else if (kiloBytes==0) {
            System.out.println("0 KB = 0 MB and 0 KB");
        } else{
            int MBs=kiloBytes/1024;
            int KBs=kiloBytes%1024;
            System.out.println(kiloBytes +" KB = " +MBs+" MB and "+KBs+" KB");
        }
    }

//--------------------------------------------------------
    public static boolean isLeapYear(int year){
        if (year>=1 && year<=9_999) {
            if (year % 4 == 0) {
                if (year % 100 == 0) {
                    return year % 400 == 0;
                }
                else {
                    return true;
                }
            } else {
                System.out.println("Here");
                return false;
            }
        }else {
            return false;
        }
    }

    public static String getDureationString(int seconds){
        if (seconds < 0){
            System.out.println("Invalid format.");
            return "";
        }
        int mins = 0;
        if (seconds == 0){
            mins = 0;
        }else {
            mins = seconds / 60;
            seconds = seconds % 60;
        }
        return getDureationString(mins, seconds);
    }
    public static String getDureationString(int minutes, int seconds){
        if (minutes < 0 || (seconds < 0 || seconds >60)){
            System.out.println("Invalid format");
        }
        int hrs = 0, mins = 0, secs = 0;
        if (minutes ==0){
            hrs = 0;
        }else {
            hrs = minutes / 60;
        }
        hrs += seconds / 3600;
        secs = seconds % 3600;
        mins = secs / 60;
        secs = secs % 60;

        mins += minutes % 60;
        secs += mins / 60;

        System.out.println(hrs + "Hrs " + mins + "Mins " + secs+ "Secs " );
        return "";
    }

}
