package com.github.jnh5y;

import java.util.List;

public class MyJavaClass {

    public static Object arrayFunction(Object input) {
        return arrayFunction(new Object[] { input });
    }

    public static Object arrayFunction(Object[] input) {
        System.out.println("Called arrayFunction with " + input.length + " inputs.");
        for (int i = 0; i < input.length; i++) {
            System.out.println("  Object " + i + ":" + input[i]);
        }
        return input.length;
    }

    public static void varargsFunction(Object... input) {
        System.out.println("Called varargsFunction with " + input.length + " inputs.");
        for (int i = 0; i < input.length; i++) {
            System.out.println("  Object " + i + ":" + input[i]);
        }
    }

    // NB: This function is used.
    public static void varargsFunction(List<Object> input) {
        System.out.println("Called varargsFunction with " + input.size() + " inputs.");
        for (int i = 0; i < input.size(); i++) {
            System.out.println("  Object " + i + ":" + input.get(i));
        }
    }

    public static void arrayFunctionInteger(Integer[] input) {
        System.out.println("Called arrayFunctionInteger with " + input.length + " inputs.");
        for (int i = 0; i < input.length; i++) {
            System.out.println("  Object " + i + ":" + input[i]);
        }
    }

    public static void varargsFunctionInteger(Integer... input) {
        System.out.println("Called varargsFunctionInteger with " + input.length + " inputs.");
        for (int i = 0; i < input.length; i++) {
            System.out.println("  Object " + i + ":" + input[i]);
        }
    }


}
