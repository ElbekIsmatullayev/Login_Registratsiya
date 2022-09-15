package Auth;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class Login extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Baza baza=new Baza();
        String username=req.getParameter("username");
        String passvord=req.getParameter("passwordd");
        User user=new User(username,passvord);
        try {
            if (baza.login(user)){
                resp.sendRedirect("kabinet_hemis.html");
            }
            else {
                resp.sendRedirect("login.html");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
