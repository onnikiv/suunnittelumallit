package strategy;

import strategy.sorting_algorithms.BubbleSort;
import strategy.sorting_algorithms.RadixSort;
import strategy.sorting_algorithms.TimSort;

public class Main {

    public static void main(String[] args) {

        ListGenerator listGenerator = new ListGenerator();
        SortingContext sortingHandler = new SortingContext(new BubbleSort());

        // BubbleSort
        double bSmall = calculateTime(listGenerator, sortingHandler, "SMALL");
        double bLarge = calculateTime(listGenerator, sortingHandler, "LARGE");

        // RadixSort
        sortingHandler.setSortingStrategy(new RadixSort());
        double rLarge = calculateTime(listGenerator, sortingHandler, "LARGE");
        double rSmall = calculateTime(listGenerator, sortingHandler, "SMALL");

        // TimSort
        sortingHandler.setSortingStrategy(new TimSort());
        double tLarge = calculateTime(listGenerator, sortingHandler, "LARGE");
        double tSmall = calculateTime(listGenerator, sortingHandler, "SMALL");

        // Lopputulokset:
        System.out.println("---------TIME (seconds)---------");
        System.out.println("| METHOD |   SMALL  |  LARGE   |");
        System.out.println("|--------|----------|----------|");
        System.out.println("| BUBBLE |  " + bSmall / 1000 + "      " + bLarge / 1000);
        System.out.println("| RADIX  |  " + rSmall / 1000 + "      " + rLarge / 1000);
        System.out.println("| TIM    |  " + tSmall / 1000 + "      " + tLarge / 1000);

    }

    static long calculateTime(ListGenerator listGenerator, SortingContext sortingHandler, String size) {
        long start = System.currentTimeMillis();

        if ("LARGE".equals(size)) {
            sortingHandler.processSorting(listGenerator.getLargeList());
        } else {
            sortingHandler.processSorting(listGenerator.getSmallList());
        }

        long end = System.currentTimeMillis() - start;

        return end;
    }
}
