package visitor;

import visitor.concrete_elements.Directory;
import visitor.concrete_elements.File;

public interface FileSystemVisitor {

    void visit(Directory directory);

    void visit(File file);

}
