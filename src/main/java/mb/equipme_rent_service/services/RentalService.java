package mb.equipme_rent_service.services;

import mb.equipme_rent_service.domain.Rental;
import mb.equipme_rent_service.web.model.PaymentDto;
import mb.equipme_rent_service.web.model.RentalDto;

import java.util.List;
import java.util.UUID;

public interface RentalService extends BaseService<Rental, UUID>  {

    void bookItem(RentalDto rentalDto);
}
