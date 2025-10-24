<%@ page import="java.util.List" %>
<%@ page import="models.Specialite" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%
    List<Specialite> specialites = (List<Specialite>) request.getAttribute("specialites");
%>
<html>
<head>
    <title>Liste des Spécialités</title>
    <meta charset="UTF-8">
</head>
<body>
    <h1>Liste des Spécialités</h1>

    <a href="specialite?action=add">+ Ajouter une spécialité</a>

    <table>
        <tr>
            <th>ID</th>
        <th>Nom</th>
            <th>Description</th>
            <th>Actions</th>
        </tr>
        <%
            if (specialites != null) {
                for (Specialite spec : specialites) {
        %>
            <tr>
                <td><%= spec.getId() %></td>
                <td><%= spec.getNom() %></td>
                <td><%= spec.getDescription() %></td>
                <td>
                    <a href="specialite?action=edit&id=<%= spec.getId() %>">Modifier</a>
                    <a href="specialite?action=delete&id=<%= spec.getId() %>">
                       Supprimer
                    </a>
                </td>
            </tr>
        <%
                }
            }
        %>
    </table>
</body>
</html>