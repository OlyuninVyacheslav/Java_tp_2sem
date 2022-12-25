package Lab1;

public class Main {
    public static void main(String[] args) {

        Animal[] animals = new Animal[6]; // создаем массив из животных
        animals[0] = new Cat("Кот домашний", "Филя", 0, 200);
        animals[1] = new Cat("Кот деревенский", "Фуфырик", 0,300);
        animals[2] = new Dog("Собака домашняя", "Абалдуй", 8, 400);
        animals[3] = new Dog("Собака деревенская", "Камал", 10, 500);
        animals[4] = new Tiger("Тигр из леса", "Тайгер", 100, 1000);
        animals[5] = new Tiger("Тигр из цирка", "Рурик", 200, 700);

        System.out.println();

        for (int i = 0; i < animals.length; i++) {  //выводим всех животных (вид,имя,кто сколько может проплыть и плавать)
            System.out.println(animals[i]);
        }

        System.out.println();
        //Вывод общих результатов из данных класса;
        System.out.println("Котов: " + (Cat.getCount()));
        System.out.println("Собак: " + (Dog.getCount()));
        System.out.println("Тигров: " + (Tiger.getCount()));
        System.out.println("Всего животных: " + Animal.getCount());
        System.out.println();
        System.out.println("Начинается бег на дистанцию 700 м: ");
        System.out.println("На старт, внимание, марш, животные побежали!");
        System.out.println();

        for (int i = 0; i < animals.length; i++) { // заставляем животных бегать
            animals[i].run(700);
        }
        System.out.println();
        System.out.println("Начинается плавание на дистанцию 200 м: ");
        System.out.println("На старт , внимание, марш , животные поплыли!");
        System.out.println();

        for (int i = 0; i < animals.length; i++) { // засталяем животных плавать
            animals[i].swim(200);
        }

    }
}
