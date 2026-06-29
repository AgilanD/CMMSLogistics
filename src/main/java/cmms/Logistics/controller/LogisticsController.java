package cmms.Logistics.controller;


import cmms.Logistics.Dto.NotificationsRequestDto;
import cmms.Logistics.Dto.NotificationsResponseDto;
import cmms.Logistics.Dto.VehicalDeliveryRequestDto;
import cmms.Logistics.Dto.VehicalDeliveryResponseDto;
import cmms.Logistics.services.NotificationsServices;
import cmms.Logistics.services.VehicalDeliveryServices;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Logistics")
@RequiredArgsConstructor
public class LogisticsController {

    private final VehicalDeliveryServices service;

    private final NotificationsServices Notificationsservice;


    @GetMapping("/checking")
    public String Checkings(){
        return "Input Checking for the Logistics GetMapping";
    }

    @PostMapping("/AddDelivery")
    public VehicalDeliveryResponseDto createVehical( @RequestBody VehicalDeliveryRequestDto requestDto) {
        return service.createDelivery(requestDto);
    }

    @GetMapping("/GetById/{id}")
    public VehicalDeliveryResponseDto getByIdVehical(@PathVariable Long id) {
        return service.getDeliveryById(id);
    }

    @GetMapping("/GetAllDeliveries")
    public List<VehicalDeliveryResponseDto> getAllVehical() {
        return service.getAllDeliveries();
    }

    @PutMapping("/UpdateById/{id}")
    public VehicalDeliveryResponseDto updateVehical(
            @PathVariable Long id,
            @RequestBody VehicalDeliveryRequestDto requestDto) {
        return service.updateDelivery(id, requestDto);
    }

    @DeleteMapping("/DeleteById/{id}")
    public void deleteVehical(@PathVariable Long id) {
        service.deleteDelivery(id);
    }


    @PostMapping("/AddNotification")
    public NotificationsResponseDto createNotifications( @RequestBody NotificationsRequestDto requestDto) {
        return Notificationsservice.createNotification(requestDto);
    }

    @GetMapping("/GetNotificationById/{id}")
    public NotificationsResponseDto NotificationsgetById(@PathVariable Long id) {
        return Notificationsservice.getNotificationById(id);
    }

    @GetMapping("/GetAllNotifications")
    public List<NotificationsResponseDto> getAllNotifications() {
        return Notificationsservice.getAllNotifications();
    }

    @PutMapping("/UpdateNotificationById/{id}")
    public NotificationsResponseDto updateNotifications(
            @PathVariable Long id,
            @RequestBody NotificationsRequestDto requestDto) {
        return Notificationsservice.updateNotification(id, requestDto);
    }

    @PatchMapping("/MarkAsRead/{id}")
    public NotificationsResponseDto markAsReadNotifications(@PathVariable Long id) {
        return Notificationsservice.markAsRead(id);
    }

    @DeleteMapping("/DeleteNotificationById/{id}")
    public void delete(@PathVariable Long id) {
        Notificationsservice.deleteNotification(id);
    }



}
