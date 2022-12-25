package first;
import java.util.Arrays;
public class Main {
    public static void main(String[] args) {
        System.out.println("Массив типа integer:");
        Integer[] nums = {1, 2, 3, 4};
        System.out.println("Исходный массив: " + Arrays.asList(nums));
        swap(nums, 0, 1);
        System.out.println("Меняем 1 и 2 элемент местами: " + Arrays.asList(nums));

        System.out.println();

        System.out.println("Массив типа string:");
        String[] words = {"a", "b", "c", "d"};
        System.out.println("Исходный массив: " + Arrays.asList(words));
        swap(words, 0, 3);
        System.out.println("Меняем 1 и 4 элемент местами: " + Arrays.asList(words));

        System.out.println();

        System.out.println("Массив типа double:");
        Double[] doubles = {1.2, 2.0, 3.1, 4.7};
        System.out.println("Исходный массив: " + Arrays.asList(doubles));
        swap(doubles, 1, 2);
        System.out.println("Меняем 2 и 3 элемент местами: " + Arrays.asList(doubles));
    }

    public static <T> void swap(T[] arr, int i, int j) {
        T temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;

    }
}