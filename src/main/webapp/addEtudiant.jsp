<%--
  Created by IntelliJ IDEA.
  User: Issa
  Date: 9/29/2023
  Time: 11:27 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Formulaire Etudiant</title>
</head>
<body>

<form action="saveetudiant" method="get">
    <label>Nom :</label>
    <input type="text" name="nom" > <br/>

    <label>Prenom :</label>
    <input type="text" name="prenom" > <br/>

    <label>Age :</label>
    <input type="number" name="age" > <br/>


    <input type="submit" name="ok"  value="save"> <br/>



</form>

</body>
</html>
