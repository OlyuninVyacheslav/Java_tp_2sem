package Lab1;

public class Cat extends Animal {
    private static int count;           // счетчик количества созданных животных котов
    public Cat(String type, String name, int swims, int run) {
        this.type = type;
        this.name = name;
        this.swims = swims;
        this.run = run;
        count++;
    }

    public static int getCount() {
        return count;
    }

    @Override
    protected void swim(int distance) {
        super.swim(distance);
        System.out.println( name + " не умеет плавать.");
    }

    @Override
    public String toString() {
        return "Вид: '" + type + '\'' +
                ", Имя: '" + name + "\' \n" +
                "Не умеет плавать" +
                ", Может пробежать " + run + "м. " ;

    }
}