package lab7;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
public class Main {

    public static final int countcar = 4;
    public static final int pol_car = 2;

    public static void main(String[] args) {
        System.out.println("Подготовка");
        CyclicBarrier cb = new CyclicBarrier(5);
        CountDownLatch cdl = new CountDownLatch(countcar);
        Race race = new Race(new Road(80), new Tunnel(), new Road(60));
        Car[] cars = new Car[countcar];

        for (int i = 0; i < cars.length; i++)
        {
            cars[i] = new Car(race, 30 + (int) (Math.random() * 100),cb, cdl);
        }

        for (int i = 0; i < cars.length; i++)
        {
            new Thread(cars[i]).start();
        }

        try {
            cb.await();
            System.out.println("Гонка началась");
            cb.await();
            cb.await();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Гонка закончилась");
    }
}


