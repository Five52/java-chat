package model;

/**
 * @author Thomas Fortin
 */
public class PrivateMessage extends Message {
    private User toUser;

    public PrivateMessage(User fromUser, String content, User toUser) {
        super(fromUser, content);
        this.toUser = toUser;
    }

    public User getToUser() {
        return this.toUser;
    }

    public void setToUser(User toUser) {
        this.toUser = toUser;
    }
}
