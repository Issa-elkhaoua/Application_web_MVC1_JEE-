<%@ page import="ma.fstt.model.Etudiant" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Issa
  Date: 9/30/2023
  Time: 1:48 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<table>

    <% List<Etudiant> malist = (List<Etudiant>) request.getAttribute("lister") ;


    %>

    <th>
        ID</th>
    <th>Nom</th>
    <th>Prenom</th>
    <th>Age</th>

    <% for ( Etudiant tmp :malist
    ) {
    %>

    <tr>
        <td><%= tmp.getId_etudiant()%></td>
        <td><%= tmp.getNom()%></td>
        <td><%= tmp.getPrenom()%></td>
        <td><%= tmp.getAge()%></td>
        <td></td>

    </tr>
    <% } %>

</table>

</body>
</html>
