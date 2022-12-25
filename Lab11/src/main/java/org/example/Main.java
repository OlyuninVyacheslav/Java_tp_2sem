package org.example;

import org.hibernate.Session;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Session session = HibernetUtil.getSessionFactory().openSession();
        Scanner scanner;
        boolean exit_key = true;
        while (exit_key){
            scanner = new Scanner(System.in);
            if(scanner.hasNext()){
                List<String> sc = Arrays.stream(scanner.nextLine().split(" ")).filter(s -> s.length() > 0).collect(Collectors.toList());
                switch (sc.get(0)){
                    case "/q":
                        exit_key = false;
                        System.out.println("Выход");
                        break;
                    case "/SPBYP": // ВЫВОД ПЕРСОН И ИХ ПОКУПКИ
                        if(sc.size() > 1){
                            try {
                                    List<Customer_Product> productList = session.createQuery("select c.customer_product from Customer c where c.name = :name")
                                            .setParameter("name", sc.get(1)).getResultList();
                                    if(productList.get(0) == null){

                                    }
                                    else {
                                        System.out.println(sc.get(1) + " имеет продукты::");
                                        for (Customer_Product s : productList) {
                                            System.out.println(s.getProduct().getName());
                                        }
                                    }

                            }
                            catch (Exception e){
                                System.out.println("Ошибка! Клиент не найден");
                            }
                        }
                        else {
                            System.out.println("Вы не правильно ввели команду , проверте на корректность ввода");
                        }
                        break;
                    case "/FPBPT": // ВЫВОД ЛЮДЕЙ ПО НАЗВАНИЮ ПРОДУКТА
                        if(sc.size() > 1){
                            try {
                                List<Customer_Product> productList = session.createQuery("select p.customer_product from Product p where p.name = :name")
                                        .setParameter("name", sc.get(1)).getResultList();
                                System.out.println(sc.get(1) + " куплено следующими клиентами:");
                                for (Customer_Product c: productList){
                                    System.out.println(c.getCustomer().getName());
                                }
                            }
                            catch (Exception e){
                                System.out.println("Продукт не найден");
                            }
                        }
                        else {
                            System.out.println("Вы не правильно ввели команду , проверте на корректность ввода");
                        }
                        break;
                    case "/RP": // УДАЛИТЬ КЛИЕНТА
                        if (sc.size() > 1){

                                session.beginTransaction();
                                List<Integer> customer_products = session.createQuery("select cp.buy_id from Customer c join Customer_Product cp on (c = cp.customer) where c.name = :name")
                                        .setParameter("name", sc.get(1)).getResultList();
                                for(int cp: customer_products){
                                    session.createQuery("delete from Customer_Product where buy_id = :id").setParameter("id", cp).executeUpdate();
                                }
                                session.createQuery("delete from Customer c where c.name = :name").setParameter("name", sc.get(1)).executeUpdate();
                                session.getTransaction().commit();try {
                            }
                            catch (Exception e){
                                System.out.println("Клиент не найден");
                            }
                        }
                        else {
                            System.out.println("Вы не правильно ввели команду , проверте на корректность ввода");
                        }
                        break;
                    case "/RPR": // УДАЛИТЬ ПРОДУКТ
                        if (sc.size() > 1){
                            try{session.beginTransaction();
                                List<Integer> customer_products = session.createQuery("" +
                                        "select cp.buy_id from Product p join Customer_Product cp on (p = cp.product) where p.name = :name").setParameter("name", sc.get(1)).getResultList();
                                for(int cp: customer_products){
                                    session.createQuery("delete from Customer_Product where buy_id = :id").setParameter("id", cp).executeUpdate();
                                }
                                session.createQuery("delete from Product p where p.name = :name").setParameter("name", sc.get(1)).executeUpdate();
                                session.getTransaction().commit();
                            }
                            catch (Exception e){
                                System.out.println("Продукт не найден " );
                            }
                        }
                        else {
                            System.out.println("Вы не правильно ввели команду , проверте на корректность ввода");
                        }
                        break;
                    case "/Buy": // купить
                        if(sc.size() > 2){
                            try {
                                session.beginTransaction();
                                List<Customer> c = session.createQuery("from Customer where name = :name")
                                        .setParameter("name", sc.get(1)).getResultList();
                                List<Product> p = session.createQuery("from Product where name = :name")
                                        .setParameter("name", sc.get(2)).getResultList();
                                Customer_Product c_p = new Customer_Product();
                                c_p.setCustomer(c.get(0));
                                c_p.setProduct(p.get(0));
                                c_p.setValue(p.get(0).getPrice());
                                session.save(c_p);
                                session.getTransaction().commit();
                            }
                            catch (Exception e){
                                System.out.println("Продукт или клиент не найден");
                            }

                        }
                        else {
                            System.out.println("Вы не правильно ввели команду , проверте на корректность ввода");
                        }
                        break;
                    case "/help":
                        System.out.println("/q  - выход из программы\n" +
                                "/SPBYP <Фамилия> - показывать товары, купленные этим человеком\n" +
                                "/FPBPT <Продукт> - покажите, кто купил этот продукт\n" +
                                "/RP <Фамилия> - удалить человека\n" +
                                "/RPR <Продукт> - удалить продукт\n" +
                                "/Buy <Фамилия> <Продукт>\n" +
                                "/h - вывод комманд"
                                );
                        break;
                    default:
                        System.out.println("Неверный ввод");
                        for (String s: sc) {
                            System.out.println("<" + s + ">");
                        }
                        break;
                }
            }
            else{
                System.out.println("Ошибка подключения" );
            }
        }
        session.close();
        HibernetUtil.Shutdown();
    }
}