package model;

import java.util.ArrayList;

/**
 * @author Thomas Fortin
 */
public class PublicMessage extends Message {
    private ArrayList<User> toUsers;

    public PublicMessage(User fromUser, String content, ArrayList<User> toUsers) {
        super(fromUser, content);
        toUsers = new ArrayList<User>();
    }

    public ArrayList<User> getToUsers() {
        return this.toUsers;
    }

    public void addUser(User user) {
        toUsers.add(user);
    }

    public void removeUser(User user) {
        toUsers.remove(user);
    }
}
