package singleton;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Logger {

    private String filename = "file.txt";
    private String path = "C:\\Users\\onnik\\Ohjelmointi\\suunnittelumallit\\src\\main\\java\\singleton\\";
    private File file;
    private static Logger instance;

    private Logger() {
        this.file = new File(path + filename);

        try {

            if (file.createNewFile()) {
                System.out.println("File created: " + file.getName());
            } else {
                System.out.println("File already exists.");
            }

        } catch (IOException e) {
            System.out.println(e);
            System.out.println("An error occurred.");
        }

    }

    public static Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }

    public void setFileName(String filename) {
        this.filename = filename;
        File newFilename = new File(path + filename);
        file.renameTo(newFilename);
        this.file = newFilename;
    }

    public void write(String message) {
        try {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, true))) {
                writer.append(message + "\n");
            }
            System.out.println("Message has been written to file: " + message);
        } catch (IOException e) {
        }

    }

    public void close() {

    }

}
