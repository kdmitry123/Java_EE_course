import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/hello")
public class FirstServlet extends HttpServlet {
    String reqStr;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        PrintWriter pw = resp.getWriter();

        pw.write("<h1>Hello World!!!</h1>");
        if(reqStr != null) {
            pw.write("<h1>Request: " + reqStr + "</h1>");
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        reqStr  = req.getReader().readLine();
        doGet(req,resp);

    }
}


