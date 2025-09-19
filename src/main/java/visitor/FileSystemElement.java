package visitor;

public interface FileSystemElement {

    void accept(FileSystemVisitor fileSystemVisitor);
}
