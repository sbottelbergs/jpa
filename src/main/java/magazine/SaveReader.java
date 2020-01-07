package magazine;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class SaveReader {
    public static void main(String[] args) {
        EntityManagerFactory emf = null;
        EntityManager em = null;

        try {
            emf = Persistence.createEntityManagerFactory("magazine");
            em = emf.createEntityManager();
            EntityTransaction tx = em.getTransaction();
            tx.begin();

            Reader reader = new Reader();
            reader.setName("Tabloid Reader");
            reader.addMagazine(Magazine.create("The Sun"));
            reader.addMagazine(Magazine.create("Daily Mirror"));
            reader.addMagazine(Magazine.create("The Times"));
            reader.addMagazine(Magazine.create("Daily Express"));
            em.persist(reader);

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
