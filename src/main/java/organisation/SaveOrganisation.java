package organisation;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class SaveOrganisation {
    public static void main(String[] args) {
        EntityManagerFactory emf = null;
        EntityManager em = null;

        try {
            emf = Persistence.createEntityManagerFactory("organisation");
            em = emf.createEntityManager();
            EntityTransaction tx = em.getTransaction();

            tx.begin();
            Member aMember = Member.create("aMember");
            Member anotherMember = Member.create("anotherMember");
            em.persist(aMember);
            em.persist(anotherMember);

            Organisation organisation = new Organisation();
            organisation.setName("The super cool organisation");
            organisation.addMember(aMember);
            organisation.addMember(anotherMember);

            em.persist(organisation);

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
