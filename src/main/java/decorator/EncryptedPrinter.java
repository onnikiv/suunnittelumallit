package decorator;

public class EncryptedPrinter extends PrinterDecorator {

    private final String VOWELS = "aeiouAEIOU";

    public EncryptedPrinter(Printer printer) {
        super(printer);
    }

    @Override
    public void print(String message) {

        String encryptedMessage = "";

        for (int i = 0; i < message.length(); i++) {
            char currentChar = message.charAt(i);
            if (VOWELS.contains(String.valueOf(currentChar))) {
                // jos vokaali 
                encryptedMessage += "*";
            } else {
                // jos konsonatti
                encryptedMessage += "#";
            }
        }

        super.print(encryptedMessage);
    }
}
