package mb.equipme_rent_service.web.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import java.time.LocalDate;
import java.util.UUID;

public class RentalDto {

    @Null
    @JsonProperty("id")
    private UUID id;

    @NotNull
    private String upc;

    @JsonProperty("rentalPrice")
    private Double rentalPrice;

    @JsonProperty("rentalStartDate")
    private LocalDate rentalStartDate;

    @JsonProperty("rentalEndDate")
    private LocalDate rentalEndDate;

    @JsonProperty("userId")
    private UUID userId;

    @JsonProperty("itemId")
    private UUID itemId;
}
