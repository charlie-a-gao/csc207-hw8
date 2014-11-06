package taojava.labs.sorting;

import java.io.PrintWriter;

public class InsertionAnalysis
{
  /**
   * Tests the different methods of insertion.
   * 
   * For all cases and arrays, internal swap appears to be the fastest, 
   * followed by shift, and then external swap, which is almost twice as slow 
   * as internal swap.
   */
  public static void main(String[] args)
  {
    PrintWriter pen = new PrintWriter(System.out, true);
    @SuppressWarnings("unchecked")
    Sorter<Integer>[] sorters =
        (Sorter<Integer>[]) new Sorter[] { new InsertionSorter<Integer>(),
                                          new InsertionSorterB<Integer>(),
                                          new InsertionSorterC<Integer>()};
    String[] sorterNames = { "shift", "internal swap", "external swap" };

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
}
