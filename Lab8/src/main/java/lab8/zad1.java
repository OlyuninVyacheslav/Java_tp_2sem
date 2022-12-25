package lab8;

import com.sun.jdi.Value;

import java.util.*;
import java.util.function.Function;
import java.util.function.ToIntFunction;
import java.util.stream.*;

public class zad1
{

    public static void main(String[] args)
    {
        List<String> frequency = new ArrayList<>();
        Collections.addAll(frequency, "aaaa", "aaaa", "aaaa", "aaaa", "bbbb", "bbbb", "bbbb", "bbbb", "cc", "f","cccc","cccc","cccc","cccc");

// var map = frequency.stream()
// .collect(Collectors
// .groupingBy(Function.identity(), Collectors.counting()));
//
// var max = map
// .entrySet()
// .stream()
// .max(Map.Entry.comparingByValue())
// .map(Map.Entry::getValue)
// .orElse(0l);

        System.out.println(frequency);

        Map<String, Long> wordCount = frequency.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .filter(s -> s.getValue() == (frequency.stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
                        .values().stream().max(Long::compareTo).orElse(0l).co

        System.out.println(wordCount);
        System.out.println("Часто встречающиеся -" + wordCount.keySet());

    }
}
