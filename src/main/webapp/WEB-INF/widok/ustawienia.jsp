<%@ page import="pk.wieik.ti.ti.model.KRuzytkownik" %><%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 03.05.2023
  Time: 22:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    /*HttpSession sesja = request.getSession();
    KRuzytkownik uzytkownik = (KRuzytkownik) sesja.getAttribute("uzytkownik");

    String defaultImie = uzytkownik.getImie();
    String defaultNazwisko = uzytkownik.getNazwisko();
    String defaultWiek = "";
    if(uzytkownik.getWiek() > -1){
        defaultWiek = uzytkownik.getWiekS();
    }*/

%>

<form name="settings" method="post" action="KR">
    <input type="hidden" name="action" value="settings" />
    Imie: <input type="text" name="imie" value="${uzytkownik.imie}"/> <br/>
    Nazwisko: <input type="text" name="nazwisko" value="${uzytkownik.nazwisko}"/> <br/>
    Wiek: <input type="number" name="wiek" value="${uzytkownik.wiekS}"/> <br/>
    <input type="submit" value="Update" />
</form>
