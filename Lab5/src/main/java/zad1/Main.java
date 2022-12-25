package zad1;
import java.util.*;


public class Main {
    public static void main(String[] args) {
        List<String> array =  new ArrayList<>();
        array.add("a"); array.add("a"); array.add("b");
        array.add("c"); array.add("d"); array.add("d");
        array.add("d"); array.add("a"); array.add("e");
        array.add("f"); array.add("c"); array.add("d");

        System.out.println("Исходный массив: "+array);
        uniqueWords(array);


    }
    public static void uniqueWords(List<String> array) {
        Set<String> tempArray = new LinkedHashSet<>();
        for (String array_ : array) {
            String a = array_.toLowerCase();
            tempArray.add(a);
        }
        for (String tempArray_ : tempArray) {
            int count = 0;
            for (String arr : array) {
                String a = arr.toLowerCase();
                if(tempArray_.equals(a)) count++;
            }
            System.out.println("'" + tempArray_ + "'" + " повторяется в массиве = " + count + " Раз");
        }
        System.out.println();
    }
}