package chain_of_responsibility.message;

public class Message {

    private final MessageType messageType;
    private final String messageContent;
    private final String senderEmail;

    // message type, message content , and sender email
    public Message(MessageType messageType, String messageContent, String senderEmail) {

        this.messageType = messageType;
        this.messageContent = messageContent;
        this.senderEmail = senderEmail;
    }

    public MessageType getMessageType() {
        return this.messageType;
    }

    public String getMessageContent() {
        return this.messageContent;
    }

    public String getMessageSenderEmail() {
        return this.senderEmail;
    }
}
