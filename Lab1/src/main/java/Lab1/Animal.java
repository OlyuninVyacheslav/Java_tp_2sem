package Lab1;

//Класс животное (животные)

public  abstract class Animal {
    protected String type;       // вид животного
    protected String name;       // имя животного
    protected int swims;         // плавание
    protected int run;           // бег
    private static int count;    // счетчик животных


    public Animal() {
        count++;
    }

    public static int getCount() {
        return count;
    }

    public String toString() {
        return "Вид: '" + type + '\'' +
                ", Имя: '" + name + "\' \n" +
                "Может проплыть " + swims + "м. " +
                ", Может пробежать " + run + "м. " ;

    }

    protected void run(int distance) {
        if (run >= distance) {
            System.out.println(this.type + " по кличке " + this.name + " успешно пробежал " + run + "м.");
        } else {
            System.out.println(this.type + " по кличке " + this.name + " не смог пробежать заданную дистанцию. Пробежал " + run + "м.");
        }
    }

    protected void swim(int distance) {
        if (swims >= distance) {
            System.out.println(this.type + " по кличке " + this.name + " успешно проплыл " + swims + "м.");
        } else {
            System.out.println(this.type + " по кличке " + this.name + " не смог проплыть заданную дистанцию. Проплыл " + swims + "м.");
        }
    }


}