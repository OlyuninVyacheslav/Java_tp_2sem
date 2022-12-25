package Lab4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Box<T extends Fruit> {
    private ArrayList<T> Box = new ArrayList<>(); // делаем аргумент Т в который будем подсталять разлижные методы , создаем новый массив в котором будут хранится все коробки

    public ArrayList<T> getBox() {
        return Box;
    }

    public void setBox(ArrayList<T> box) {
        Box = box;
    }

    public Box(T...fruit) {
        this.Box=new ArrayList<>();
    }

    public double getWeight(){ // ищем в коробке через foreach кол-во веса фруктов метод(getweight пункт d)

        double weight = 0.0f; // в начальной коробке лежит 0 гр-кг
        // ищем в коробки в которых лежат фрукты если они есть суммируем вес
        // Т нужно , так как есть разные фрукты и мы не знаем какие будем сыпать в коробки
        for(T o : Box) { weight += o.GetWeight(); }
        return weight;
    }

    // создаем класс для добавления в коробку фруктов(вес)
    public void Fruit_add(T...fruit){
        // перебераем вcе количисво фруктов и добавляем их коробку
        Box.addAll(Arrays.asList(fruit));

    }


    public boolean Compare(Box the_box_being_compared){  // делаем компаратор, первый элемент сравнивает откуда ,
        // 2 элемент с чем надо сравнить коробку с той которая попала в метод
        // создадим новую переменную the_box_being_compared ( сравнимая коробка)
        // и сравниваем вес с весом определенной коробки
        if ( getWeight() == the_box_being_compared.getWeight() ) return true;
        else return false;
    }

    //создаем класс который бы очищал текущую коробку , а из другой пересыпал бы в опустевшую коробку
    // из начальной коробки ( box ) переваливаем фрукты(только одного типаБ, поэтому без T не обойтись, т.к нарушаем условие задачи)
    // в коробку которую выбрали(все фрукты) при этом в изначальной ничего не остается
    public void Clear_box(Box <T> the_box_you_selected){
        //Box.clear();
        if(this != the_box_you_selected) {
            the_box_you_selected.Box.addAll(Box);
            Box.clear();
        }
        else return;

    }
}