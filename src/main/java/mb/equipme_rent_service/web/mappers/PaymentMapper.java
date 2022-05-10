package mb.equipme_rent_service.web.mappers;

import mb.equipme_rent_service.domain.Payment;
import mb.equipme_rent_service.web.model.PaymentDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper
public interface PaymentMapper {

    @Mappings({
            @Mapping(target="id", source="payment.id"),
            @Mapping(target="upc", source="payment.upc"),
            @Mapping(target="ownerId", source="payment.owner"),
            @Mapping(target="paymentDate", source="payment.paymentDate"),
            @Mapping(target="paymentAmount", source="payment.paymentAmount")
    })
    PaymentDto paymentToPaymentDto(Payment payment);

    @Mappings({
            @Mapping(target="id", source="dto.id"),
            @Mapping(target="upc", source="dto.upc"),
            @Mapping(target="owner", source="dto.ownerId"),
            @Mapping(target="paymentDate", source="dto.paymentDate"),
            @Mapping(target="paymentAmount", source="dto.paymentAmount")
    })
    Payment paymentDtoToPayment(PaymentDto dto);
}
