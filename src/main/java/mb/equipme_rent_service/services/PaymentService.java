package mb.equipme_rent_service.services;

import mb.equipme_rent_service.domain.Payment;
import mb.equipme_rent_service.domain.Rental;
import mb.equipme_rent_service.web.model.PaymentDto;
import java.util.List;
import java.util.UUID;

public interface PaymentService extends BaseService<Payment, UUID>  {

    void payForRental(Rental rental);
    List<PaymentDto> getPayments(UUID userId);
    List<PaymentDto> getPaymentsIncome(UUID userId);
    List<PaymentDto> getPaymentsRental(UUID userId);
}
