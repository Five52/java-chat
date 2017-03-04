import model.User;

public abstract class MessageGenerator {

    public abstract String generatePublicMessage(String message);

    public abstract String generatePrivateMessage(String message, User receiver);

    public static String generateConnectionMessage(User newUser) {
        return MessageType.CONNECTION.toString()
            + " " + newUser.getName()
        ;
    }
}
