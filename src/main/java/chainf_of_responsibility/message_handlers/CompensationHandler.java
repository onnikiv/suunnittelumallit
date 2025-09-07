package chainf_of_responsibility.message_handlers;

import chainf_of_responsibility.message.Message;
import chainf_of_responsibility.message.MessageType;

public class CompensationHandler extends MessageHandler {

    @Override
    public void handleFeedback(Message message) {
        if (message.getMessageType() == MessageType.COMPENSATION_CLAIM) {
            System.out.println("\n-----COMPENSATION-----");
            System.out.println("Sender: " + message.getMessageSenderEmail());
            System.out.println("Message: " + message.getMessageContent());
            System.out.println("Your message has been sent to be reviewed for compensation.");

        } else {
            super.handleFeedback(message);
        }
    }
}
