package Service;

import Models.Student;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentServiceImpl implements StudentService {
    private static Map<Integer,Student> students;
    static {
        students=new HashMap<>();
        students.put(1,new Student(1,"nguyen van linh","CG10100","linhnguyen@gmail.com","0982243340","nam dinh"));
        students.put(2,new Student(2,"nguyen van toan","CG10102","toannguyen@gmail.com","09822222222","quang ninh"));
        students.put(3,new Student(3,"nguyen van tu","CG10120","tunguyen@gmail.com","0989999999","ha noi"));
        students.put(4,new Student(4,"nguyen van khai","CG12100","khainguyen@gmail.com","09828383883","hung yen"));
        students.put(5,new Student(5,"le van hoang","CG10122","lehoang@gmail.com","09821121120","hai duong"));
    }
    @Override
    public List<Student> findAll() {
        return new ArrayList<>(students.values());
    }

    @Override
    public void save(Student student) {
       students.put(student.getId(),student);
    }

    @Override
    public Student findId(int id) {
        return students.get(id);
    }

    @Override
    public void update(int id, Student student) {
      students.put(id,student);
    }

    @Override
    public void remove(int id) {
       students.remove(id);
    }
}
