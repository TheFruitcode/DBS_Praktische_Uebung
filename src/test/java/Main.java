
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class Main {
    
    private final String url = "jdbc:mysql://localhost:3306/campusconnect";
    private final String user = "root";
    private final String pwd = "";

    public void insertStudent(String _name, String _email){
        try {
            Connection con = DriverManager.getConnection(url, user, pwd);
            
            /*Anweisungsobjekt (Statement) erzeugen für SELECT, UPDATE und DELETE
            Statement stmt = (Statement) con.createStatement();*/

            String insert = "INSERT INTO Student (name, email) VALUES (?, ?)";
            //Anweisungsobjekt (PreparedStatement) erzeugen für INSERT
            PreparedStatement stmt = con.prepareStatement(insert);

            //Belegung der Parameter
            stmt.setString(1, _name);
            stmt.setString(2, _email);

            //Anweisung ausführen
            stmt.executeUpdate();

            System.out.println("Student eingefügt");

        } catch (SQLException e) {
            System.err.println(e);
        }
    }

    public static void main(String[] args) {
        Main main = new Main();

        main.insertStudent("Tom", "tom.tom@mail.com");
        main.insertStudent("Mia", "mia.hacker@mail.com");
    }
}
