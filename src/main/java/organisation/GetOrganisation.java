package organisation;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class GetOrganisation {
    public static void main(String[] args) {
        EntityManagerFactory emf = null;
        EntityManager em = null;

        try {
            emf = Persistence.createEntityManagerFactory("organisation");
            em = emf.createEntityManager();
            EntityTransaction tx = em.getTransaction();

            tx.begin();
            Organisation organisation = em.find(Organisation.class, 1L);
            System.out.println(organisation.getMembers());

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
