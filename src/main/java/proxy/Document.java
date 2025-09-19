package proxy;

public class Document implements IDocument {

    private final int id;
    private final String content;
    private final String creationDate;

    public Document(int id, String content, String creationDate) {
        this.id = id;
        this.content = content;
        this.creationDate = creationDate;
    }

    @Override
    public String getContent() {
        return this.content;
    }

    @Override
    public String getContent(User user) {
        return this.content;
    }

    @Override
    public String getCreationDate() {
        return this.creationDate;
    }

    @Override
    public int getId() {
        return this.id;
    }

}
