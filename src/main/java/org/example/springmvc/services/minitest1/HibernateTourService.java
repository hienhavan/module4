package org.example.springmvc.services.minitest1;

import org.example.springmvc.model.minitest1.Tour;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Service
public class HibernateTourService implements ITourService {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Tour> findAll() {
        String queryStr = "SELECT c FROM Tour c";
        TypedQuery<Tour> query = entityManager.createQuery(queryStr, Tour.class);
        return query.getResultList();
    }

    @Transactional
    @Override
    public void save(Tour tour) {
        if (false) {
            entityManager.persist(tour);
        } else {
            entityManager.merge(tour);
        }
    }

    @Override
    public Tour findById(int id) {
        return entityManager.find(Tour.class, id);
    }

    @Transactional
    @Override
    public void remove(int id) {
        String queryStr = "DELETE FROM Tour t WHERE t.id = :id";
        int deletedCount = entityManager.createQuery(queryStr)
                .setParameter("id", id)
                .executeUpdate();
    }
}
