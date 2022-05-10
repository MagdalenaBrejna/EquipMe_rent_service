package mb.equipme_rent_service.web.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PaymentDto implements Serializable {

    @NotNull
    @JsonProperty("id")
    UUID itemId;

    @NotNull
    private String upc;

    @NotBlank
    private String ownerId;

    @NotNull
    LocalDateTime paymentDate;

    @NotNull
    @Min(0)
    Double paymentAmount;

}
