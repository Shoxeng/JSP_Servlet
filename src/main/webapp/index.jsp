<%@ page import="pk.wieik.ti.ti.model.KRuzytkownik" %>
<%@ page import="pk.wieik.ti.ti.model.Narzedzia" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html style="background-color: ${(empty applicationScope.kolorTla) ? white : applicationScope.kolorTla}"

<jsp:useBean id="uzytkownik" class="pk.wieik.ti.ti.model.KRuzytkownik" scope = "session"/>
<%
    /*    HttpSession sesja = request.getSession();
        KRuzytkownik uzytkownik = (KRuzytkownik) sesja.getAttribute("uzytkownik");

        if(uzytkownik == null) {
            uzytkownik = new KRuzytkownik();
            session.setAttribute("uzytkownik",uzytkownik);
        }*/

    String strona = request.getParameter("strona");
    if(uzytkownik.getUprawnienia() > 0){
        if(uzytkownik.getUprawnienia() == 2){
            strona = Narzedzia.parsujStrone(strona, "glowna;kwadratowe;trzecia;ustawienia;administracja");
        }
        else{
            strona = Narzedzia.parsujStrone(strona, "glowna;kwadratowe;trzecia;ustawienia");
        }
    }
    else{
        strona = Narzedzia.parsujStrone(strona, "glowna;kwadratowe;trzecia");
    }
    //sesja.setAttribute("uzytkownik",uzytkownik);
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8" name="viewport" content="width=device-width, initial-scale=1"/>
    <title>TI-Lab1</title>
    <link rel="stylesheet" type="text/css" href="styl.css"/>
    <!--<script type ="text/javascript" src="skrypt.js"></script>-->
    <jsp:include page="/WEB-INF/widok/kwadratowe1.jsp"/>
</head>
<!--<body onload="funkcje()">-->
<jsp:include page="/WEB-INF/widok/kwadratowe2.jsp"/>
<div id="kontener">
    <div id="naglowek">
        <jsp:include page="/WEB-INF/widok/naglowek.jsp"/>
    </div>
    <div id="srodek">
        <div id="menu">
            <%
                if(uzytkownik.getUprawnienia() > 0){
            %>
            <input type="checkbox" id="cb"/>
            <label for="cb">Menu</label>
            <ul>
                <li><a href="?strona=glowna">Strona Główna</a></li>
                <li><a href="?strona=kwadratowe">Kwadratowa Masakra</a></li>
                <li><a href="?strona=trzecia">Link3</a></li>
                <li><a href="?strona=ustawienia">Ustawienia</a></li>
                ${uzytkownik.uprawnienia==2 ? '<li><a href="?strona=administracja">Administracja</a></li>' : ''}
            </ul>
            <div id="newsy">
                <p id ="news1"></p>
                <p id ="news2"></p>
                <form name="logoutForm" method="post" action="KR">
                    <input type="hidden" name="action" value="oneCheck" />
                    <input type="submit" value="Logout" />
                </form>
            </div>
            <%
            }else{
            %>
            <input type="checkbox" id="cb"/>
            <label for="cb">Menu</label>
            <ul>
                <li><a href="?strona=glowna">Strona Główna</a></li>
                <li><a href="?strona=kwadratowe">Kwadratowa Masakra</a></li>
                <li><a href="?strona=trzecia">Link3</a></li>
            </ul>
            <div id="newsy">
                <form name="loginForm" method="post" action="KR">
                    <input type="hidden" name="action" value="login" />
                    Username: <input type="text" name="username"/> <br/>
                    Password: <input type="password" name="password"/> <br/>
                    <input type="submit" value="Login" />
                </form>
            </div>
            <%
                }
            %>
        </div>
    </div>
    <div id="tresc">
        <jsp:include page="/WEB-INF/widok/tresc.jsp">
            <jsp:param name ="jaka_strona" value ="<%=strona %>"/>
        </jsp:include>
    </div>
    <div id="stopka">
        <jsp:include page="/WEB-INF/widok/stopka.jsp"/>
    </div>
</div>
</body>
</html>