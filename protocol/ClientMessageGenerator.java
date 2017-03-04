import model.User;

public class ClientMessageGenerator {

    public static String generatePublicMessage(String message) {
        return MessageType.PUBLIC.toString()
            + " " + message
        ;
    }

    public static String generatePrivateMessage(String message, User receiver) {
        return MessageType.PRIVATE.toString()
            + " " + receiver.getName()
            + " " + message
        ;
    }
}
