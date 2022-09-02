/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dao;
import java.util.List;
import model.Student;
/**
 *
 * @author Ghani
 */
public interface StudentDao {
    void create(Student student);
    Student findById(int studentID);
    List<Student> findAll();
    void update(Student student);
    void delete(int studentID);
}
