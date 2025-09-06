package strategy;

public final class ListGenerator {

    private final int SMALL_LIST_SIZE = 30;
    private final int LARGE_LIST_SIZE = 100000;

    public int smallArray[];
    public int largeArray[];

    public ListGenerator() {
        this.largeArray = new int[LARGE_LIST_SIZE];
        this.smallArray = new int[SMALL_LIST_SIZE];
        initializeLists();
    }

    public void initializeLists() {
        // Täytetään pieni lista
        System.out.println("Pieni lista alustettu. Koko: " + SMALL_LIST_SIZE);

        for (int i = 0; i < SMALL_LIST_SIZE; i++) {
            this.smallArray[i] = (int) (Math.random() * 10) + 1;
        }

        // Täytetään iso lista
        System.out.println("Iso lista alustettu. Koko: " + LARGE_LIST_SIZE);

        for (int i = 0; i < LARGE_LIST_SIZE; i++) {
            this.largeArray[i] = (int) (Math.random() * 10) + 1;
        }
    }

    public int[] getLargeList() {
        return this.largeArray;
    }

    public int[] getSmallList() {
        return this.smallArray;
    }
}
