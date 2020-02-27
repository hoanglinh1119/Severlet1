import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "Login-controller",urlPatterns = "/login")
public class Logincontroller extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username= request.getParameter("Username");
        String password=request.getParameter("Password");
        PrintWriter writer=response.getWriter();
        writer.println("<html>");
        if ("admin".equals(username)&&"admin".equals(password)){
            writer.println("<h1> welcome"+username+"to website </h1>");
        }else{
            writer.println("<h1> login error</h1>");
        }
        writer.println("</html>");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
