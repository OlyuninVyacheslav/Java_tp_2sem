package laba9;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import laba9.Human;

public class Main {

    static Statement statement = null;
    static ResultSet resultSet = null;

    public static void main(String[] args) throws SQLException, ClassNotFoundException, IllegalAccessException {

        PostgresConnection postgresConnection = PostgresConnection.connect("jdbc:postgresql://localhost:5432/postgres?user=postgres&password=1234");
        SqlRepository<Human> sqlRepository = SqlRepository.init(postgresConnection, "laba9.Human");

        Human human1 = new Human("Иван",19, 175,70);
        Human human2 = new Human("Олег",22, 182,85);
        Human human3 = new Human("Наташа",19, 171,61);
        Human human4 = new Human("Женя",18, 178,72);
        Human human5 = new Human("Гена",19, 175,70);

        sqlRepository.insert(human1);
        sqlRepository.insert(human2);
        sqlRepository.insert(human3);
        sqlRepository.insert(human4);
        sqlRepository.insert(human5);
    }

    public static void QueryOne(Statement statement) throws SQLException {
        resultSet = statement.executeQuery("SELECT stud.name as studName, subj.name as subjName, p.grade " +
                "FROM students AS stud JOIN progress AS p ON stud.id = p.student_id JOIN subjects AS subj " +
                "ON p.subject_id = subj.id WHERE p.grade >= 3 AND p.subject_id = 2;"
        );
    }
}