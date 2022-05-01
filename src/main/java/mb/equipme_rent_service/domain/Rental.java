package mb.equipme_rent_service.domain;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@Entity
public class Rental {

    public Rental(UUID rentalId, String upc, Long rentalPrice, LocalDate rentalStartDate, LocalDate rentalEndDate, UUID userId, UUID itemId) {
        this.rentalId = rentalId;
        this.upc = upc;
        this.rentalPrice = rentalPrice;
        this.rentalStartDate = rentalStartDate;
        this.rentalEndDate = rentalEndDate;
        this.userId = userId;
        this.itemId = itemId;
    }

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Type(type="org.hibernate.type.UUIDCharType")
    @Column(length = 36, columnDefinition = "varchar(36)", updatable = false, nullable = false, name="id")
    private UUID rentalId;

    @Column(name="upc", unique = true)
    private String upc;

    @Column(name="price")
    private Long rentalPrice;

    @Column(name="startDate")
    private LocalDate rentalStartDate;

    @Column(name="endDate")
    private LocalDate rentalEndDate;

    @Column(name="userId")
    private UUID userId;

    @Column(name="itemId")
    private UUID itemId;
}
