package cmms.Logistics.services;

import cmms.Logistics.Dto.VehicalDeliveryRequestDto;
import cmms.Logistics.Dto.VehicalDeliveryResponseDto;
import java.util.List;

public interface VehicalDeliveryServices {
    VehicalDeliveryResponseDto createDelivery(VehicalDeliveryRequestDto requestDto);
    VehicalDeliveryResponseDto getDeliveryById(Long id);
    List<VehicalDeliveryResponseDto> getAllDeliveries();
    VehicalDeliveryResponseDto updateDelivery(Long id, VehicalDeliveryRequestDto requestDto);
    void deleteDelivery(Long id);
}
