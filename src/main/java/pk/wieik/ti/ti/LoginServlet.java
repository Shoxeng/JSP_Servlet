package pk.wieik.ti.ti;

import java.io.*;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import pk.wieik.ti.ti.model.KRuzytkownik;
import pk.wieik.ti.ti.model.Narzedzia;
import jakarta.servlet.ServletContext;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
@WebServlet(name = "LoginServlet", value = "/LoginServlet")
public class LoginServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        RequestDispatcher rd=request.getRequestDispatcher("index.jsp");
        rd.include(request,response);

    }
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        // read form fields
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if(username.equals("user") && password.equals("user")){
            HttpSession sesja=request.getSession();
            KRuzytkownik user = new KRuzytkownik();
            user.setUprawnienia(1);
            user.setLogin("user");
            sesja.setAttribute("uzytkownik",user);
        }
        else if(username.equals("admin") && password.equals("admin")){
            HttpSession sesja=request.getSession();
            KRuzytkownik user = new KRuzytkownik();
            user.setUprawnienia(2);
            user.setLogin("admin");
            sesja.setAttribute("uzytkownik",user);
        }

        //response.sendRedirect("");
        RequestDispatcher rd=request.getRequestDispatcher("index.jsp");
        rd.include(request,response);
    }
}
