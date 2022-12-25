package lab10;

import laba9.Human;
import laba9.PostgresConnection;
import laba9.SqlRepository;

import java.sql.*;

public class Main {
    static Connection connection = null;
    static Statement statement = null;
    static ResultSet resultSet = null;

    public static void main(String[] args) throws SQLException, ClassNotFoundException, IllegalAccessException {
        try {
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres", "d7c6a1b2");

            statement = connection.createStatement();

            System.out.println("Вывести список студентов, сдавших определенный предмет, на оценку выше 3:");
            One(statement);

            System.out.println("\nПосчитать средний бал по определенному предмету:");
            Two(statement);

            System.out.println("\nПосчитать средний балл по определенному студенту:");
            Three(statement);

            System.out.println("\nНайти три премета, которые сдали наибольшее количество студентов:");
            Four(statement);

            System.out.println("\n");
            Five(statement);


        }
        catch (SQLException e) {
            System.out.println("Ошибка соединения");
            throw new RuntimeException(e);
        }
    }


    //  Вывести список студентов, сдавших определенный предмет, на оценку выше 3;
    public static void One(Statement statement) throws SQLException {
        resultSet = statement.executeQuery("SELECT stud.name as studName, subj.name as subjName, p.grade " +
                "FROM students AS stud JOIN progress AS p ON stud.id = p.student_id JOIN subjects AS subj " +
                "ON p.subject_id = subj.id WHERE p.grade >3  AND p.subject_id = 3;"
        );

        while (resultSet.next()) {
            String studName = resultSet.getString("studName");
            String subjName = resultSet.getString("subjName");
            int grade = resultSet.getInt("grade");

            System.out.printf("%s %s %d\n", studName, subjName, grade);
        }
    }

    //Посчитать средний бал по определенному предмету;
    public static void Two(Statement statement) throws SQLException{
        resultSet = statement.executeQuery("SELECT subjects.name, AVG(progress.grade) as avg FROM progress " +
                "JOIN subjects ON progress.subject_id = subjects.id WHERE subject_id = 2 GROUP BY subjects.name;"
        );

        while (resultSet.next()) {
            String subjName = resultSet.getString("name");
            float avgGrade = resultSet.getFloat("avg");

            System.out.printf("%s %f\n", subjName, avgGrade);
        }
    }

    // Посчитать средний балл по определенному студенту;
    public static void Three(Statement statement) throws SQLException {
        resultSet = statement.executeQuery("SELECT students.name, AVG(progress.grade) as avg FROM progress JOIN subjects " +
                "ON progress.subject_id = subjects.id JOIN students ON students.id = progress.student_id WHERE " +
                "student_id = 1 GROUP BY students.name;"
        );

        while (resultSet.next()) {
            String studName = resultSet.getString("name");
            float avgGrade = resultSet.getFloat("avg");

            System.out.printf("%s %f\n", studName, avgGrade);
        }
    }

    //  Найти три премета, которые сдали наибольшее количество студентов
    public static void Four(Statement statement) throws SQLException {
        resultSet = statement.executeQuery("SELECT s.name, count(grade)\n" +
                "FROM (\n" +
                "    SELECT subject_id, grade\n" +
                "    FROM progress\n" +
                "    WHERE grade >= 3\n" +
                "     ) as p\n" +
                "JOIN subjects as s\n" +
                "ON subject_id = s.id\n" +
                "GROUP BY s.name\n" +
                "ORDER BY 2 DESC\n" +
                "LIMIT 3;"
        );

        while (resultSet.next()) {
            String subjName = resultSet.getString("name");

            System.out.printf("%s\n", subjName);
        }
    }

    public static void Five(Statement statement) throws SQLException {
        resultSet = statement.executeQuery("SELECT st.name as studName, sub.name as subjName, grade\n" +
                "FROM students st\n" +
                "JOIN progress\n" +
                "ON student_id = st.id\n" +
                "JOIN subjects sub\n" +
                "ON subject_id = sub.id\n" +
                "WHERE st.id not in (\n" +
                "SELECT sts.id\n" +
                "FROM students sts\n" +
                "JOIN progress\n" +
                "ON student_id = sts.id\n" +
                "WHERE grade < 4\n" +
                ")"
        );

        while (resultSet.next()) {
            String studName = resultSet.getString("studName");
            String subjName = resultSet.getString("subjName");
            int grade = resultSet.getInt("grade");

            System.out.printf("%s - %s %d\n", studName, subjName, grade);
        }
    }
}