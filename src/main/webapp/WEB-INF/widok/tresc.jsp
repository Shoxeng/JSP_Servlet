<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 03.05.2023
  Time: 22:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<% String jakaStrona = "/WEB-INF/widok/"+request.getParameter("jaka_strona")+".jsp"; %>
<jsp:include page="<%=jakaStrona %>"/>
