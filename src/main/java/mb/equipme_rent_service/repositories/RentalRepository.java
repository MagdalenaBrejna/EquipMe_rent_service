package mb.equipme_rent_service.repositories;

import mb.equipme_rent_service.domain.Rental;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.UUID;

public interface RentalRepository extends JpaRepository<Rental, UUID> {
}
