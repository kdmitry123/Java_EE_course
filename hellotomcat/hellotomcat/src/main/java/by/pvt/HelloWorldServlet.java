package by.pvt;

import by.pvt.dto.SystemUsers;
import by.pvt.service.SystemUsersService;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value = "/helloWorld", name = "helloWorldServlet")
public class HelloWorldServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setStatus(200);
        resp.setHeader("Content-Type", "aplication/json");
        SystemUsersService service = new SystemUsersService();

        SystemUsers newUser = createNewSystemUsers(req);
        if (newUser != null) {
            service.add(newUser);
        }

        List<SystemUsers> users = service.getSystemUsers(null);

        ObjectMapper objectMapper = new ObjectMapper();
        String usersJson = objectMapper.writeValueAsString(users);
        resp.getWriter().println(usersJson);

    }

    private SystemUsers createNewSystemUsers(HttpServletRequest request) {
        if (request.getParameter("username") == null || request.getParameter("username").isEmpty()) {
            return null;
        } else {
            SystemUsers newUser = new SystemUsers();
            newUser.setUsername(request.getParameter("username"));
            newUser.setId(Integer.parseInt(request.getParameter("id")));
            newUser.setActive(Boolean.valueOf(request.getParameter("active")));
            return newUser;
        }
    }

}
