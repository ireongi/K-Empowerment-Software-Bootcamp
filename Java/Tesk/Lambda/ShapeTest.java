package Java_Network.Tesk.Lambda;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class ShapeTest {
    // v1
    static List<Shape> findShapesByType(List<Shape> shapes, String type){
        List<Shape> result = new ArrayList<>();

        for(Shape s : shapes) {
            if (type == s.getType())
                result.add(s);
        }
        return result;

    }
    static List<Shape> findShapesByColorNArea(List<Shape> shapes, String color, double area){
        List<Shape> result = new ArrayList<>();

        for(Shape s : shapes) {
            if ((color == s.getColor()) && (s.getArea() <= area))
                result.add(s);
        }
        return result;
    }

    // v2
    static List<Shape> findShapes1(List<Shape> shapes, String type, String color, Double area){
        List<Shape> result1 = new ArrayList<>();
        List<Shape> result2 = new ArrayList<>();

        for(Shape s : shapes) {
            if (type == s.getType())
                result1.add(s);
        }
        System.out.println(type + " : " + result1);

        for(Shape s : shapes) {
            if ((color == s.getColor()) && (s.getArea() <= area))
                result2.add(s);
        }
        System.out.println(color + " 도형(면적<=12.0) : " + result2);

        return shapes;
    }

    // v3
    static List<Shape> findShapes2(List<Shape> shapes, Predicate<Shape> p){
        List<Shape> result = new ArrayList<>();

        // p = Predicate.isEqual(shapes);
        //Consumer<Shape> s = t -> { ;};

        return result;
    }
}
