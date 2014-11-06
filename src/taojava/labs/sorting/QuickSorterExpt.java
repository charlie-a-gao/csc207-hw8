package taojava.labs.sorting;

/**
 * A quick experiment with the insertion sorter.
 * 
 * @author Samuel A. Rebelsky
 */
public class QuickSorterExpt
{
  /**
   * Run the experiments.
   */
  public static void main(String[] args)
  {
    ExptUtils.iExperiments(new RandomQuicksort<Integer>());
    ExptUtils.sExperiments(new RandomQuicksort<String>());
  } // main(String[])
} // class QuickSorterExpt
