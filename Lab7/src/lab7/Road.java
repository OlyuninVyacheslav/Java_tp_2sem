package lab7;

public class Road extends Stage {
    public Road(int length)
    {
        this.length = length;
        this.description = "Трасса " + length + " м";
    }
    @Override
    public void go(Car c) {
        try
        {
            System.out.println(c.getName() + " начал: " + description);
            Thread.sleep(length / c.getSpeed() * 1000);
            System.out.println(c.getName() + " закончил: " + description);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }
}
