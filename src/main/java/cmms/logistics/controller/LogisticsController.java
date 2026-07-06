package cmms.logistics.controller;


import cmms.logistics.dto.NotificationsRequestDto;
import cmms.logistics.dto.NotificationsResponseDto;
import cmms.logistics.dto.VehicalDeliveryRequestDto;
import cmms.logistics.dto.VehicalDeliveryResponseDto;
import cmms.logistics.services.NotificationsServices;
import cmms.logistics.services.VehicalDeliveryServices;
import cmms.logistics.usercontext.RequireRole;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Logistics")
@RequiredArgsConstructor
@Slf4j
public class LogisticsController {

    private final VehicalDeliveryServices service;

    private final NotificationsServices notificationsservice;


    @GetMapping("/checking")
    @RequireRole({"ADMIN","PLANT_MANAGER"})
    public String checkings(){
        log.info("I am in the Logistic Controller");
        return "Input Checking for the Logistics GetMapping";
    }

    @PostMapping("/AddDelivery")
    @RequireRole({"ADMIN","PLANT_MANAGER"})
    public VehicalDeliveryResponseDto createVehical( @RequestBody VehicalDeliveryRequestDto requestDto) {
        return service.createDelivery(requestDto);
    }

    @GetMapping("/GetById/{id}")
    @RequireRole({"ADMIN","PLANT_MANAGER"})
    public VehicalDeliveryResponseDto getByIdVehical(@PathVariable Long id) {
        return service.getDeliveryById(id);
    }

    @GetMapping("/GetAllDeliveries")
    @RequireRole({"ADMIN","PLANT_MANAGER"})
    public List<VehicalDeliveryResponseDto> getAllVehical() {
        return service.getAllDeliveries();
    }

    @PutMapping("/UpdateByIdVehicals/{id}")
    @RequireRole({"ADMIN","PLANT_MANAGER"})
    public VehicalDeliveryResponseDto updateVehical( @PathVariable Long id, @RequestBody VehicalDeliveryRequestDto requestDto) {
        return service.updateDelivery(id, requestDto);
    }

    @DeleteMapping("/DeleteById/{id}")
    @RequireRole({"ADMIN","PLANT_MANAGER"})
    public void deleteVehical(@PathVariable Long id) {
        service.deleteDelivery(id);
    }


    @PostMapping("/AddNotification")
    @RequireRole({"ADMIN","PLANT_MANAGER"})
    public NotificationsResponseDto createNotifications( @RequestBody NotificationsRequestDto requestDto) {
        return notificationsservice.createNotification(requestDto);
    }

    @GetMapping("/GetNotificationById/{id}")
    @RequireRole({"ADMIN","PLANT_MANAGER"})
    public NotificationsResponseDto notificationsgetById(@PathVariable Long id) {
        return notificationsservice.getNotificationById(id);
    }

    @GetMapping("/GetAllNotifications")
    @RequireRole({"ADMIN","PLANT_MANAGER"})
    public List<NotificationsResponseDto> getAllNotifications() {
        return notificationsservice.getAllNotifications();
    }

    @PutMapping("/UpdateNotificationById/{id}")
    @RequireRole({"ADMIN","PLANT_MANAGER"})
    public NotificationsResponseDto updateNotifications(
            @PathVariable Long id,
            @RequestBody NotificationsRequestDto requestDto) {
        return notificationsservice.updateNotification(id, requestDto);
    }

    @PatchMapping("/MarkAsRead/{id}")
    @RequireRole({"ADMIN","PLANT_MANAGER"})
    public NotificationsResponseDto markAsReadNotifications(@PathVariable Long id) {
        return notificationsservice.markAsRead(id);
    }

    @DeleteMapping("/DeleteNotificationById/{id}")
    @RequireRole({"ADMIN","PLANT_MANAGER"})
    public void delete(@PathVariable Long id) {
        notificationsservice.deleteNotification(id);
    }



}
