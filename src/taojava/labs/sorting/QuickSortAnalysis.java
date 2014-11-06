package taojava.labs.sorting;

import java.io.PrintWriter;

/**
 * A very simple analysis of a quicksort
 * 
 * @author Samuel A. Rebelsky
 * @author Nicolas Knoebber
 */
public class QuickSortAnalysis
{
  /**
   * A 'quick' analysis of the affect that choosing pivot points has:
   * From this implementation of QuickSort, choosing the middle is almost always the best choice.
   * Choosing the lower bound is almost always the slowest by far, 
   * the only exceptions are some randomly generated lists.
   * Choosing the median of 3 randomly generated points seems to be almost the same as random, 
   * though it performs slightly better in a reverse order list
   * Both of these are slightly slower on average then choosing the middle.
   * Sorting an array in reverse order and having the pivot be the lower bound is extremely slow, and will overflow
   * the stack. 
   * 
   */
  public static void main(String[] args)
  {

    PrintWriter pen = new PrintWriter(System.out, true);
    @SuppressWarnings("unchecked")
    Sorter<Integer>[] sorters =
        (Sorter<Integer>[]) new Sorter[] { new NewQuicksorter<Integer>(),
                                          new MiddleQuicksort<Integer>(),
                                          new MedianQuicksort<Integer>(),
                                          new RandomQuicksort<Integer>() };
    String[] sorterNames = { "lower bound", "middle", "median", "random" };

    @SuppressWarnings("unchecked")
    ArrayBuilder<Integer>[] builders =
        (ArrayBuilder<Integer>[]) new ArrayBuilder[] {
                                                      SorterAnalyzer.randomIntArrBuilder,
                                                      SorterAnalyzer.increasingIntArrBuilder,
                                                      SorterAnalyzer.mostlyInOrderBuilder,
                                                      SorterAnalyzer.reverseOrderBuilder };
    String[] builderNames =
        { "Random", "Increasing", "Mostly in Order", "Reverse Order" };

    SorterAnalyzer.combinedAnalysis(pen, sorters, sorterNames,
                                    SorterAnalyzer.standardIntComparator,
                                    builders, builderNames);

  } // main(String[]
} // QuickSortAnalysis