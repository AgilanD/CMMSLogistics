package cmms.Logistics.services;

import cmms.Logistics.Dto.NotificationsRequestDto;
import cmms.Logistics.Dto.NotificationsResponseDto;
import java.util.List;

public interface NotificationsServices {
    NotificationsResponseDto createNotification(NotificationsRequestDto requestDto);
    NotificationsResponseDto getNotificationById(Long id);
    List<NotificationsResponseDto> getAllNotifications();
    NotificationsResponseDto updateNotification(Long id, NotificationsRequestDto requestDto);
    NotificationsResponseDto markAsRead(Long id);
    void deleteNotification(Long id);
}
