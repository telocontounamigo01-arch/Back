package com.restapi.api.generics;

import java.util.Arrays;

public class printElements {

    public static <T> void viewElement(T element) {
        System.out.println("Element: -------------------------------------------------------------  " + element);
    }

    public static <T> void viewElementsCollection(T[] elements) {

        // funcion lambda para imprimir cada elemento del array
        // utilizando el metodo forEach de la clase Arrays
        Arrays.asList(elements).forEach(element -> System.out.println("Element: -------------------------------------------------------------  " + element));

    }


}
