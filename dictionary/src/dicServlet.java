import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
@WebServlet(name = "DictionaryServlet",urlPatterns = "/dich")
public class dicServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
            HashMap<String,String> dictionary=new HashMap<>();
            dictionary.put("hello","xin chao");
            dictionary.put("bye","tam biet");
            dictionary.put("red","mau do");
            dictionary.put("black","mau den");
            String search=request.getParameter("txtSearch");
            String  ketqua=dictionary.get(search);
            PrintWriter printWriter=response.getWriter();
            if (ketqua!=null){
                printWriter.println("<html>");
                printWriter.println("<h1>search : "+search+"</h1>");
                printWriter.println("<h1> co nghia la : "+ketqua+"</h1>");
                printWriter.println("</html>");
            }else {
                printWriter.println("<html>");
                printWriter.println("<h1>ko co trong tu dien</h1>");
                printWriter.println("</html>");
            }
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

    }
}
