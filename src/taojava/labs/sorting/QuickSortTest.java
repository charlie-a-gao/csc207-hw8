package taojava.labs.sorting;

import java.io.PrintWriter;

public class QuickSortTest
{
  public static void main(String args[])
  {
    NewQuicksorter quick = new NewQuicksorter<Integer>();
    ExptUtils.iExperiments(quick);
  }
}
