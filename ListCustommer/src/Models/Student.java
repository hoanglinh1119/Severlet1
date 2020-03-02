package Models;

public class Student {
 private int id;
 private String name;
 private String classId;
 private String email;
 private String numberPhone;
 private  String address;
 public Student(){

 }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClassId() {
        return classId;
    }

    public void setClassId(String classId) {
        this.classId = classId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNumberPhone() {
        return numberPhone;
    }

    public void setNumberPhone(String numberPhone) {
        this.numberPhone = numberPhone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Student(int id, String name, String classId, String email, String numberPhone, String address){
        this.id=id;
        this.name=name;
        this.classId=classId;
        this.email=email;
        this.numberPhone=numberPhone;
        this.address=address;

 }
}
