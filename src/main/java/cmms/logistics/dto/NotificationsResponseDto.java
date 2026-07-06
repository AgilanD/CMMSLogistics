package cmms.logistics.dto;

import cmms.logistics.entity.Notifications.NotificationType;
import cmms.logistics.entity.Notifications.RecipientRole;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class NotificationsResponseDto {

    private Long id;
    private RecipientRole recipientRole;
    private String message;
    private NotificationType notificationType;
    private Boolean isRead;
    private LocalDateTime createdAt;
    private Long createdBy;
    private LocalDateTime lastModifiedAt;
    private Long lastModifiedBy;

}
