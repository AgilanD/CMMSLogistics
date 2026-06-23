package cmms.Logistics.Dto;

import cmms.Logistics.entity.ProductionOrder.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

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

}
