package server;

import java.util.Collection;
import java.util.ArrayList;


/**
 * @author Yoann Boyer
 */
class UserManager {
    private static UserManager INSTANCE = null;
    private Collection<Connexion> connexions;

    private UserManager() {
        this.connexions = new ArrayList<Connexion>();
    }

    public static UserManager getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new UserManager();
        }
        return INSTANCE;
    }

    /**
     * Add an user on the list
     * @param connexion The clien connexion
     * @return True if the user is not already registred
     *              (checked by its username)
     */
    public boolean add(Connexion connexion) {
        if (this.connexions.contains(connexion)) {
            return false;
        }

        connexions.add(connexion);
        return true;
    }

    /**
     * Send a message to clients
     * @param sender The sender
     * @param message The message
     */
    public void broadcast(Connexion sender, Message message) {
        for (Connexion connexion : this.connexions) {
            if (!connexion.equals(sender)) {
                connexion.send(message);
            }
        }
    }
}
