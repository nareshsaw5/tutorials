package com.dodo.learnings.generics;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Upper bound <? extends Field> means any Field or subclass of Field
 */
public class LowerBoundDemo {

    /**
     * This function will accept the Circle and its sub-classes
     * The Circle is the upper bound, hence Circle and its sub-classes are allowed
     * @param list
     */
    public static void displayData(List<? extends Circle> list) {
        for (Object obj : list) {
            System.out.println(obj.toString());
        }
    }

    /**
     * <? extends super Shape> is called the lower bound
     * It can accept Shape and super classes of Shape.
     * It can not accept the sub-classes of Shape
     * @param list
     */
    public static void displayData_1(List<? super Shape> list) {
        for (Object obj : list) {
            System.out.println(obj.toString());
        }
    }


    /**
     * Wild card with Lower bound
     * Accept collection of objects of type String or SUPER-CLASS of String
     * @param collection
     */

    public static void validateTillStringType(Collection<? super String> collection){

    }

    /**
     *
     *  Wild card with Upper bound
     *  Accept collection of objects of type string or SUB-CLASS of String
     * @param collection
     */
    public static void validateStringTypes(Collection<? extends String> collection){

    }

    public static void main(String[] args) {
        List<Circle> list = new ArrayList<>();
        list.add(new Circle(10));
        LowerBoundDemo.displayData(list);

        System.out.println("---------");

        List<Shape> shapes = new ArrayList<>();
        shapes.add(new Shape(10));
        LowerBoundDemo.displayData_1(shapes);

        System.out.println("---------");

        List<Object> objects = new ArrayList<>();
        objects.add('c');
        validateTillStringType(objects);

        // Since String is the upper bound in this function, it will only accept String or its subclasses
        validateStringTypes(List.of("22424"));



    }

}

class Shape {

    int data;

    public Shape(int data) {
        this.data = data;
    }

    @Override public String toString() {
        return "Shape{" + "data=" + data + '}';
    }
}

class Circle extends Shape {

    public Circle(int data) {
        super(data);
    }

    @Override public String toString() {
        return "Circle{" + "data=" + data + '}';
    }
}

class OtherShape {

}



