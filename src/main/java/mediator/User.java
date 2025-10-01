package mediator;

import java.util.ArrayList;
import java.util.List;

public class User {

    private final Mediator mediator;
    private final String username;
    private final List<String> messages;

    public User(Mediator mediator, String username) {
        this.mediator = mediator;
        this.username = username;
        this.messages = new ArrayList<>();
    }

    public String getUsername() {
        return username;
    }

    public void sendMessage(String recipient, String message) {
        mediator.sendMessage(username, recipient, message);
    }

    public void receiveMessage(String sender, String message) {
        String fullMessage = sender + ": " + message;
        messages.add(fullMessage);
        System.out.println("[" + username + "] " + fullMessage);
    }

    public List<String> getMessages() {
        return new ArrayList<>(messages);
    }

    public void printMessages() {
        System.out.println("Messages for " + username + ":");
        for (String msg : messages) {
            System.out.println(msg);
        }
    }
}
