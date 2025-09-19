package proxy;

public interface IDocument {

    String getContent();

    String getContent(User user);

    String getCreationDate();

    int getId();
}
