package pk.wieik.ti.ti;

import java.io.*;
import java.util.HashMap;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import pk.wieik.ti.ti.model.KRuzytkownik;
import pk.wieik.ti.ti.model.Narzedzia;
import jakarta.servlet.ServletContext;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "KR", value = "/KR")
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        /*response.setContentType("text/html");
        response.setCharacterEncoding("utf-8");
        Cookie ciastko = new Cookie("nazwa","wartosc");
        response.addCookie(ciastko);
        Integer wartosc = 0;
        Cookie pobraneCiastko = new Cookie("licznik","0");
        Cookie[] ciastka = request.getCookies();
        for(Cookie Ciastko: ciastka){
            if(Ciastko.getName().equals("licznik")){
                pobraneCiastko = Ciastko;
            }
        }
        try{
            wartosc = Integer.parseInt(pobraneCiastko.getValue());
        }
        catch (NumberFormatException e){
            wartosc = 0;
        }
        wartosc++;
        Cookie licznik = new Cookie("licznik", wartosc.toString());
        licznik.setMaxAge(60*60*24);
        response.addCookie(licznik);

        HttpSession sesja = request.getSession();
        String uzytkownik = (String) sesja.getAttribute("uzytkownik");
        KRuzytkownik _uzytkownik = new KRuzytkownik();

        if(uzytkownik == null) {
            _uzytkownik.setLogin("notloggedin");
            _uzytkownik.setUprawnienia(-1);
        }
        else if(uzytkownik.equals("admin")){
            _uzytkownik.setLogin("admin");
            _uzytkownik.setUprawnienia(2);
        }
        else{
            _uzytkownik.setLogin(uzytkownik);
            _uzytkownik.setUprawnienia(1);

        }
        //sesja.setAttribute("uzytkownik",uzytkownik);

        ServletContext context = getServletContext();
        // Hello
        PrintWriter out = response.getWriter();
        out.println("licznik: " + wartosc);
        out.println("["+_uzytkownik.getLogin() + "][" + _uzytkownik.getUprawnienia() +"]");
        String strona = request.getParameter("strona");
        if(_uzytkownik.getUprawnienia() > 0){
            strona = Narzedzia.parsujStrone(strona,"glowna;kwadratowe;trzecia;ustawienia");
        }
        else {
            strona = Narzedzia.parsujStrone(strona,"glowna;kwadratowe;trzecia");
        }
        if(strona == null){
            strona= "glowna";
        }*/

//        String szablon = Narzedzia.pobierzSzablon("index.jsp",context);
//        if (_uzytkownik.getUprawnienia() == -1)
//            szablon = Narzedzia.uzupelnij(szablon, "MENU", "loginmenu.jsp",context);
//        else
//            szablon = Narzedzia.uzupelnij(szablon, "MENU", "menu.jsp",context);
//        szablon = Narzedzia.uzupelnij(szablon, "NAGLOWEK", "naglowek.jsp",context);
//        szablon = Narzedzia.uzupelnij(szablon, "TRESC", strona+".html",context);
//        szablon = Narzedzia.uzupelnij(szablon, "STOPKA", "stopka.jsp",context);
//        szablon = Narzedzia.uzupelnij(szablon, "SKRYPTY1", strona+"1.html",context);
//        szablon = Narzedzia.uzupelnij(szablon, "SKRYPTY2", strona+"2.html",context);
//        out.println(szablon);


        /*out.close();*/

        RequestDispatcher rd=request.getRequestDispatcher("index.jsp");
        rd.include(request,response);

    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, ServletException {
        // read form fields
        String action = request.getParameter("action");

        ServletContext app = getServletContext();
        HashMap<String,KRuzytkownik> users = (HashMap<String,KRuzytkownik>) app.getAttribute("users");
        if(users == null) {
            users = new HashMap<>();
            users.put("user1", new KRuzytkownik("user1","user1",1));
            users.put("user2", new KRuzytkownik("user2","user2",1));
            users.put("user3", new KRuzytkownik("user3","user3",1));
            users.put("admin1", new KRuzytkownik("admin1","admin1",2));
            users.put("admin2", new KRuzytkownik("admin2","admin2",2));
        }
        app.setAttribute("users",users);

        if("login".equals(action)){
            String username = request.getParameter("username");
            String password = request.getParameter("password");

            KRuzytkownik _login = users.get(username);
            if(_login != null) {
                if (_login.getHaslo().equals(password)) {
                    HttpSession sesja = request.getSession();
                    sesja.setAttribute("uzytkownik", _login);
                }
            }

//            if(username.equals("user") && password.equals("user")){
//                HttpSession sesja=request.getSession();
//                KRuzytkownik user = new KRuzytkownik();
//                user.setUprawnienia(1);
//                user.setLogin("user");
//                sesja.setAttribute("uzytkownik",user);
//            }
//            else if(username.equals("admin") && password.equals("admin")){
//                HttpSession sesja=request.getSession();
//                KRuzytkownik user = new KRuzytkownik();
//                user.setUprawnienia(2);
//                user.setLogin("admin");
//                sesja.setAttribute("uzytkownik",user);
//            }

            //response.sendRedirect("");
            RequestDispatcher rd=request.getRequestDispatcher("index.jsp");
            rd.include(request,response);
        }
        else if("oneCheck".equals(action)){
            HttpSession session=request.getSession();
            session.invalidate();

            RequestDispatcher rd=request.getRequestDispatcher("index.jsp");
            rd.include(request,response);
        }
        else if("settings".equals(action)){
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
        else if("color".equals(action)){
            ServletContext aplikacja = getServletContext();
            String kolorTla = request.getParameter("color");
            if(kolorTla == null) kolorTla = "";
            aplikacja.setAttribute("kolorTla",kolorTla);
            RequestDispatcher rd=request.getRequestDispatcher("index.jsp");
            rd.include(request,response);
        }
        else if("updateUser".equals(action)){
            String key = request.getParameter("userLogin");
            String _newUpr = request.getParameter("uprawnienia");
            int newUpr = Integer.parseInt(_newUpr);
            KRuzytkownik updated = users.get(key);
            if(updated != null) {
                updated.setUprawnienia(newUpr);
                users.put(key, updated);
                app.setAttribute("users", users);
            }
            RequestDispatcher rd=request.getRequestDispatcher("index.jsp");
            rd.include(request,response);
        }
        else{
            RequestDispatcher rd=request.getRequestDispatcher("index.jsp");
            rd.include(request,response);

        }


    }

    public void destroy() {
    }
}