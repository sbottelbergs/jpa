package messages;

import javax.persistence.*;
import java.util.List;

public class GetMessages {
    public static void main(String[] args) {
        EntityManagerFactory emf = null;
        EntityManager em = null;

        try {
            emf = Persistence.createEntityManagerFactory("course");
            em = emf.createEntityManager();

            TypedQuery<Message> query = em.createQuery("SELECT m FROM Message m WHERE m.text = 'Hello World!'", Message.class);
            List<Message> messages = query.getResultList();
            for (Message message : messages) {
                System.out.println(message.getText());
            }
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
