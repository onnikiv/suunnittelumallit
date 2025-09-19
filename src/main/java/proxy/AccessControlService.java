package proxy;

import java.util.HashSet;
import java.util.Set;

public class AccessControlService {

    private static AccessControlService instance;
    private final Set<String> allowedPairs;

    private AccessControlService() {
        allowedPairs = new HashSet<>();
    }

    public static AccessControlService getInstance() {
        if (instance == null) {
            instance = new AccessControlService();
        }
        return instance;
    }

    public void allowUser(int documentId, String username) {
        allowedPairs.add(documentId + ":" + username);
    }

    public boolean isAllowed(int documentId, String username) {
        return allowedPairs.contains(documentId + ":" + username);
    }
}
