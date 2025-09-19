package proxy;

import java.util.HashMap;

public class Library {

    private final HashMap<Integer, IDocument> documents;

    public Library() {
        this.documents = new HashMap<>();
    }

    public void addUnprotectedDocument(int documentId, String content, String creationDate) {
        documents.put(documentId, new Document(documentId, content, creationDate));
    }

    public void addProtectedDocument(int documentId, String content, String creationDate) {
        Document realDocument = new Document(documentId, content, creationDate);
        documents.put(documentId, new DocumentProxy(realDocument));
    }

    public IDocument getDocument(int documentId) {
        return documents.get(documentId);
    }
}
