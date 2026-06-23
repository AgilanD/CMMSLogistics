package cmms.Logistics.Dto;

import cmms.Logistics.entity.ProductionOrder.OrderStatus;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductionOrderRequestDto {

    @NotNull(message = "Plant ID is mandatory")
    private Long plantId;

    @NotNull(message = "Car Model ID is mandatory")
    private Long carModelId;

    @NotNull(message = "Order status is mandatory")
    private OrderStatus status;

    @NotNull(message = "Target quantity is mandatory")
    @Min(value = 1, message = "Target quantity must be at least 1")
    private Integer targetQuantity;

    @Min(value = 0, message = "Completed quantity cannot be negative")
    private Integer completedQuantity = 0;

    @NotNull(message = "Expected end date is mandatory")
    private LocalDate expectedEndDate;

    private LocalDate actualEndDate;
}
