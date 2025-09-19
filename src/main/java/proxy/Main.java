package proxy;

public class Main {

    public static void main(String[] args) {
        AccessControlService accessControlService = AccessControlService.getInstance();
        Library library = new Library();

        User user1 = new User("Jorma");
        User user2 = new User("Pertti");

        library.addUnprotectedDocument(1, "Syö puuroa", "2025-09-19");
        library.addProtectedDocument(2, "Salainen resepti", "2025-09-19");

        accessControlService.allowUser(2, user1.getUserName());

        // printataan suojaamaton dokumentti molemmilla käyttäjillä
        System.out.println("Jorma: " + library.getDocument(1).getContent(user1));
        System.out.println("Pertti: " + library.getDocument(1).getContent(user2));

        try {
            System.out.println("Jorma: " + library.getDocument(2).getContent(user1));
            System.out.println("Pertti: " + library.getDocument(2).getContent(user2));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
