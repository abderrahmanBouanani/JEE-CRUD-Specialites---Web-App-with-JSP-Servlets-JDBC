package controller;



import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import beans.Specialite;
import service.SpecialiteService;

@WebServlet("/specialite")
public class SpecialiteServlet extends HttpServlet {

    private final SpecialiteService service = new SpecialiteService();


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse
            response) throws ServletException, IOException {

        String action = request.getParameter("action");

        if (action == null) {
            // Afficher la liste des spécialités
            request.setAttribute("specialites", service.getAll());
            request.getRequestDispatcher("/views/index.jsp").forward(request, response);

        } else if ("add".equals(action)) {
            // Afficher le formulaire d'ajout
            request.getRequestDispatcher("/views/form.jsp").forward(request, response);

        } else if ("edit".equals(action)) {
            // Afficher le formulaire de modification
            int id = Integer.parseInt(request.getParameter("id"));
            Specialite specialite = service.getById(id);
            request.setAttribute("specialite", specialite);
            request.getRequestDispatcher("/views/edit.jsp").forward(request, response);

        } else if ("delete".equals(action)) {
            // Supprimer une spécialité
            int id = Integer.parseInt(request.getParameter("id"));
            service.delete(id);
            response.sendRedirect(request.getContextPath() + "/specialite");
        }


    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse
            response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if ("add".equals(action)) {
            // Ajouter une nouvelle spécialité
            Specialite specialite = new Specialite();
            specialite.setNom(request.getParameter("nom"));
            specialite.setDescription(request.getParameter("description"));
            service.add(specialite);

        } else if ("edit".equals(action)) {
            // Modifier une spécialité existante
            Specialite specialite = new Specialite();
            specialite.setId(Integer.parseInt(request.getParameter("id")));
            specialite.setNom(request.getParameter("nom"));
            specialite.setDescription(request.getParameter("description"));
            service.update(specialite);
        }

        response.sendRedirect(request.getContextPath() + "/specialite");

        }
}
