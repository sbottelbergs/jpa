package patient;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class SavePatient {
    public static void main(String[] args) {
        EntityManagerFactory emf = null;
        EntityManager em = null;

        try {
            emf = Persistence.createEntityManagerFactory("patient");
            em = emf.createEntityManager();
            EntityTransaction tx = em.getTransaction();
            tx.begin();

            MedicalFile medicalFile = new MedicalFile();
            medicalFile.setHeight(179);
            medicalFile.setWeight(75.5f);

            Patient patient = new Patient();
            patient.setName("Steve");
            patient.setMedicalFile(medicalFile);

            em.persist(patient);
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
