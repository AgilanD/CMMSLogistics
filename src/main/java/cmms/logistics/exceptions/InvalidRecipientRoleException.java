package cmms.logistics.exceptions;

public class InvalidRecipientRoleException extends RuntimeException {

    public InvalidRecipientRoleException(String role) {
        super("Invalid recipient role: " + role);
    }
}