import java.sql.*;

public class Students {
    private String firstName;
    private String lastName;


    Connection connection = DriverManager
            .getConnection("jdbc:mysql://localhost:3306/dbstudent?user=root&password=кщще");

    Statement statement = connection.createStatement();

    public Students() throws SQLException {
    }


   private void setFirstName(String firstName) {
        this.firstName = firstName;
    }

   private void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void getAllStudents() throws SQLException {
        ResultSet set = statement.executeQuery("SELECT * FROM student;");
        System.out.println("All students >>> ");
        getLastFirstName(set);
    }


    public void getStudentsByGroups(int groups) throws SQLException {
        String a = "SELECT * FROM student WHERE stgroups =" + groups + ";";
        ResultSet set1 = statement.executeQuery(a);
        System.out.println("Group >>> " + groups);
        getLastFirstName(set1);
    }


    public void getStudentsByYear(int year) throws SQLException {
        String b = "SELECT * FROM student WHERE year =" + year + ";";
        ResultSet set2 = statement.executeQuery(b);
        System.out.println("Year >>> " + year);
        getLastFirstName(set2);
    }


    public void marksAverage(int id) throws SQLException {
        ResultSet set = statement.executeQuery("SELECT avg (mark) from marks WHERE student = " + id);

        while (set.next()) {

            System.out.println(" Average >>>  " + set.getDouble(1));
        }
    }

    public void getLessonsAndTeachers(int id) throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet s = statement.executeQuery("SELECT lesson, mark from marks WHERE  student =" + id);
        int lessonId;
        int teacherId;
        while (s.next()) {
            lessonId = s.getInt("lesson");
            Statement statement1 = connection.createStatement();
            ResultSet set = statement1.executeQuery("SELECT name, teacher from lessons where  id =" + lessonId);
            while (set.next()) {
                teacherId = set.getInt("teacher");
                Statement statement2 = connection.createStatement();
                ResultSet set1 = statement2.executeQuery("SELECT * from teachers where id=" + teacherId);
                System.out.println(set.getString("name") + "  mark >>> " + s.getString("mark")
                        + "  Teacher >>> ");
                getLastFirstName(set1);

            }
        }
    }

    private void getLastFirstName(ResultSet set) throws SQLException {
        while (set.next()) {
            setFirstName(set.getString(3));
            setLastName(set.getString(2));
            System.out.println(firstName + " " + lastName);
        }
    }

}

