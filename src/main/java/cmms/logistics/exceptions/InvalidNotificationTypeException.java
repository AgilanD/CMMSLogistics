package cmms.logistics.exceptions;

public class InvalidNotificationTypeException extends RuntimeException {

    public InvalidNotificationTypeException(String type) {
        super("Invalid notification type: " + type);
    }
}