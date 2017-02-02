package dnr.model;

public class ChatWorld {
    protected HashMap<String, User> users;
    protected User mainUser;

    public ChatWorld(User mainUser) {
        this.users = new HashMap<String, User>();
        this.mainUser = mainUser;
    }

    public HashMap<String, User> getUsers() {
        return this.users;
    }

    public User getMainUser() {
        return this.mainUser;
    }
}
