package visitor.concrete_visitors;

import java.util.ArrayList;
import java.util.List;

import visitor.FileSystemElement;
import visitor.FileSystemVisitor;
import visitor.concrete_elements.Directory;
import visitor.concrete_elements.File;

public class SearchVisitor implements FileSystemVisitor {

    private final String extension;
    private final List<File> foundFiles = new ArrayList<>();

    public SearchVisitor(String extension) {
        this.extension = extension;
    }

    public List<File> getFoundFiles() {
        return foundFiles;
    }

    @Override
    public void visit(File file) {
        if (file.getName().endsWith(extension)) {
            foundFiles.add(file);
        }
    }

    @Override
    public void visit(Directory directory) {
        for (FileSystemElement elem : directory.getContent()) {
            elem.accept(this);
        }
    }
}
