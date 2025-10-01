package mediator;

public interface Mediator {

    void sendMessage(String sender, String recipient, String message);

    void addUser(User user);
}
