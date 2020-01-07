package school;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class GetSchool {
    public static void main(String[] args) {
        EntityManagerFactory emf = null;
        EntityManager em = null;

        try {
            emf = Persistence.createEntityManagerFactory("school");
            em = emf.createEntityManager();
            EntityTransaction tx = em.getTransaction();
            tx.begin();

            School school = em.find(School.class, 1L);
            System.out.println(school);

            tx.commit();
        } finally {
            if (em != null) {
                em.close();
            }
            if (emf != null) {
                emf.close();
            }
        }
    }
}
