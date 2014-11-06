package taojava.labs.sorting;

import java.util.Arrays;
import java.util.Comparator;

//Credit to Noah Schlager for inspiration.

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
  public T[] sort(T[] vals, Comparator<T> order)
  {
    @SuppressWarnings("unchecked")
    T[] scratch = (T[]) new Object[vals.length];
    return mergeSort(vals, 0, vals.length, scratch, order);
  }
   
  public T[] mergeSort(T[] vals, int lb, int ub, T[] scratch, Comparator<T> order)
  {
    // Base case: Singleton arrays need not be sorted.
    if ((ub-lb) <= 1)
      {
        return vals;
      } // if length <= 1
    else
      {
        int mid = ((ub - lb)/2) + lb;                     
        mergeSort(vals,lb,mid,scratch,order);
        mergeSort(vals,mid,ub,scratch,order);
        
        for (int i = lb; i < ub; i++)
          scratch[i] = vals[i];
        
        return Utils.merge(order, scratch, lb, mid, scratch, mid, ub, vals, lb, ub);
      } // recursive case: More than one element
  } // sort(T[], Comparator<T>)

}
