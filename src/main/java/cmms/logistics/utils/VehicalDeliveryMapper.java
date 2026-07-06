package cmms.logistics.utils;

import cmms.logistics.dto.VehicalDeliveryRequestDto;
import cmms.logistics.dto.VehicalDeliveryResponseDto;
import cmms.logistics.entity.VehicalDelivery;
import org.springframework.stereotype.Component;

@Component
public class VehicalDeliveryMapper {

    public VehicalDeliveryResponseDto toResponse(VehicalDelivery entity) {
        if (entity == null) return null;

        return VehicalDeliveryResponseDto.builder()
                .id(entity.getId())
                .invoiceNumber(entity.getInvoiceNumber())
                .vehicleId(entity.getVehicle() != null ? entity.getVehicle().getId() : null)
                .customerId(entity.getCustomer() != null ? entity.getCustomer().getId() : null)
                .deliveryDate(entity.getDeliveryDate())
                .invoiceAmount(entity.getInvoiceAmount())
                .deliveredById(entity.getDeliveredBy() != null ? entity.getDeliveredBy().getId() : null)
                .createdAt(entity.getCreatedAt())
                .createdBy(entity.getCreatedBy())
                .lastModifiedAt(entity.getLastModifiedAt())
                .lastModifiedBy(entity.getLastModifiedBy())
                .build();
    }

    public VehicalDelivery toEntity(VehicalDeliveryRequestDto requestDto) {
        if (requestDto == null) return null;

        return VehicalDelivery.builder()
                .invoiceNumber(requestDto.getInvoiceNumber())
                .deliveryDate(requestDto.getDeliveryDate())
                .invoiceAmount(requestDto.getInvoiceAmount())
                .build();
    }

}
