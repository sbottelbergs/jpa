package visitors;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.Scanner;

public class ChangeVisitor {
    public static void main(String[] args) {
        EntityManagerFactory emf = null;
        EntityManager em = null;

        try {
            emf = Persistence.createEntityManagerFactory("course");
            em = emf.createEntityManager();
            EntityTransaction tx = em.getTransaction();
            tx.begin();
            Scanner scanner = new Scanner(System.in);

            System.out.print("Visitor ID: ");
            final long id = Long.parseLong(scanner.nextLine());

            final Visitor visitor = em.find(Visitor.class, id);
            System.out.println(visitor);

            em.detach(visitor);

            System.out.print("New name: ");
            final String newName = scanner.nextLine();
            visitor.setName(newName);

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
