package com.kodilla.testing.shape;

public class Rectangle implements Shape {

    private double length;
    private double width;

    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    @Override
    public String getShapeName() {
        return "Rectangle";
    }

    @Override
    public double getField() {
        return length * width;
    }
}
