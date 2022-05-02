package mb.equipme_rent_service.services;

import mb.equipme_rent_service.domain.Rental;
import mb.equipme_rent_service.repositories.RentalRepository;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class RentalServiceImpl implements RentalService {

    private RentalRepository rentalRepository;

    public RentalServiceImpl(RentalRepository rentalRepository) {
        this.rentalRepository = rentalRepository;
    }

    @Override
    public List<Rental> findAll() {
        List<Rental> rentals = new ArrayList<>();
        rentalRepository.findAll().forEach(rentals::add);
        return rentals;
    }

    @Override
    public Rental findById(UUID rentalUUID) {
        return rentalRepository.findById(rentalUUID).orElse(null);
    }

    @Transactional
    @Override
    public Rental save(Rental newRental) {
        return rentalRepository.save(newRental);
    }

    @Transactional
    @Override
    public void delete(Rental toDeleteRental) {
        rentalRepository.delete(toDeleteRental);
    }

    @Override
    public void deleteById(UUID rentalUUID) {
        rentalRepository.deleteById(rentalUUID);
    }
}
