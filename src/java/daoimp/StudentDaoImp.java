/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daoimp;
import dao.StudentDao;
import java.util.List;
import java.util.ArrayList;
import model.Student;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import connection.ConnectionFactory;
import java.util.HashSet;

/**
 *
 * @author Ghani
 */
public class StudentDaoImp implements StudentDao{
    private Connection connection = ConnectionFactory.getConnection();
    public StudentDaoImp(){}
    public void create(Student student){
        
        PreparedStatement preparedStatement = null;
        try{
            String createQuery = "INSERT INTO Student(StudentID, firstName, lastName, address, city) VALUES(?, ?, ?, ?, ?)";
            preparedStatement = connection.prepareStatement(createQuery);
            preparedStatement.setInt(1, student.getStudentID());
            preparedStatement.setString(2, student.getFirstName());
            preparedStatement.setString(3, student.getLastName());
            preparedStatement.setString(4, student.getAddress());
            preparedStatement.setString(5, student.getCity());
            preparedStatement.executeUpdate();
            preparedStatement.close();
        }catch(SQLException e){
            e.printStackTrace(); 
        }
    }

    public Student findById(int studentID){
        Student student = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try{
            String selectQuery = "SELECT StudentID, firstName, lastName, address, city FROM Student WHERE studentID = ?";
            preparedStatement = connection.prepareStatement(selectQuery);
            preparedStatement.setInt(1, studentID);
            resultSet = preparedStatement.executeQuery();
            if(resultSet.first()){
                student = new Student();
                String firstName = resultSet.getString(2);
                String lastName = resultSet.getString(3);
                String address = resultSet.getString(4);
                String city = resultSet.getString(5);
                student.setStudentID(studentID);
                student.setFirstName(firstName);
                student.setLastName(lastName);
                student.setAddress(address);
                student.setCity(city);          
            }
            resultSet.close();
            preparedStatement.close(); 
        }catch(SQLException e){
            e.printStackTrace(); 
        }
        
        return student;
        
    }
    public List<Student> findAll(){
        List<Student> studentList = new ArrayList<Student>();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try{
            String selectQuery = "SELECT StudentID, firstName, lastName, address, city FROM Student ORDER BY studentID";
            preparedStatement = connection.prepareStatement(selectQuery);
            resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                Student student = new Student();
                int studentID = resultSet.getInt(1);
                String firstName = resultSet.getString(2);
                String lastName = resultSet.getString(3);
                String address = resultSet.getString(4);
                String city = resultSet.getString(5);
                student.setStudentID(studentID);
                student.setFirstName(firstName);
                student.setLastName(lastName);
                student.setAddress(address);
                student.setCity(city); 
                studentList.add(student);
            }
            resultSet.close();
            preparedStatement.close();
        }catch(SQLException e){
            e.printStackTrace(); 
        }
        return studentList;
    }
    public void update(Student student){
        PreparedStatement preparedStatement = null;
        try{
            String updateQuery = "UPDATE Student SET firstName = ?, lastName = ?, address = ?, city = ? WHERE studentID = ?";
            preparedStatement = connection.prepareStatement(updateQuery);
            preparedStatement.setString(1, student.getFirstName());
            preparedStatement.setString(2, student.getLastName());
            preparedStatement.setString(3, student.getAddress());
            preparedStatement.setString(4, student.getCity());
            preparedStatement.setInt(5, student.getStudentID());
            preparedStatement.executeUpdate();
            preparedStatement.close();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    public void delete(int studentID){
        PreparedStatement preparedStatement = null;
        try{
            String deleteQuery = "DELETE FROM Student WHERE studentID = ?";
            preparedStatement = connection.prepareStatement(deleteQuery);
            preparedStatement.setInt(1, studentID);
            preparedStatement.executeUpdate();
            preparedStatement.close();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
}
