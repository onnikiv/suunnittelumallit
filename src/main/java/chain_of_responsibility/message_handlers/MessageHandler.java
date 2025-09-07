package chain_of_responsibility.message_handlers;

import chain_of_responsibility.message.Message;

public abstract class MessageHandler {

    private MessageHandler nextMessageHandler;

    public void setNextMessageHandler(MessageHandler nextMessageHandler) {
        this.nextMessageHandler = nextMessageHandler;
    }

    public void handleFeedback(Message message) {
        if (nextMessageHandler != null) {
            nextMessageHandler.handleFeedback(message);
        }
    }

}
