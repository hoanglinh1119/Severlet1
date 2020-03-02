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
            case "create":
               break;
            case "edit":
                break;
            case "delete":
                break;
            default:  break;
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      String action=request.getParameter("action");
      if (action==null){action="";}
    switch (action){
        case "create": break;
        case "edit": break;
        case "delete":break;
        case "view":break;
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
}
