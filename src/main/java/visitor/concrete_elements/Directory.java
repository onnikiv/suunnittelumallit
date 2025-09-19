package visitor.concrete_elements;

import java.util.ArrayList;

import visitor.FileSystemElement;
import visitor.FileSystemVisitor;

public class Directory implements FileSystemElement {

    private final ArrayList<FileSystemElement> content;
    private final String name;

    public Directory(String name) {
        this.name = name;
        this.content = new ArrayList<>();

    }

    public String getName() {
        return this.name;
    }

    public ArrayList<FileSystemElement> getContent() {
        return this.content;
    }

    public void add(FileSystemElement fileSystemElement) {
        this.content.add(fileSystemElement);
    }

    @Override
    public void accept(FileSystemVisitor fileSystemVisitor) {
        fileSystemVisitor.visit(this);
    }
}
