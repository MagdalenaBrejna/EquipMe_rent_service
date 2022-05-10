package mb.equipme_rent_service.repositories;

import mb.equipme_rent_service.domain.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface PaymentRepository  extends JpaRepository<Payment, UUID> {

    @Query(nativeQuery = true, value = "SELECT * FROM payments INNER JOIN renatls ON payments.rental = rentals.id WHERE rentals.userId = ?1 OR payments.owner = ?1")
    List<Payment> findByUserId(UUID userId);

    @Query(nativeQuery = true, value = "SELECT * FROM payments INNER JOIN renatls ON payments.rental = rentals.id WHERE payments.owner = ?1")
    List<Payment> findIncomeByUserId(UUID userId);

    @Query(nativeQuery = true, value = "SELECT * FROM payments INNER JOIN renatls ON payments.rental = rentals.id WHERE rentals.userId = ?1")
    List<Payment> findRentalByUserId(UUID userId);
}
