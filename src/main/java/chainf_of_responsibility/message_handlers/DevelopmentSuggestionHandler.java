package chainf_of_responsibility.message_handlers;

import chainf_of_responsibility.message.Message;
import chainf_of_responsibility.message.MessageType;

public class DevelopmentSuggestionHandler extends MessageHandler {

    @Override
    public void handleFeedback(Message message) {
        if (message.getMessageType() == MessageType.DEVELOPMENT_SUGGESTION) {
            System.out.println("\n-----DEVELOPMENT SUGGESTION-----");
            System.out.println("Sender: " + message.getMessageSenderEmail());
            System.out.println("Message: " + message.getMessageContent());
            System.out.println("Your message has been sent to be reviewed for development suggestions.");
        } else {
            super.handleFeedback(message);
        }
    }
}
