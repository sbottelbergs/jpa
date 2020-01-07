package organisation;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class GetMember {
    public static void main(String[] args) {
        EntityManagerFactory emf = null;
        EntityManager em = null;

        try {
            emf = Persistence.createEntityManagerFactory("organisation");
            em = emf.createEntityManager();
            EntityTransaction tx = em.getTransaction();

            tx.begin();
            Member member = em.find(Member.class, 1L);
            member.getOrganisations().forEach(System.out::println);

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
