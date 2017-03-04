import model.*;
import util.event.*;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        User jacques = new User("Jacques", 4, 6);
        User robert = new User("Robert", 5, 8);
        User jacqueline = new User("Jacqueline", 7, 2);

        Conversation jacquesAndRobert = new Conversation();

        // Conversation between Jacques and Robert
        jacquesAndRobert.addMessage(new PrivateMessage(jacques, "Salut Roro, bien ou bien ?", robert));
        jacquesAndRobert.addMessage(new PrivateMessage(jacques, "Yo ! Bien et toi ?", robert));
        jacquesAndRobert.addMessage(new PrivateMessage(jacques, "Ça va, tranquille !", robert));

        // Conversation with everyone
        Conversation everyone = new Conversation();
        ArrayList<User> allButJacques = new ArrayList<User>();
        allButJacques.add(robert);
        allButJacques.add(jacqueline);

        ArrayList<User> allButRobert = new ArrayList<User>();
        allButJacques.add(jacques);
        allButJacques.add(jacqueline);

        everyone.addMessage(new PublicMessage(jacques, "Salut tout le monde !", allButJacques));
        everyone.addMessage(new PublicMessage(robert, "Salut tout le monde !", allButRobert));

        System.out.println("-- Jacques et Robert : --");
        System.out.print(jacquesAndRobert.toString());

        System.out.println("-- Tout le monde : --");
        System.out.println(everyone.toString());

    }
}
