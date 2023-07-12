public class Movie {
    private String title;

    public Movie(String title) {
        this.title = title;
    }

    public void watchMovies() {
        String instanceType = this.getClass().getSimpleName();
        System.out.printf("%s is a %s film", title, instanceType);
    }

    public static Movie getMovie(String type, String title) {
//        The methods that return an object of the class is called Factory Method
        return switch (type.toUpperCase().charAt(0)) {
            case 'A' -> new Adventure(title);
            case 'C' -> new Comedy(title);
            case 'S' -> new ScienceFiction(title);
            default -> new Movie(title);
        };
    }
}

class Adventure extends Movie {
    public Adventure(String title) {
        super(title);
    }

    @Override
    public void watchMovies() {
        super.watchMovies();
        System.out.println();
        System.out.printf(".. %s%n".repeat(3),
                "Pleasant Scene",
                "Scary Music",
                "Something Bad Happens");
    }

    public void watchAdventure() {
        System.out.println("Watching an Adventure!");
    }
}

class Comedy extends Movie {
    public Comedy(String title) {
        super(title);
    }

    @Override
    public void watchMovies() {
        super.watchMovies();
        System.out.println();
        System.out.printf(".. %s%n".repeat(3),
                "Something funny happens",
                "Something even funnier happens",
                "Happy Ending");
    }

    public void watchComedy() {
        System.out.println("Watching an Comedy!");
    }
}

class ScienceFiction extends Movie {
    public ScienceFiction(String title) {
        super(title);
    }

    @Override
    public void watchMovies() {
        super.watchMovies();
        System.out.println();
        System.out.printf(".. %s%n".repeat(3),
                "Bad Aliens do Bad Stuff",
                "Space Guys Chase Aliens",
                "Planet Blows Up");
    }

    public void watchScienceFiction() {
        System.out.println("Watching an Science Fiction Thriller!");
    }
}