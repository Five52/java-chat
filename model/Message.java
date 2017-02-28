package model;

public abstract class Message {
    private User fromUser;
    private String content;

    public Message(User fromUser, String content) {
        this.fromUser = fromUser;
        this.content = content;
    }

    public User getFromUser() {
        return this.fromUser;
    }

    public void setFromUser(User fromUser) {
        this.fromUser = fromUser;
    }

    public String getContent() {
        return this.content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
