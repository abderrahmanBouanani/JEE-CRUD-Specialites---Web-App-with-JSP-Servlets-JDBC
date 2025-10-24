package service;



import dao.SpecialiteDao;
import models.Specialite;
import java.util.List;

public class SpecialiteService {
    private final SpecialiteDao dao = new SpecialiteDao();
    public Specialite getById(int id) {
        return dao.getById(id);
    }
    public void add(Specialite specialite) {
        dao.add(specialite);
    }
    public void update(Specialite specialite) {
        dao.update(specialite);
    }
    public void delete(int id) {
        dao.delete(id);
    }

    public List<Specialite> getAll() {
        return dao.getAll();
    }
}
