package Two;
import java.util.List;
import java.util.ArrayList;

public class Main {

//        Общий метод преобразования массива в `ArrayList`
        public static <T> List <T> convertToList(T[] arr)
        {
//            создаем пустой список
            List<T> list = new ArrayList<>();

//            помещаем каждый элемент массива в список
            for (T i: arr) {
                list.add(i);
            }

//            возвращаем список
            return list;
        }

//        Программа для преобразования массива в список на Java
        public static void main(String[] args)
        {
//            данный массив строк
            String[] str = {"A", "B", "C", "D"};
            Integer[] numbers ={3,4,1,7};

//            преобразовать массив в список
            List<String>list = convertToList(str);
            List<Integer>list2 = convertToList(numbers);

//            распечатать список
            System.out.println(list2);
            System.out.println(list);

        }

}