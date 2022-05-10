package mb.equipme_rent_service.services;

import mb.equipme_rent_service.domain.Rental;
import mb.equipme_rent_service.repositories.RentalRepository;
import mb.equipme_rent_service.web.mappers.RentalMapper;
import mb.equipme_rent_service.web.model.PaymentDto;
import mb.equipme_rent_service.web.model.RentalDto;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class RentalServiceImpl implements RentalService {

    private RentalRepository rentalRepository;
    private RentalMapper mapper;

    public RentalServiceImpl(RentalRepository rentalRepository, RentalMapper mapper) {
        this.rentalRepository = rentalRepository;
        this.mapper = mapper;
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

    @Override
    public void bookItem(RentalDto rentalDto) {
        rentalRepository.save(mapper.rentalDtoToRental(rentalDto));
    }
}
