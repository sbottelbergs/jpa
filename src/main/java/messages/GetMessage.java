package messages;

import javax.persistence.*;
import java.util.Collections;

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
            if (message != null) {
                em.remove(message);
                tx.commit();
                emf.getCache().evictAll();
                tx.begin();
            }
            message = new Message(1L, "Hello World!");
            em.persist(message);
            tx.commit();

            System.out.println("In cache (after persist): " + emf.getCache().contains(Message.class, message.getId()));
            emf.getCache().evict(Message.class, message.getId());
            em.detach(message);
            System.out.println("In cache (after evict/detach): " + emf.getCache().contains(Message.class, message.getId()));

            message = em.find(Message.class, 1L);
            System.out.println("In cache (after find 2): " + emf.getCache().contains(Message.class, message.getId()));

            emf.getCache().evictAll();
            System.out.println("In cache (after evict all): " + emf.getCache().contains(Message.class, message.getId()));
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
