package Controller;

import Models.Student;
import Service.StudentService;
import Service.StudentServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "StudentServlet" ,urlPatterns = "/students")
public class StudentServlet extends HttpServlet {
    private StudentService studentService=new StudentServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  String action=request.getParameter("action");
  if (action==null){ action="";};
        switch(action){
            case "create": createStudent(request,response);
               break;
            case "edit": editStudent(request,response);
                break;
            case "delete": deleteStudent(request,response);
                break;
            default:  break;
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      String action=request.getParameter("action");
      if (action==null){action="";}
    switch (action){
        case "create": showCreateForm(request,response);
            break;
        case "edit":showEditForm(request,response);
            break;
        case "delete":showdeleteStudent(response,request);
            break;
        case "view": viewStudent(response,request);
            break;
        default: listStudent(request,response);
            break;
    }

    }
    private void listStudent(HttpServletRequest request,HttpServletResponse response){
        List<Student> students=this.studentService.findAll();
        request.setAttribute("students",students);
        RequestDispatcher dispatcher=request.getRequestDispatcher("students/list.jsp");
        try {
            dispatcher.forward(request,response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }
    private void showCreateForm(HttpServletRequest request,HttpServletResponse response){
        RequestDispatcher dispatcher=request.getRequestDispatcher("students/Create.jsp");
        try {
            dispatcher.forward(request,response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }

    }
    private void createStudent(HttpServletRequest request,HttpServletResponse response){
        String name=request.getParameter("name");
        String gender=request.getParameter("gender");
        String email=request.getParameter("email");
        String number=request.getParameter("number");
        String address=request.getParameter("address");
        int id=Integer.parseInt(request.getParameter("id"));

        Student student=new Student(id,name,gender,email,number,address);
        this.studentService.save(student);
        RequestDispatcher dispatcher=request.getRequestDispatcher("students/Create.jsp");
        request.setAttribute("message","new student was created!!");
        try {
            dispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void showEditForm(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        int id=Integer.parseInt(request.getParameter("id"));
        Student student=this.studentService.findId(id);
        this.studentService.findId(id);
        RequestDispatcher dispatcher;
        if (student==null){
            dispatcher=request.getRequestDispatcher("error_404.jsp");
        }else {
            dispatcher=request.getRequestDispatcher("students/Edit.jsp");
            dispatcher.forward(request,response);

        }
    }
    private void editStudent(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        int id=Integer.parseInt(request.getParameter("id"));
        String name=request.getParameter("name");
        String gender=request.getParameter("gender");
        String email=request.getParameter("email");
        String number=request.getParameter("number");
        String address=request.getParameter("address");
        Student student=this.studentService.findId(id);
        RequestDispatcher dispatcher;
        if (student==null){
            dispatcher=request.getRequestDispatcher("error_404.jsp");
        }else {
            student.setId(id);
            student.setName(name);
            student.setGender(gender);
            student.setEmail(email);
            student.setNumberPhone(number);
            student.setAddress(address);
            this.studentService.update(id,student);
            request.setAttribute("student",student);
            request.setAttribute("massage","student information was updated!!");
            dispatcher=request.getRequestDispatcher("students/Edit.jsp");
            dispatcher.forward(request,response);
        }
    }
    private void showdeleteStudent(HttpServletResponse response,HttpServletRequest request) throws ServletException, IOException {
        int id=Integer.parseInt(request.getParameter("id"));
        Student student=this.studentService.findId(id);
        RequestDispatcher dispatcher;
        if(student==null){
            dispatcher=request.getRequestDispatcher("error_404.jsp");
        }else {
            request.setAttribute("student", student);
            dispatcher=request.getRequestDispatcher("students/Delete.jsp");
             dispatcher.forward(request,response);
        }
    }
    private void deleteStudent(HttpServletRequest request,HttpServletResponse response) throws IOException {
        int id=Integer.parseInt(request.getParameter("id"));
        Student student=this.studentService.findId(id);
        RequestDispatcher dispatcher;
        if (student==null){
            dispatcher=request.getRequestDispatcher("error_404.jsp");
        }else {
            this.studentService.remove(id);
            response.sendRedirect("/students");
        }
    }
    private void viewStudent(HttpServletResponse response,HttpServletRequest request) throws ServletException, IOException {
        int id=Integer.parseInt(request.getParameter("id"));
        Student student=this.studentService.findId(id);
        RequestDispatcher dispatcher;
        if (student==null){
            dispatcher=request.getRequestDispatcher("error_404.jsp");
        }else {
            request.setAttribute("student",student);
            dispatcher=request.getRequestDispatcher("students/View.jsp");
            dispatcher.forward(request,response);
        }
    }
}
