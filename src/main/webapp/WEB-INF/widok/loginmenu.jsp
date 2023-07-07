<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<input type="checkbox" id="cb"/>
<label for="cb">Menu</label>
<ul>
  <li><a href="?strona=glowna">Strona Główna</a></li>
  <li><a href="?strona=kwadratowe">Kwadratowa Masakra</a></li>
  <li><a href="?strona=trzecia">Link3</a></li>
</ul>
<div id="newsy">
  <form name="loginForm" method="post" action="LoginServlet">
    Username: <input type="text" name="username"/> <br/>
    Password: <input type="password" name="password"/> <br/>
    <input type="submit" value="Login" />
  </form>
</div>