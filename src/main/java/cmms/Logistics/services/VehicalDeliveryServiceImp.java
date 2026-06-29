package cmms.Logistics.services;
import cmms.Logistics.Dto.VehicalDeliveryRequestDto;
import cmms.Logistics.Dto.VehicalDeliveryResponseDto;
import cmms.Logistics.entity.VehicalDelivery;
import cmms.Logistics.common.entity.VehicleInventory;
import cmms.Logistics.common.entity.Customers;
import cmms.Logistics.common.entity.Employee;
import cmms.Logistics.repository.VehicalDeliveryRepository;
import cmms.Logistics.common.entity.repository.VehicleInventoryRepository;
import cmms.Logistics.common.entity.repository.CustomersRepository;
import cmms.Logistics.common.entity.repository.EmployeeRepository;
import cmms.Logistics.utils.VehicalDeliveryMapper;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class VehicalDeliveryServiceImp implements VehicalDeliveryServices {

     private final VehicalDeliveryRepository repository;
     private final VehicalDeliveryMapper mapper;
     private final VehicleInventoryRepository vehicleRepository;
     private final CustomersRepository customersRepository;
     private final EmployeeRepository employeeRepository;

     @Override
     public VehicalDeliveryResponseDto createDelivery(VehicalDeliveryRequestDto requestDto) {
          VehicalDelivery delivery = mapper.toEntity(requestDto);

     VehicleInventory vehicle = vehicleRepository.findById(requestDto.getVehicleId())
                  .orElseThrow(() -> new EntityNotFoundException("Vehicle inventory not found with id: " + requestDto.getVehicleId()));

          Customers customer = customersRepository.findById(requestDto.getCustomerId())
                  .orElseThrow(() -> new EntityNotFoundException("Customer not found with id: " + requestDto.getCustomerId()));

          Employee deliveredBy = employeeRepository.findById(requestDto.getDeliveredById())
                  .orElseThrow(() -> new EntityNotFoundException("Employee not found with id: " + requestDto.getDeliveredById()));

          delivery.setVehicle(vehicle);
          delivery.setCustomer(customer);
          delivery.setDeliveredBy(deliveredBy);

          return mapper.toResponse(repository.save(delivery));
     }

     @Override
     public VehicalDeliveryResponseDto getDeliveryById(Long id) {
          VehicalDelivery delivery = repository.findById(id)
                  .orElseThrow(() -> new EntityNotFoundException("Delivery record not found with id: " + id));
          return mapper.toResponse(delivery);
     }

     @Override
     public List<VehicalDeliveryResponseDto> getAllDeliveries() {
          return repository.findAll().stream()
                  .map(mapper::toResponse)
                  .collect(Collectors.toList());
     }

     @Override
     public VehicalDeliveryResponseDto updateDelivery(Long id, VehicalDeliveryRequestDto requestDto) {
          VehicalDelivery existingDelivery = repository.findById(id)
                  .orElseThrow(() -> new EntityNotFoundException("Delivery record not found with id: " + id));

          existingDelivery.setInvoiceNumber(requestDto.getInvoiceNumber());
          existingDelivery.setDeliveryDate(requestDto.getDeliveryDate());
          existingDelivery.setInvoiceAmount(requestDto.getInvoiceAmount());

          if (existingDelivery.getVehicle() == null || !existingDelivery.getVehicle().getId().equals(requestDto.getVehicleId())) {
               VehicleInventory vehicle = vehicleRepository.findById(requestDto.getVehicleId())
                       .orElseThrow(() -> new EntityNotFoundException("Vehicle inventory not found with id: " + requestDto.getVehicleId()));
               existingDelivery.setVehicle(vehicle);
          }

          if (existingDelivery.getCustomer() == null || !existingDelivery.getCustomer().getId().equals(requestDto.getCustomerId())) {
               Customers customer = customersRepository.findById(requestDto.getCustomerId())
                       .orElseThrow(() -> new EntityNotFoundException("Customer not found with id: " + requestDto.getCustomerId()));
               existingDelivery.setCustomer(customer);
          }

          if (existingDelivery.getDeliveredBy() == null || !existingDelivery.getDeliveredBy().getId().equals(requestDto.getDeliveredById())) {
               Employee deliveredBy = employeeRepository.findById(requestDto.getDeliveredById())
                       .orElseThrow(() -> new EntityNotFoundException("Employee not found with id: " + requestDto.getDeliveredById()));
               existingDelivery.setDeliveredBy(deliveredBy);
          }

          return mapper.toResponse(repository.save(existingDelivery));
     }

     @Override
     public void deleteDelivery(Long id) {
          if (!repository.existsById(id)) {
               throw new EntityNotFoundException("Delivery record not found with id: " + id);
          }
          repository.deleteById(id);
     }

}
