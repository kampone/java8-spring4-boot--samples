package com.spring4.java8;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class ConcurrentModification {
    public static void main(String[] args) {
        List<String> strings = new ArrayList<>(Arrays.asList("h1", "h2", "h3", "h4", "h5"));

// NPE vs CME
//        strings.stream().forEach(x -> {
//            if (x.equals("h4")){
//                strings.remove(x);
//            }
//        });

// Яйца, яйца еще
//        Stream<String> stream = strings.stream();
//        strings.add("h6");
//        stream.forEach(System.out::println);

// Яйца, яйца еще (remove)
        strings = strings.subList(0,3);
        Stream<String> stream = strings.stream();
        strings.add("h6");
        stream.forEach(System.out::println);

    }
}
