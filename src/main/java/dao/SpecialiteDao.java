package dao;


import models.Specialite;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SpecialiteDao {


    private final String url = "jdbc:mysql://localhost:3306/tp2jee?useSSL=false&serverTimezone=UTC";
    private final String user = "root";
    private final String pass = "";

    public SpecialiteDao() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Driver JDBC non trouvé", e);
        }
    }

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, user, pass);
    }

    public Specialite getById(int id) {
        String sql = "SELECT * FROM specialite WHERE id = ?";

        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                return new Specialite(
                        rs.getInt("id"),
                        rs.getString("nom"),
                        rs.getString("description")
                );
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erreur lors de la récupération de la spécialité", e);
        }
        return null;
    }

    public void add(Specialite specialite) {
        String sql = "INSERT INTO specialite (nom, description) VALUES (?, ?)";

        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, specialite.getNom());
            pstmt.setString(2, specialite.getDescription());
            pstmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Erreur lors de l'ajout de la spécialité", e);
        }
    }

    public void update(Specialite specialite) {
        String sql = "UPDATE specialite SET nom = ?, description = ? WHERE id = ?";

        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, specialite.getNom());
            pstmt.setString(2, specialite.getDescription());
            pstmt.setInt(3, specialite.getId());
            pstmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Erreur lors de la modification de la spécialité", e);
        }
    }

    public void delete(int id) {
        String sql = "DELETE FROM specialite WHERE id = ?";

        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);
            pstmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Erreur lors de la suppression de la spécialité", e);
        }
    }

    public List<Specialite> getAll() {
        List<Specialite> specialities = new ArrayList<>();
        String sql = "SELECT * FROM specialite";

        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Specialite s = new Specialite();
                s.setId(rs.getInt("id"));
                s.setNom(rs.getString("nom"));
                s.setDescription(rs.getString("description"));
                specialities.add(s);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erreur lors de la récupération des spécialités", e);
        }
        return specialities;
    }
}
