package chainf_of_responsibility.message_handlers;

import chainf_of_responsibility.message.Message;
import chainf_of_responsibility.message.MessageType;

public class ContactRequestHandler extends MessageHandler {

    @Override
    public void handleFeedback(Message message) {
        if (message.getMessageType() == MessageType.CONTACT_REQUEST) {
            System.out.println("\n-----CONTACT REQUEST-----");
            System.out.println("Sender: " + message.getMessageSenderEmail());
            System.out.println("Message: " + message.getMessageContent());
            System.out.println("Your message has been sent to be reviewed for contact request");

        } else {
            super.handleFeedback(message);
        }
    }
}
