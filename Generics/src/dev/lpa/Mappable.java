package dev.lpa;

import java.util.Arrays;

public interface Mappable {
    void render();
    static double[] stringToLatLon(String location){
        double[] geoLocation = new double[2];
        String[] latsAndLon = location.split(",");
        geoLocation[0] = Double.parseDouble(latsAndLon[0].trim());
        geoLocation[1] = Double.parseDouble(latsAndLon[1].trim());
        return geoLocation;
    }
}

abstract class Point implements Mappable{
    private double[] location = new double[2];

    public Point(String location) {
        this.location = Mappable.stringToLatLon(location);
    }

    @Override
    public void render() {
        System.out.println("Render " + this + " as POINT (" + location() + ")");
    }

    private String location(){
        return Arrays.toString(location);
    }
}

abstract class Line implements Mappable{
    double[][] locations;

    public Line(String... locations) {
        this.locations = new double[locations.length][];
        int index = 0;
        for (var l : locations) {
            this.locations[index++] = Mappable.stringToLatLon(l);
        }
    }
    private String locations(){
        return Arrays.deepToString(locations);
    }

    @Override
    public void render() {
        System.out.println("Render " + this + " as LINE (" + locations() + ")");

    }
}