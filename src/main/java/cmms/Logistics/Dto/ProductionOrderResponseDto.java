package cmms.Logistics.Dto;

import cmms.Logistics.entity.ProductionOrder.OrderStatus;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductionOrderResponseDto {

    private Long id;
    private String orderNumber;
    private Long plantId;
    private String plantName;
    private Long carModelId;
    private String carModelName;
    private OrderStatus status;
    private Integer targetQuantity;
    private Integer completedQuantity;
    private LocalDate expectedEndDate;
    private LocalDate actualEndDate;



    private LocalDateTime createdAt;

    private Long createdBy;

    private LocalDateTime lastModifiedAt;

    private Long lastModifiedBy;

}
