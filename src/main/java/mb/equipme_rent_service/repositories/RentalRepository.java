package mb.equipme_rent_service.repositories;

import mb.equipme_rent_service.domain.Rental;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface RentalRepository extends JpaRepository<Rental, UUID> {
}
