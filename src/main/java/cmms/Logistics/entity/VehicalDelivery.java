package cmms.Logistics.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.PastOrPresent;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "VehicalDelivery")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class VehicalDelivery {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "invoice_number", nullable = false, unique = true)
    private String invoiceNumber;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "vehicle_id", nullable = false, unique = true)
    private VehicleInventory vehicle;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "customer_id", nullable = false)
    private Customers customer;

    @PastOrPresent (message = "Delivery date cannot be in the future")
    @Temporal(TemporalType.DATE)
    @Column(name = "delivery_date")
    private LocalDate deliveryDate;

    @Column(name = "invoice_amount", nullable = false, precision = 12, scale = 2)
    private BigDecimal invoiceAmount;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "delivered_by_id", nullable = false)
    private Employee deliveredBy;

}
