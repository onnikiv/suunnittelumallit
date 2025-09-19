package visitor.concrete_elements;

import visitor.FileSystemElement;
import visitor.FileSystemVisitor;

public class File implements FileSystemElement {

    private final String name;
    private final int size;

    public File(String name, int size) {
        this.name = name;
        this.size = size;
    }

    public String getName() {
        return this.name;
    }

    public int getSize() {
        return this.size;
    }

    @Override
    public void accept(FileSystemVisitor fileSystemVisitor) {
        fileSystemVisitor.visit(this);
    }
}
