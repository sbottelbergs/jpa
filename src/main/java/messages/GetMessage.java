package messages;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class GetMessage {
    public static void main(String[] args) {
        EntityManagerFactory emf = null;
        EntityManager em = null;

        try {
            emf = Persistence.createEntityManagerFactory("course");
            em = emf.createEntityManager();
            EntityTransaction tx = em.getTransaction();
            tx.begin();
            Message message = em.find(Message.class, 1L);
            System.out.println(message.getText());
            System.out.println("In cache: " + emf.getCache().contains(Message.class, message.getId()));
            emf.getCache().evict(Message.class, message.getId());
            System.out.println("In cache: " + emf.getCache().contains(Message.class, message.getId()));
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
