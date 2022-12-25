package org.example;
import java.sql.SQLException;
import org.example.Human;

public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException, IllegalAccessException
    {
        PostgresConnection postgresConnection = PostgresConnection.connect("jdbc:postgresql://localhost:5432/lab9?user=bronnikov_alexandr&password=84937");
        SqlRepository<Human> sqlRepository = SqlRepository.init(postgresConnection, "org.example.Human");
        Human human = new Human ("Вася", 25, 111, 122);
        Human human1 = new Human ("Петя", 28, 121, 150);
        Human human2 = new Human ("Коля", 58, 321, 145);
        Human human3 = new Human ("Саша", 88, 564, 975);
        sqlRepository.insert(human);
        sqlRepository.insert(human1);
        sqlRepository.insert(human2);
        sqlRepository.insert(human3);
    }
}