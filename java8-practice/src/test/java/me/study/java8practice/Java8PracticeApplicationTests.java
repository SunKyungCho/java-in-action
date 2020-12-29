package me.study.java8practice;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Java8PracticeApplicationTests {

    @Test
    @DisplayName("")
    void mapTest() {

        String[][] sample = new String[][]{
                {"a", "b"}, {"c", "d"}, {"e", "a"}, {"a", "h"}, {"i", "j"}
        };
        List<List<String>> input = List.of(
                List.of("Lawful", "Neutral ", "Chaotic "),
                List.of("Simple ", "", "Complex "),
                List.of("Good", "Neutral", "Evil")
        );

        List<String> s1 = Arrays.asList("a", "b", "c");
        List<String> s2 = Arrays.asList("1", "2", "3");

        s1.stream()
                .flatMap(a -> s2.stream().map(b -> a + b))
                .forEach(System.out::println);




    }
//    <R> Stream<R> map(Function<? super T, ? extends R> mapper);
//    <R> Stream<R> flatMap(Function<? super T, ? extends Stream<? extends R>> mapper);
}
