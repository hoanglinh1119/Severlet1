package Service;

import Models.Student;

import java.util.List;

public interface StudentService {
    List<Student> findAll();
    void save(Student students);
    Student findId(int id);
    void update(int id, Student students);
    void remove(int id);
}
