package Service;

import Models.Student;

import java.util.List;

public interface StudentService {
    List<Student> findAll();
    void save(Student student);
    Student findId(int id);
    void update(int id, Student student);
    void remove(int id);
}
