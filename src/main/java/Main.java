import java.sql.*;

public class Main {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");

        Students students = new Students();

        students.getStudentsByYear(2015);
        students.getAllStudents();
        students.getStudentsByGroups(3);


        Students student = new Students();
        student.marksAverage(5);
        student.getLessonsAndTeachers(5);
    }

}










