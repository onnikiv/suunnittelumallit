package mediator;

import java.util.ArrayList;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ChatView extends Application {

    private final ConcreteMediator mediator = new ConcreteMediator();
    private final ArrayList<User> users = new ArrayList<>();
    private final ArrayList<TextArea> messageAreas = new ArrayList<>();

    @Override
    public void start(Stage primaryStage) {
        User user1 = new User(mediator, "User1");
        User user2 = new User(mediator, "User2");
        User user3 = new User(mediator, "User3");
        mediator.addUser(user1);
        mediator.addUser(user2);
        mediator.addUser(user3);

        users.add(user1);
        users.add(user2);
        users.add(user3);

        createChatWindow(user1);
        createChatWindow(user2);
        createChatWindow(user3);
        updateAllMessages();
    }

    private void createChatWindow(User user) {
        Stage stage = new Stage();
        Text titleText = new Text("Chat - " + user.getUsername());
        TextArea messageArea = new TextArea();
        messageArea.setEditable(false);
        TextField recipientField = new TextField();
        recipientField.setPromptText("Recipient username");
        TextField messageField = new TextField();
        messageField.setPromptText("Type your message");
        Button sendButton = new Button("Send");
        VBox root = new VBox(titleText, messageArea, recipientField, messageField, sendButton);
        root.setSpacing(10);
        stage.setTitle(user.getUsername());
        stage.setScene(new Scene(root, 400, 300));

        messageAreas.add(messageArea);

        sendButton.setOnAction(e -> {
            String recipient = recipientField.getText();
            String message = messageField.getText();
            if (!recipient.isEmpty() && !message.isEmpty()) {
                user.sendMessage(recipient, message);
                messageField.clear();
                updateAllMessages();
            }
        });

        stage.show();
    }

    private void updateAllMessages() {
        for (int i = 0; i < users.size(); i++) {
            User user = users.get(i);
            TextArea messageArea = messageAreas.get(i);
            StringBuilder sb = new StringBuilder();
            for (String msg : user.getMessages()) {
                sb.append(msg).append("\n");
            }
            messageArea.setText(sb.toString());
        }
    }
}
