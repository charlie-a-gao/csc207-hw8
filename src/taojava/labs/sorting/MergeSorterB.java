package taojava.labs.sorting;

import java.util.Arrays;
import java.util.Comparator;

public class MergeSorterB<T>
    extends SorterBridge<T>
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
  public T[] sort(T[] vals, int lb, int ub, T[] scratch,Comparator<T> order)
  {
    // Base case: Singleton arrays need not be sorted.
    if (vals.length <= 1)
      {
        return vals;
      } // if length <= 1
    else
      {
        int mid = vals.length / 2;
        T[] left = sort(Arrays.copyOfRange(vals, 0, mid), order);
        T[] right = sort(Arrays.copyOfRange(vals, mid, vals.length), order);
        return Utils.merge(order, left, right);
      } // recursive case: More than one element
  } // sort(T[], Comparator<T>)

}
