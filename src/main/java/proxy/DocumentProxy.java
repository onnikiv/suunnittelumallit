package proxy;

public class DocumentProxy implements IDocument {

    private final Document document;
    private final AccessControlService accessControlService;

    public DocumentProxy(Document document) {
        this.document = document;
        this.accessControlService = AccessControlService.getInstance();
    }

    @Override
    public String getContent(User user) {
        if (accessControlService.isAllowed(document.getId(), user.getUserName())) {
            return document.getContent();
        } else {
            throw new AccessDeniedException("Access denied for user: " + user.getUserName());
        }
    }

    @Override
    public String getCreationDate() {
        return document.getCreationDate();
    }

    @Override
    public int getId() {
        return document.getId();
    }

    @Override
    public String getContent() {
        return "";
    }
}
