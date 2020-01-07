package school;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class GetStudent {
    public static void main(String[] args) {
        EntityManagerFactory emf = null;
        EntityManager em = null;

        try {
            emf = Persistence.createEntityManagerFactory("school");
            em = emf.createEntityManager();
            EntityTransaction tx = em.getTransaction();
            tx.begin();

            Student student = em.find(Student.class, 1L);
            System.out.println(student);
            System.out.println("School: " + student.getSchool().getName());

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
