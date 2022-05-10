package mb.equipme_rent_service.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="payments")
public class Payment {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Type(type="org.hibernate.type.UUIDCharType")
    @Column(length = 36, columnDefinition = "varchar(36)", updatable = false, nullable = false, name="id")
    UUID paymentId;

    @Column(name="upc", unique = true)
    private String upc;

    @Column(name="owner")
    private String ownerId;

    @Column(name = "date")
    private LocalDateTime paymentDate;

    @Column(name = "amount")
    private Double paymentAmount;

    @OneToOne(mappedBy = "payment")
    private Rental rental;
}
