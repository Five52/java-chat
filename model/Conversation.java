package model;

import java.util.ArrayList;

/**
 * @author Thomas Fortin
 */
public class Conversation {
    private ArrayList<Message> messages;

    public Conversation() {
        messages = new ArrayList<Message>();
    }

    public void addMessage(Message message) {
        messages.add(message);
    }

    public ArrayList<Message> getMessages() {
        return messages;
    }
}
