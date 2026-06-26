package cmms.Logistics.services;

import cmms.Logistics.Dto.NotificationsRequestDto;
import cmms.Logistics.Dto.NotificationsResponseDto;
import cmms.Logistics.entity.Notifications;
import cmms.Logistics.repository.NotificationsRepository;
import cmms.Logistics.services.NotificationsServices;
import cmms.Logistics.utils.NotificationsMapper;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class NotificationsServiceImp implements NotificationsServices {

    private final NotificationsRepository repository;
    private final NotificationsMapper mapper;

    @Override
    @Transactional
    public NotificationsResponseDto createNotification(NotificationsRequestDto requestDto) {
        Notifications notification = mapper.toEntity(requestDto);
        return mapper.toResponse(repository.save(notification));
    }

    @Override
    @Transactional(readOnly = true)
    public NotificationsResponseDto getNotificationById(Long id) {
        Notifications notification = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Notification record not found with id: " + id));
        return mapper.toResponse(notification);
    }

    @Override
    @Transactional(readOnly = true)
    public List<NotificationsResponseDto> getAllNotifications() {
        return repository.findAll().stream()
                .map(mapper::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public NotificationsResponseDto updateNotification(Long id, NotificationsRequestDto requestDto) {
        Notifications existingNotification = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Notification record not found with id: " + id));

        existingNotification.setRecipientRole(requestDto.getRecipientRole());
        existingNotification.setMessage(requestDto.getMessage());
        existingNotification.setNotificationType(requestDto.getNotificationType());
        existingNotification.setIsRead(requestDto.getIsRead() != null ? requestDto.getIsRead() : existingNotification.getIsRead());

        return mapper.toResponse(repository.save(existingNotification));
    }

    @Override
    @Transactional
    public NotificationsResponseDto markAsRead(Long id) {
        Notifications existingNotification = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Notification record not found with id: " + id));
        existingNotification.setIsRead(true);
        return mapper.toResponse(repository.save(existingNotification));
    }

    @Override
    @Transactional
    public void deleteNotification(Long id) {
        if (!repository.existsById(id)) {
            throw new EntityNotFoundException("Notification record not found with id: " + id);
        }
        repository.deleteById(id);
    }
}
