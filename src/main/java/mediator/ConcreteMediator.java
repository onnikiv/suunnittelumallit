package mediator;

import java.util.ArrayList;
import java.util.List;

public class ConcreteMediator implements Mediator {

    private final List<User> users;

    public ConcreteMediator() {
        this.users = new ArrayList<>();
    }

    @Override
    public void addUser(User user) {
        users.add(user);
    }

    @Override
    public void sendMessage(String sender, String recipient, String message) {
        for (User user : users) {
            if (user.getUsername().equals(recipient)) {
                user.receiveMessage(sender, message);
                return;
            }
        }
        System.out.println("Recipient '" + recipient + "' not found.");
    }
}
