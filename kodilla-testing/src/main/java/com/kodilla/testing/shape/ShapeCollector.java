package com.kodilla.testing.shape;

import java.util.ArrayList;
import java.util.List;

public class ShapeCollector {

    private List<Shape> shapeList = new ArrayList<>();

    public void addFigure(Shape shape){
        shapeList.add(shape);
    }

    public boolean removeFigure(Shape shape){
        if(shapeList.contains(shape)){
            shapeList.remove(shape);
            return true;
        }
        return false;
    }

    public Shape getFigure(int n){
        if(n >= 0 && n <= shapeList.size()-1){
            return shapeList.get(n);
        }
        return null;
    }

    public String showFigures(){
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < shapeList.size(); i++) {
            result.append(shapeList.get(i).getShapeName());
            if (i < shapeList.size() - 1) {
                result.append(", ");
            }
        }
        return result.toString();
    }

    public List<Shape> getShapeList() {
        return shapeList;
    }
}
