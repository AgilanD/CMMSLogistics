package cmms.Logistics.entity;

import cmms.Logistics.common.entity.Customers;
import cmms.Logistics.common.entity.Employee;
import cmms.Logistics.common.entity.VehicleInventory;
import jakarta.persistence.*;
import jakarta.validation.constraints.PastOrPresent;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

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



    @CreatedDate
    @Builder.Default
    @Column(name = "created_at", nullable = false, columnDefinition = "TIMESTAMP DEFAULT '2026-06-23 19:54:30'")
    private LocalDateTime createdAt = LocalDateTime.parse("2026-06-23T19:54:30");

    @CreatedBy
    @Builder.Default
    @Column(name = "created_by", nullable = false, columnDefinition = "BIGINT DEFAULT 1")
    private Long createdBy = 1L;

    @LastModifiedDate
    @Builder.Default
    @Column(name = "last_modified_at", nullable = false, columnDefinition = "TIMESTAMP DEFAULT '2026-06-23 19:54:30'")
    private LocalDateTime lastModifiedAt = LocalDateTime.parse("2026-06-23T19:54:30");

    @LastModifiedBy
    @Builder.Default
    @Column(name = "last_modified_by", nullable = false, columnDefinition = "BIGINT DEFAULT 1")
    private Long lastModifiedBy = 1L;




}
