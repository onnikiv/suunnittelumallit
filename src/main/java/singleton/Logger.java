package singleton;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Logger {

    private String filename = "file.txt";
    private String path = "C:\\Users\\onnik\\Ohjelmointi\\suunnittelumallit\\src\\main\\java\\singleton\\";
    private File file;
    private static Logger instance;
    private FileWriter writer;

    private Logger() {
        this.file = new File(path + filename);

        try {
            if (file.createNewFile()) {
                System.out.println("File created: " + file.getName());
            } else {
                System.out.println("File already exists.");
            }

            this.writer = new FileWriter(file, true);

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
        try {
            if (this.writer != null) {
                this.writer.close();
            }
        } catch (IOException e) {
            System.out.println("An error occurred while closing current writer: " + e.getMessage());
        }

        this.filename = filename;
        this.file = new File(path + filename);

        try {
            if (file.createNewFile()) {
                System.out.println("New file created: " + file.getName());
            } else {
                System.out.println("File already exists: " + file.getName());
            }

            this.writer = new FileWriter(file, true);

        } catch (IOException e) {
            System.out.println("An error occurred while creating new file: " + e.getMessage());
        }
    }

    public void write(String message) {
        try {
            this.writer.append(message + "\n");
            System.out.println("Message: <" + message + "> has been written to file.");
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file: " + e.getMessage());
        }
    }

    public void close() {

        try {
            this.writer.close();
            System.out.println("Logger closed.");
        } catch (IOException e) {
            System.out.println("An error occurred while closing the writer: " + e.getMessage());
        }
    }

}
