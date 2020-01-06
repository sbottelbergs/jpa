package person;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.time.LocalDate;

public class SavePerson {
    public static void main(String[] args) {
        EntityManagerFactory emf = null;
        EntityManager em = null;

        try {
            emf = Persistence.createEntityManagerFactory("person");
            em = emf.createEntityManager();
            EntityTransaction tx = em.getTransaction();
            tx.begin();
            Person person = Person.builder()
                    .firstName("Noel")
                    .lastName("Vaes")
                    .birthDay(LocalDate.of(1965, 10, 13))
                    .gender(GenderType.MALE)
                    .comment("Noel Vaes is a Java developer and instructor")
                    .married(false)
                    .age(51)
                    .homepage("http://www.noelvaes.eu")
                    .address(Address.builder()
                            .street("ThorPark")
                            .number("2")
                            .zipCode("3600")
                            .city("Genk")
                            .country("Belgium")
                            .build())
                    .build();
            em.persist(person);
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
