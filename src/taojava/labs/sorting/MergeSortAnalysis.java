package taojava.labs.sorting;

import java.io.PrintWriter;

public class MergeSortAnalysis
{
  /**
   * Tests the different methods merge sorting
   * It seems like using a scratch array is not that much more efficient then a standard recursive sort,
   * though in some cases it does perform marginally better (usually 1 ms)
   * Iterative sort appears to be a bit slower then both of them, and suffers the worse losses
   * in reverse order lists, where the others do it twice as fast on large arrays. 
   */
  public static void main(String[] args)
  {
    PrintWriter pen = new PrintWriter(System.out, true);
    @SuppressWarnings("unchecked")
    Sorter<Integer>[] sorters =
        (Sorter<Integer>[]) new Sorter[] { new MergeSorter<Integer>(),
                                          new MergeSorterB<Integer>(),
                                          new IterativeMergeSorter<Integer>()};
    String[] sorterNames = { "Standard", "Scratch Array", "Iterative" };

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
}//MergeSortAnalysis
