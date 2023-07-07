package pk.wieik.ti.ti;

import java.io.*;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import pk.wieik.ti.ti.model.KRuzytkownik;
import pk.wieik.ti.ti.model.Narzedzia;
import jakarta.servlet.ServletContext;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
@WebServlet(name = "LogoutServlet", value = "/LogoutServlet")
public class LogoutServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        HttpSession session=request.getSession();
        session.invalidate();

        RequestDispatcher rd=request.getRequestDispatcher("index.jsp");
        rd.include(request,response);

    }
}  