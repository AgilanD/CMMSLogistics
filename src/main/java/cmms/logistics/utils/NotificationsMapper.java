package cmms.logistics.utils;

import cmms.logistics.dto.NotificationsRequestDto;
import cmms.logistics.dto.NotificationsResponseDto;
import cmms.logistics.entity.Notifications;
import org.springframework.stereotype.Component;

@Component
public class NotificationsMapper {

    public NotificationsResponseDto toResponse(Notifications entity) {
        if (entity == null) return null;

        return NotificationsResponseDto.builder()
                .id(entity.getId())
                .recipientRole(entity.getRecipientRole())
                .message(entity.getMessage())
                .notificationType(entity.getNotificationType())
                .isRead(entity.getIsRead())
                .createdAt(entity.getCreatedAt())
                .createdBy(entity.getCreatedBy())
                .lastModifiedAt(entity.getLastModifiedAt())
                .lastModifiedBy(entity.getLastModifiedBy())
                .build();
    }

    public Notifications toEntity(NotificationsRequestDto requestDto) {
        if (requestDto == null) return null;

        return Notifications.builder()
                .recipientRole(requestDto.getRecipientRole())
                .message(requestDto.getMessage())
                .notificationType(requestDto.getNotificationType())
                .isRead(requestDto.getIsRead() != null ? requestDto.getIsRead() : null)
                .build();
    }
}
