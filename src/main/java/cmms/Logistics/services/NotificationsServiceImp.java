package cmms.Logistics.services;

import cmms.Logistics.repository.NotificationsRepository;
import org.springframework.stereotype.Service;

@Service
public class NotificationsServiceImp implements NotificationsServices{

    private final NotificationsRepository notificationrpository;


    public NotificationsServiceImp(NotificationsRepository notificationrpository) {
        this.notificationrpository = notificationrpository;
    }

}
