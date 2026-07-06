package cmms.logistics.services;

import cmms.logistics.dto.NotificationsRequestDto;
import cmms.logistics.dto.NotificationsResponseDto;
import java.util.List;

public interface NotificationsServices {
    NotificationsResponseDto createNotification(NotificationsRequestDto requestDto);
    NotificationsResponseDto getNotificationById(Long id);
    List<NotificationsResponseDto> getAllNotifications();
    NotificationsResponseDto updateNotification(Long id, NotificationsRequestDto requestDto);
    NotificationsResponseDto markAsRead(Long id);
    void deleteNotification(Long id);
}
