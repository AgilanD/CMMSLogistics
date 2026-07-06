package cmms.logistics.services;

import cmms.logistics.dto.VehicalDeliveryRequestDto;
import cmms.logistics.dto.VehicalDeliveryResponseDto;
import java.util.List;

public interface VehicalDeliveryServices {
    VehicalDeliveryResponseDto createDelivery(VehicalDeliveryRequestDto requestDto);
    VehicalDeliveryResponseDto getDeliveryById(Long id);
    List<VehicalDeliveryResponseDto> getAllDeliveries();
    VehicalDeliveryResponseDto updateDelivery(Long id, VehicalDeliveryRequestDto requestDto);
    void deleteDelivery(Long id);
}
