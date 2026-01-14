import java.sql.*;

public class Student {

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

            con.close();

            System.out.println("Student eingefügt");

        } catch (SQLException e) {
            System.err.println(e);
        }
    }

    public void selectStudent(){
        try{
            Connection con = DriverManager.getConnection(url, user, pwd);

            Statement stmt = con.createStatement();

            String select = "SELECT name, email FROM Student";
            ResultSet resultSet = stmt.executeQuery(select);

            while(resultSet.next()){
                System.out.println(resultSet.getString(1) + " | " + resultSet.getString(2));
            }
        } catch (SQLException e){
            System.err.println(e);
        }
    }
}
