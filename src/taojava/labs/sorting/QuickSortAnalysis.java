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
   * An analysis of the affect that choosing pivot points has.
   * From this implementation of QuickSort, choosing the middle is always the best choice. 
   * Both of the random ways of choosing the pivot points result in stack overflows on even moderately sized array
   * Choosing the lower bound as the pivot is the slowest usually, though it takes a larger sized array to overflow it.
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
} // SampleAnalysis