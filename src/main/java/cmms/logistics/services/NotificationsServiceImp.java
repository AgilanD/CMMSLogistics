package cmms.logistics.services;

import cmms.logistics.dto.NotificationsRequestDto;
import cmms.logistics.dto.NotificationsResponseDto;
import cmms.logistics.entity.Notifications;
import cmms.logistics.exceptions.NotificationAlreadyReadException;
import cmms.logistics.exceptions.NotificationNotFoundException;
import cmms.logistics.repository.NotificationsRepository;
import cmms.logistics.utils.NotificationsMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class NotificationsServiceImp implements NotificationsServices {

    private final NotificationsRepository repository;
    private final NotificationsMapper mapper;

    @Override
    public NotificationsResponseDto createNotification(NotificationsRequestDto requestDto) {
        Notifications notification = mapper.toEntity(requestDto);
        Notifications savedNotification = repository.save(notification);
        return mapper.toResponse(savedNotification);
    }

    @Override
    public NotificationsResponseDto getNotificationById(Long id) {
        Notifications notification = repository.findById(id)
                .orElseThrow(() -> new NotificationNotFoundException(id));

        return mapper.toResponse(notification);
    }

    @Override
    public List<NotificationsResponseDto> getAllNotifications() {
        return repository.findAll()
                .stream()
                .map(mapper::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public NotificationsResponseDto updateNotification(Long id, NotificationsRequestDto requestDto) {

        Notifications existingNotification = repository.findById(id)
                .orElseThrow(() -> new NotificationNotFoundException(id));

        existingNotification.setRecipientRole(requestDto.getRecipientRole());
        existingNotification.setMessage(requestDto.getMessage());
        existingNotification.setNotificationType(requestDto.getNotificationType());

        if (requestDto.getIsRead() != null) {
            existingNotification.setIsRead(requestDto.getIsRead());
        }

        Notifications updatedNotification = repository.save(existingNotification);
        return mapper.toResponse(updatedNotification);
    }

    @Override
    public NotificationsResponseDto markAsRead(Long id) {

        Notifications existingNotification = repository.findById(id)
                .orElseThrow(() -> new NotificationNotFoundException(id));

        if (Boolean.TRUE.equals(existingNotification.getIsRead())) {
            throw new NotificationAlreadyReadException(id);
        }

        existingNotification.setIsRead(true);

        Notifications updatedNotification = repository.save(existingNotification);
        return mapper.toResponse(updatedNotification);
    }

    @Override
    public void deleteNotification(Long id) {

        Notifications notification = repository.findById(id)
                .orElseThrow(() -> new NotificationNotFoundException(id));

        repository.delete(notification);
    }
}