package cmms.Logistics.common.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

@Entity
@Table(name = "customers")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Customers {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "customer_name", nullable = false)
    private String customerName;

    @Column(name = "contact_number", nullable = false)
    private String contactNumber;

    @Email(message = "Invalid email format")
    @Column(nullable = false)
    private String email;

    @Column(columnDefinition = "text", nullable = false)
    private String address;

    @Builder.Default
    @Column(name = "is_active", nullable = false)
    private Boolean isActive = true;



    @CreatedDate
    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt = LocalDateTime.parse("2026-06-23T19:54:30");

    @CreatedBy
    @Column(name = "created_by", nullable = false)
    private Long createdBy = 1L;

    @LastModifiedDate
    @Column(name = "last_modified_at", nullable = false)
    private LocalDateTime lastModifiedAt = LocalDateTime.parse("2026-06-23T19:54:30");

    @LastModifiedBy
    @Column(name = "last_modified_by", nullable = false)
    private Long lastModifiedBy = 1L;


}
