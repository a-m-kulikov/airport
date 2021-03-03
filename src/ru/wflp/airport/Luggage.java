package ru.wflp.airport;


public class Luggage implements Comparable<Luggage>{

    String airlineName;
    String flightClass;
    int maxWeight;

    public Luggage(String airlineName, String flightClass, int maxWeight) {
        this.airlineName = airlineName;
        this.flightClass = flightClass;
        this.maxWeight = maxWeight;
    }

    @Override
    public String toString() {
        return "Airline = " + airlineName +
                ", Flight class = " + flightClass +
                ", Max weight = " + maxWeight;
    }

    @Override
    public int compareTo(Luggage l) {
        if (this.maxWeight > l.maxWeight)
            return 1;
        else if ((this.maxWeight < l.maxWeight))
            return -1;
        else
            return 0;
    }

    public String getAirlineNameAndFlightClass() {

        String s = airlineName + flightClass;

        System.out.println(s);

        return s;
    }
}
