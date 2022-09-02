/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dao;
import java.util.List;
import model.Course;

/**
 *
 * @author Ghani
 */
public interface CourseDao {
    void create(Course course);
    void findById(int courseID);
    List<Course> findAll();
    void update(Course course);
    void delete(int courseID);
}
