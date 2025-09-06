package strategy;

public class SortingContext {

    private SortingStrategy sortingStrategy;

    public SortingContext(SortingStrategy sortingStrategy) {
        this.sortingStrategy = sortingStrategy;
    }

    public void processSorting(int array[]) {
        this.sortingStrategy.processSorting(array);
    }

    public void setSortingStrategy(SortingStrategy sortingStrategy) {
        this.sortingStrategy = sortingStrategy;
    }

    public void printCurrentSortingStrategy() {
        System.out.println(this.sortingStrategy.getClass().getSimpleName());
    }
}
