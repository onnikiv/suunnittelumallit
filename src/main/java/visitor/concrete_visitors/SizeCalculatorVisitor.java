package visitor.concrete_visitors;

import visitor.FileSystemElement;
import visitor.FileSystemVisitor;
import visitor.concrete_elements.Directory;
import visitor.concrete_elements.File;

public class SizeCalculatorVisitor implements FileSystemVisitor {

    private int totalSize = 0;

    public int getTotalSize() {
        return totalSize;
    }

    @Override
    public void visit(File file) {
        totalSize += file.getSize();
    }

    @Override
    public void visit(Directory directory) {
        for (FileSystemElement elem : directory.getContent()) {
            elem.accept(this);
        }
    }
}
