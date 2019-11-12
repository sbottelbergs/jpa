package credit;

import javax.persistence.*;
import javax.swing.*;
import java.math.BigDecimal;

public class ChangeCreditPessimistic {
    public static void main(String[] args) {
        EntityManagerFactory emf = null;
        EntityManager em = null;

        try {
            emf = Persistence.createEntityManagerFactory("credit");
            em = emf.createEntityManager();
            EntityTransaction tx = em.getTransaction();
            tx.begin();
            Credit credit = em.find(Credit.class, 1L);
            em.lock(credit, LockModeType.PESSIMISTIC_WRITE);
            String delta = JOptionPane.showInputDialog(
                    String.format("Current balance: %s. Change with:", credit.getBalance())
            );
            credit.changeBalance(new BigDecimal(delta));
            em.flush();
            tx.commit();
        } catch (OptimisticLockException ole) {
            JOptionPane.showMessageDialog(null, ole.getMessage());
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
