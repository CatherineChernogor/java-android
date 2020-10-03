package com.company;

abstract class Building implements Comparable<Building> {

    double prestige;

    abstract double getArea();

    double getPricePerSquareMetr() { //с учетом того что по дефолту 1кв метр = 1000 долларов
        return getArea() * prestige;
    }

    @Override
    public int compareTo(Building b) {
        return Double.compare(this.getArea(), b.getArea());
    }

    public boolean equals(Building b) {
        return this.equals(b);
    }
}

class Mansion extends Building {

    int floor;
    double width;
    double height;

    Mansion(double p, double h, double w, int f) {
        this.height = h;
        this.width = w;
        this.floor = f;
        this.prestige = p;
    }

    @Override
    double getArea() {
        return height * width * floor;
    }

    public String toString() {
        return "\nMansion\nprestige: " + prestige
                + "\theight: " + height
                + "\twidth: " + width
                + "\tfloor: " + floor;
    }
}

class Park extends Building {

    double width;
    double height;

    Park(double p, double h, double w) {
        this.height = h;
        this.width = w;
        this.prestige = p;
    }

    @Override
    double getArea() {
        return height * width;
    }

    public String toString() {
        return "\nPark\nprestige: " + prestige
                + "\theight: " + height
                + "\twidth: " + width;
    }
}

class Theatre extends Building {
    double radius;
    int floor;

    Theatre( double p, double r, int f) {
        this.radius = r;
        this.floor = f;
        this.prestige = p;
    }

    @Override
    double getArea() {
        return radius * Math.PI * radius * floor;
    }

    public String toString() {
        return "\nTheatre\nprestige: " + prestige
                + "\tradius: " + radius
                + "\tfloor: " + floor;
    }
}
