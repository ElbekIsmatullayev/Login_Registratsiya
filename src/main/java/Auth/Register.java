package Auth;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

public class Register extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /*PrintWriter writer=resp.getWriter();
        writer.write("register manzili ishladi");*/

        String ism=req.getParameter("f_name");
        String famil=req.getParameter("l_name");
        String email=req.getParameter("email");
        String pass1=req.getParameter("password1");
        String pass2=req.getParameter("password2");
        String tel_raqam=req.getParameter("phone");

        Baza baza=new Baza();

        if (pass1.equals(pass2)){
            User user=new User(ism,famil,email,pass1,tel_raqam);
            try {
                if (baza.Register_funk(user)){
                    resp.sendRedirect("login.html");
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }

        }
        baza=new Baza();
        String username=req.getParameter("username");
        String passvord=req.getParameter("passwordd");
        User user=new User(username,passvord);





    }
}
