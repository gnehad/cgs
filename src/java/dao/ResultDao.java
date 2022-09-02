/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dao;
import java.util.List;
import model.Result;

/**
 *
 * @author Ghani
 */
public interface ResultDao {
    void create(Result result);
    List<Result> findAll();
    public Result findById(int studentID, int courseID);
    void delete(int studentID, int courseID);
    void update(Result result);
}
