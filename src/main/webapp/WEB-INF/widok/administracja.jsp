<%@ page import="pk.wieik.ti.ti.model.KRuzytkownik" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.Map" %><%--
  Created by IntelliJ IDEA.
  User: TI1
  Date: 04.05.2023
  Time: 11:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<jsp:useBean id="uzytkownik" class="pk.wieik.ti.ti.model.KRuzytkownik" scope="session"/>
<form name="colorForm" method="post" action="KR">
    <input type="hidden" name="action" value="color"  />
    Kolor Tła: <input type="text" name="color" value="${applicationScope.kolorTla}"/> <br/>
    <input type="submit" value="Change" />
</form>
        <%
    ServletContext app = request.getServletContext();
    HashMap<String,KRuzytkownik> users = (HashMap<String,KRuzytkownik>) app.getAttribute("users");
    for(Map.Entry<String,KRuzytkownik> entry : users.entrySet()){
        KRuzytkownik user = entry.getValue();
        String login = user.getLogin();
        int uprawnienia = user.getUprawnienia();
        %>

<form name="updateUser" method="post" action="KR">
    <input type="hidden" name="action" value="updateUser"  />
    <input type="hidden" name="userLogin" value="<%=login%>"  />
    <%=login%> <br>
    <select name = "uprawnienia">
        <%
            if(uprawnienia == 1){
        %>
        <option value = "1">User</option>
        <option value = "2">Admin</option>
        <%
            }
            else{
        %>
        <option value = "2">Admin</option>
        <option value = "1">User</option>
        <%
            }
        %>
    </select>
    <input type="submit" value="Update" />
</form>
<%
    }
%>



