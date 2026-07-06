package cmms.logistics.exceptions;

public class NotificationAlreadyReadException extends RuntimeException {

    public NotificationAlreadyReadException(Long id) {
        super("Notification with id " + id + " is already marked as read.");
    }
}