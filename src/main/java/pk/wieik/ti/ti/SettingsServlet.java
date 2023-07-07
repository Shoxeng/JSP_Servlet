package pk.wieik.ti.ti;

import java.io.*;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import pk.wieik.ti.ti.model.KRuzytkownik;
import pk.wieik.ti.ti.model.Narzedzia;
import jakarta.servlet.ServletContext;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
@WebServlet(name = "SettingsServlet", value = "/SettingsServlet")
public class SettingsServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        RequestDispatcher rd=request.getRequestDispatcher("index.jsp");
        rd.include(request,response);

    }
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        // read form fields
        HttpSession sesja = request.getSession();
        KRuzytkownik uzytkownik = (KRuzytkownik) sesja.getAttribute("uzytkownik");

        String imie = request.getParameter("imie");
        String nazwisko = request.getParameter("nazwisko");
        String wiek = request.getParameter("wiek");

        uzytkownik.setImie(imie);
        uzytkownik.setNazwisko(nazwisko);
        uzytkownik.setWiek(Integer.parseInt(wiek));

        sesja.setAttribute("uzytkownik",uzytkownik);
        //response.sendRedirect("");
        RequestDispatcher rd=request.getRequestDispatcher("index.jsp");
        rd.include(request,response);
    }
}
