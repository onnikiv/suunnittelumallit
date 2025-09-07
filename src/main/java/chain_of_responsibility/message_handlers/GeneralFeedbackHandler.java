package chain_of_responsibility.message_handlers;

import chain_of_responsibility.message.Message;
import chain_of_responsibility.message.MessageType;

public class GeneralFeedbackHandler extends MessageHandler {

    @Override
    public void handleFeedback(Message message) {
        if (message.getMessageType() == MessageType.GENERAL_FEEDBACK) {
            System.out.println("\n-----GENERAL FEEDBACK-----");
            System.out.println("Sender: " + message.getMessageSenderEmail());
            System.out.println("Message: " + message.getMessageContent());
            System.out.println("Your message has been sent to be reviewed for general feedback.");
        } else {
            super.handleFeedback(message);
        }
    }
}
