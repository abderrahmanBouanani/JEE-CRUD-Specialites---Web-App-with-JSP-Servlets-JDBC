<html>
<head>
    <title>Ajouter une Spécialité</title>
</head>
<body>
    <h1>Ajouter une nouvelle spécialité</h1>

    <form action="specialite" method="post">
        <input type="hidden" name="action" value="add">

        <label>Nom:</label><br>
        <input type="text" name="nom" required style="width: 300px;"><br><br>

        <label>Description:</label><br>
        <textarea name="description" rows="4" cols="50" required></textarea><br><br>

        <input type="submit" value="+ Ajouter">
    </form>

    <br>
    <a href="specialite">Retour à la liste</a>
</body>
</html>