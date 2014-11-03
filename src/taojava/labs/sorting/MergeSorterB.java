package taojava.labs.sorting;

import java.util.Comparator;

public class MergeSorterB<T> extends SorterBridge<T>
{
  /*
//Sort all the elements
MergeSort(values)
 MergeSort(values, lb, ub, new scratch array)
//Sort elements in positions [lb..ub), using scratch for temporary
//storage.
MergeSort(values, lb, ub, scratch)
 If the subarray is small
   do nothing
 Otherwise
   Sort the first half (using scratch as necessary)
   Sort the second half (using scratch as necessary)
   Copy the sorted halves into scratch
   Merge back into values
   
   */
  public T[] sort(T[] vals, Comparator<T> order)
  {
    
  }
  
}
