package lab7;

import java.util.concurrent.Semaphore;

import static lab7.Main.pol_car;

public class Tunnel extends Stage {
    Semaphore smp = new Semaphore(pol_car);

    public Tunnel() {
        this.length = 150;
        this.description = "Тоннель " + length + " метров";
    }

    @Override
    public void go(Car c) {
            try {
                try {
                    System.out.println(c.getName() + " готовится к этапу(ждет): " + description);
                    smp.acquire();
                    System.out.println(c.getName() + " начал этап: " + description);
                    Thread.sleep(length / c.getSpeed() * 900);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    System.out.println(c.getName() + " закончил этап: " + description);
                    smp.release();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

