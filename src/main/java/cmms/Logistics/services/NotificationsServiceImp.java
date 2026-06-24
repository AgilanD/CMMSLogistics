package cmms.Logistics.services;

import cmms.Logistics.repository.NotificationsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NotificationsServiceImp implements NotificationsServices{

    private final NotificationsRepository notificationrpository;





}
