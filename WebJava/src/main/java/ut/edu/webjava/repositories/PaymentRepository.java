// src/main/java/ut/edu/repository/PaymentRepository.java
package ut.edu.webjava.repositories;

import ut.edu.webjava.models.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
    Payment findByTransactionId(String transactionId);
}