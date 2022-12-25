import java.util.Arrays;

public class Main
{
    private static final int SIZE = 10000000;
    private static final int H = SIZE / 2;
    private static float[] arr;
    private static float[] arr1;
    private static float[] arr2;

    public static void main(String[] args)
    {
        System.out.println("................1 задание................");
        calculate1();
        System.out.println("................2 задание................");
        calculate2();
    }

    private static void formula(float array[], int t)
    {
        for(int i=0; i< array.length; i++)
        {
            array[i]=(float)(array [i] * Math.sin(0.2f + t/5) * Math.cos(0.2f + t/5) * Math.cos(0.4f + t/2));
            t++;
            //  System.out.println(array[i]);
        }
    }
    private static void out(float array[])
    {
        for(int i=0; i< array.length; i++)
        {
            System.out.println(array[i]);
        }
    }

    // 1 задание
    private static void calculate1(){
        long a = System.currentTimeMillis();
        arr = new float[SIZE];

        for(int i=0;i< arr.length;i++) {arr[i]=1;}
        formula(arr,0);
        System.out.println("Время= " + (System.currentTimeMillis() - a));
        //out(arr);
        System.out.println(arr[0]+" "+arr[SIZE-1]);

    }

    // 2 задание
    private static void calculate2(){
        long a = System.currentTimeMillis();
        arr = new float[SIZE];
        arr1 = new float[H];
        arr2 = new float[H];
        for(int i=0;i< arr.length;i++){arr[i]=1;}
        System.arraycopy(arr, 0, arr1, 0, H);
        System.arraycopy(arr, H, arr2, 0, H);
        Thread t1=new Thread(() -> formula(arr1,0));
        Thread t2=new Thread(() -> formula(arr2,H-1));
        try {
            t1.start();
            t2.start();
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.arraycopy(arr1, 0, arr, 0, H);
        System.arraycopy(arr2, 0, arr, H, H);
        System.out.println("Время = " + (System.currentTimeMillis() - a));
        //out(arr);
        System.out.println(arr[0]+" "+arr[SIZE-1]);



    }

}