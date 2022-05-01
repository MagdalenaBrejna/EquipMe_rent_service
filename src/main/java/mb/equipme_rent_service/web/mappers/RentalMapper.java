package mb.equipme_rent_service.web.mappers;

import mb.equipme_rent_service.domain.Rental;
import mb.equipme_rent_service.web.model.RentalDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper
public interface RentalMapper {

    @Mappings({
            @Mapping(target="id", source="rental.id"),
            @Mapping(target="upc", source="rental.upc"),
            @Mapping(target="rentalPrice", source="rental.rentalPrice"),
            @Mapping(target="rentalStartDate", source="rental.rentalStartDate"),
            @Mapping(target="rentalEndDate", source="rental.rentalEndDate"),
            @Mapping(target="userId", source="rental.userId"),
            @Mapping(target="itemId", source="rental.itemId")
    })
    RentalDto rentalToRentalDto(Rental rental);

    @Mappings({
            @Mapping(target="id", source="dto.id"),
            @Mapping(target="upc", source="dto.upc"),
            @Mapping(target="rentalPrice", source="dto.rentalPrice"),
            @Mapping(target="rentalStartDate", source="dto.rentalStartDate"),
            @Mapping(target="rentalEndDate", source="dto.rentalEndDate"),
            @Mapping(target="userId", source="dto.userId"),
            @Mapping(target="itemId", source="dto.itemId")
    })
    Rental rentalDtoToRental(RentalDto dto);
}
