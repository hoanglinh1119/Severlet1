package Models;

public class Student {
 private int id;
 private String name;
 private String gender;
 private String email;
 private String numberPhone;
    private  String address;
 public Student(){

 }
public Student(int id, String name, String gender, String email, String numberPhone, String address){
        this.id=id;
        this.name=name;
        this.gender=gender;
        this.email=email;
        this.numberPhone=numberPhone;
        this.address=address;

    }
    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
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


}
