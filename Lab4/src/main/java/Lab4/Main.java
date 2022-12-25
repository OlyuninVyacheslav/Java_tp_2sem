package Lab4;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        Box<Apple> apple = new Box<>();
        Box<Apple> apple1 = new Box<>();
        Box<Apple> apple2 = new Box<>();
        Box<Orange> orange = new Box<>();
        Box<Orange> orange1 = new Box<>();
        Box<Orange> orange2 = new Box<>();
        apple.Fruit_add(new Apple(), new Apple(),new Apple(),new Apple());
        apple1.Fruit_add(new Apple(),new Apple());
        apple2.Fruit_add(new Apple(),new Apple(),new Apple());
//
        orange.Fruit_add(new Orange(),new Orange(),new Orange(),new Orange(),new Orange());
//        orange1.Fruit_add(new Orange(),50);
//        orange2.Fruit_add(new Orange(),65);

          System.out.println("Вес яблок в 1 коробке -> " + apple.getWeight()); //пункт d
          System.out.println("Вес яблок во 2 коробке -> " + apple1.getWeight());
         System.out.println("Вес яблок в 3 коробке -> " + apple2.getWeight());
        System.out.println("Вес апельсинов в 4 коробке -> " + orange.getWeight());
//        System.out.println("Вес апельсинов в 5 коробке -> " + orange1.getWeight());
//        System.out.println("Вес апельсинов в 6 коробке -> " + orange2.getWeight());
//        System.out.println("------------------------------------------------");
//        System.out.println("Сравниваем коробки 1 и 2 -> " + apple.Compare(apple1)); // пункт e
//        System.out.println("Сравниваем коробки 1 и 3 -> " + apple.Compare(apple2));
//        System.out.println("Сравниваем коробки 4 и 6 -> " + orange.Compare(orange2));
//        System.out.println("Сравниваем коробки 4 и 5 -> " + orange.Compare(orange1));
//        System.out.println("Сравниваем коробки 1 и 5 -> " + apple.Compare(orange1));
//        System.out.println("------------------------------------------------");
//        System.out.println("Переваливаем яблоки .... Подождите еще немного... ");
//        System.out.println("Еще минуточку... Упс грузчик упал... Сейчас все будет...");
//        System.out.println("Почти...Почти...Все...Фрукты перевалены.");
//        System.out.println("------------------------------------------------");
        apple1.Clear_box(apple1);
//        apple2.Clear_box(apple1);
////        orange1.Clear_box(orange);
////        orange2.Clear_box(orange1);
//        System.out.println("Вес яблок в 1 коробке -> " + apple.getWeight()); // пункт f
        System.out.println("Вес яблок во 2 коробке -> " + apple1.getWeight());
//        System.out.println("Вес яблок в 3 коробке -> " + apple2.getWeight());
//        System.out.println("Вес апельсинов в 1 коробке -> " + orange.getWeight()); // пункт f
//        System.out.println("Вес апельсинов во 2 коробке -> " + orange1.getWeight());
//        System.out.println("Вес апельсинов в 3 коробке -> " + orange2.getWeight());
         System.out.println(apple.getBox());
    }
}