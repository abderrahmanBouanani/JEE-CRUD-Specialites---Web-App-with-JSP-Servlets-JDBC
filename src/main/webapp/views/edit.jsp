<%@ page import="models.Specialite" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%
    Specialite specialite = (Specialite) request.getAttribute("specialite");
%>
<html>
<head>
    <title>Modifier une Spécialité</title>
</head>
<body>
    <h1>Modifier une spécialité</h1>

    <form action="specialite" method="post">
        <input type="hidden" name="action" value="edit">
        <input type="hidden" name="id" value="<%= specialite.getId() %>">

        <label>Nom:</label><br>
        <input type="text" name="nom" value="<%= specialite.getNom() %>" required style="width: 300px;"><br><br>

        <label>Description:</label><br>
        <textarea name="description" rows="4" cols="50" required><%= specialite.getDescription() %></textarea><br><br>

        <input type="submit" value="Modifier">
    </form>

    <br>
    <a href="specialite">Retour à la liste</a>
</body>
</html>