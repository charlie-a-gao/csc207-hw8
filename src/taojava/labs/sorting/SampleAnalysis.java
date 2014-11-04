package taojava.labs.sorting;

import java.io.PrintWriter;

/**
 * A very simple analysis of a few sorting algorithms.
 * 
 * @author Samuel A. Rebelsky
 * @author Nicolas Knoebber
 */
public class SampleAnalysis
{

  public static void main(String[] args)
  {
    PrintWriter pen = new PrintWriter(System.out, true);
    @SuppressWarnings("unchecked")
    Sorter<Integer>[] sorters =
        (Sorter<Integer>[]) new Sorter[] { new BuiltinSorter<Integer>(),
                                          new InsertionSorter<Integer>(), 
                                          new NewQuicksorter<Integer>(),
                                          new MiddleQuicksort<Integer>()};
    String[] sorterNames = { "Built-in", "InsertionA","QuickSort", "QuickSortB" };

    @SuppressWarnings("unchecked")
    ArrayBuilder<Integer>[] builders =
        (ArrayBuilder<Integer>[]) new ArrayBuilder[] {
                                                      SorterAnalyzer.randomIntArrBuilder,
                                                      SorterAnalyzer.increasingIntArrBuilder,
                                                      SorterAnalyzer.mostlyInOrderBuilder,
                                                      SorterAnalyzer.reverseOrderBuilder};
    String[] builderNames = { "Random", "Increasing","Mostly in Order","Reverse Order" };

    SorterAnalyzer.combinedAnalysis(pen, sorters, sorterNames,
                                    SorterAnalyzer.standardIntComparator,
                                    builders, builderNames);
  } // main(String[]
} // SampleAnalysis
