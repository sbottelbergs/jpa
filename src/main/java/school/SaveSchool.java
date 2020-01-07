package school;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class SaveSchool {
    public static void main(String[] args) {
        EntityManagerFactory emf = null;
        EntityManager em = null;

        try {
            emf = Persistence.createEntityManagerFactory("school");
            em = emf.createEntityManager();
            EntityTransaction tx = em.getTransaction();
            tx.begin();

            School school = new School();
            school.setName("Syntra");
            school.addStudent(Student.create("Mitch"));
            school.addStudent(Student.create("Lens"));
            school.addStudent(Student.create("Michiel"));
            school.addStudent(Student.create("Tom"));
            school.addStudent(Student.create("Ruben"));
            school.addStudent(Student.create("Paul"));
            school.addStudent(Student.create("Thomas"));

            em.persist(school);
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
