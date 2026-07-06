package cmms.logistics.dto;

import cmms.logistics.entity.Notifications.NotificationType;
import cmms.logistics.entity.Notifications.RecipientRole;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class NotificationsRequestDto {


    @NotNull(message = "Recipient role is required")
    private RecipientRole recipientRole;


    @NotBlank(message = "Notification message is required")
    private String message;


    @NotNull(message = "Notification type is required")
    private NotificationType notificationType;


    @Builder.Default
    private Boolean isRead = false;


}
