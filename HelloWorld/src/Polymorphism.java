public class Polymorphism {
    public static void main(String[] args) {
//        Movie theMovie = new Adventure("Star Wars");
//        theMovie.watchMovies();

//        Movie theMovie = Movie.getMovie("Adventure", "Star Wars");
//        theMovie.watchMovies();
//
//        theMovie = Movie.getMovie("ScienceFiction", "Star Wars");
//        theMovie.watchMovies();

//        Scanner s = new Scanner(System.in);
//        while (true) {
//            System.out.print("Enter Type (A for Adventure, C for Comedy, " +
//                    "S for Science Fiction, or Q for quit): ");
//            String type = s.nextLine();
//            if ("Qq".contains(type)) {
//                break;
//            }
//            System.out.print("Enter Movie Title: ");
//            String title = s.nextLine();
//            Movie movie = Movie.getMovie(type, title);
//            movie.watchMovies();
//        }

//        Type Casting and referencing of Objects
//        Movie movie = Movie.getMovie("A", "Jaws");
////        movie.watchMovies();
//
//        Adventure movie1 = (Adventure) Movie.getMovie("A", "Jaws");
////        movie1.watchMovies();
//
//        Object comedy = Movie.getMovie("C", "Airplane");
//        Comedy comedyMovie = (Comedy) comedy;
////        comedyMovie.watchComedy();
//
//        var airplane = Movie.getMovie("C", "Airplane");
////        airplane.watchMovies();
//
//        var plane = new Comedy("Airplane");
//        plane.watchComedy();

        Object unknownObject = Movie.getMovie("S", "Airplane");
        if (unknownObject.getClass().getSimpleName() == "Comedy") {
            Comedy c = (Comedy) unknownObject;
            c.watchComedy();
        } else if (unknownObject instanceof Adventure) {
            ((Adventure) unknownObject).watchAdventure();
        } else if (unknownObject instanceof ScienceFiction syfy) {
//            Here we've assigned the type of the class to the variable 'syfy', if
//            instanceof returns true
            syfy.watchScienceFiction();
        }


    }
}


