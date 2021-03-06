package taojava.labs.sorting;

import java.io.PrintWriter;

public class InsertionAnalysis
{
  /**
   * Tests the different methods of insertion.
   * 
   * For all cases and arrays, shifting appears to be the fastest method of insertion. 
   * followed by doing a series of internal swaps, which seems to take about 3 times as long on reverse ordered arrays.
   * External swap is a tiny bit slower than internal swap, but it doesn't make that big of a difference. 
   */
  public static void main(String[] args)
  {
    PrintWriter pen = new PrintWriter(System.out, true);
    @SuppressWarnings("unchecked")
    Sorter<Integer>[] sorters =
        (Sorter<Integer>[]) new Sorter[] { new InsertionSorter<Integer>(),
                                          new InsertionSorterB<Integer>(),
                                          new InsertionSorterC<Integer>()};
    String[] sorterNames = { "internal swap", "shift", "external swap" };

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
}//InsertionAnalysis
