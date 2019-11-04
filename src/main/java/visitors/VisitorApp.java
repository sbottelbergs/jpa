package visitors;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.Scanner;

public class VisitorApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = "";
        do {
            System.out.print("Name: ");
            final String name = scanner.nextLine();

            System.out.print("Age: ");
            final String age = scanner.nextLine();

            registerVisitor(name, Integer.parseInt(age));

            System.out.println("Exit?");
            input = scanner.nextLine();
        } while (!input.equalsIgnoreCase("exit"));
    }

    private static void registerVisitor(String name, int age) {
        EntityManagerFactory emf = null;
        EntityManager em = null;

        try {
            emf = Persistence.createEntityManagerFactory("course");
            em = emf.createEntityManager();
            EntityTransaction tx = em.getTransaction();
            tx.begin();
            final Visitor visitor = new Visitor(name, age);
            em.persist(visitor);
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
