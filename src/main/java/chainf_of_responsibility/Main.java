package chainf_of_responsibility;

import chainf_of_responsibility.message.Message;
import chainf_of_responsibility.message.MessageType;
import chainf_of_responsibility.message_handlers.CompensationHandler;
import chainf_of_responsibility.message_handlers.ContactRequestHandler;
import chainf_of_responsibility.message_handlers.DevelopmentSuggestionHandler;
import chainf_of_responsibility.message_handlers.GeneralFeedbackHandler;
import chainf_of_responsibility.message_handlers.MessageHandler;

public class Main {

    public static void main(String[] args) {

        MessageHandler primaryMessageHandler;

        MessageHandler compensation = new CompensationHandler();
        MessageHandler contactRequest = new ContactRequestHandler();
        MessageHandler developmentSuggestion = new DevelopmentSuggestionHandler();
        MessageHandler generalFeedback = new GeneralFeedbackHandler();

        compensation.setNextMessageHandler(contactRequest);
        contactRequest.setNextMessageHandler(developmentSuggestion);
        developmentSuggestion.setNextMessageHandler(generalFeedback);

        // pelkästään generalfeedback
        primaryMessageHandler = compensation;

        Message compensationMessage = new Message(MessageType.COMPENSATION_CLAIM, "I want my money back", "compensation@demo.com");
        Message contactMessage = new Message(MessageType.CONTACT_REQUEST, "I need help with my account.", "contact@demo.com");
        Message devSuggestionMessage = new Message(MessageType.DEVELOPMENT_SUGGESTION, "I've got a great idea to fix ur site.", "devsuggestion@demo.com");
        Message generalFeedMessage = new Message(MessageType.GENERAL_FEEDBACK, "Love the app!", "generalfeedback@demo.com");

        primaryMessageHandler.handleFeedback(compensationMessage);
        primaryMessageHandler.handleFeedback(contactMessage);
        primaryMessageHandler.handleFeedback(devSuggestionMessage);
        primaryMessageHandler.handleFeedback(generalFeedMessage);

    }

}
