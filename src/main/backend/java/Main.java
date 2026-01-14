
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class Main {

    public static void main(String[] args) {
        Student students = new Student();

        students.insertStudent("Tom", "tom.tom@mail.com");
        students.insertStudent("Mia", "mia.hacker@mail.com");

        students.selectStudent();
    }
}
