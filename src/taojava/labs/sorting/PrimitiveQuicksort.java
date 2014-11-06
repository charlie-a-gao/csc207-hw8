package taojava.labs.sorting;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Sort using a slightly different version of Quicksort.
 *
 * @author Samuel A. Rebelsky
 * @author Your Name Here.
 */
public class PrimitiveQuicksort
    extends SorterBridge
{
  /**
   * Sort vals using Quicksort.  See the Sorter<T> interface
   * for additional details.
   */
  public int[] sorti(int[] vals)
  {
    qsort(vals, 0, vals.length);
    return vals;
  } // sorti(T[], Comparator<T>)

  /**
   * Sort the elements in positions [lb..ub) using Quicksort.
   */
  public void qsort(int[] vals, int lb, int ub)
  {
    //System.err.println("qsort(" + Arrays.toString(vals) + ", " + lb + "," + ub);
    // One element arrays are sorted.
    if (lb >= ub - 1)
      {
        return;
      }
    else
      {
        int pivot = selectPivot(vals,lb, ub);
        int[] bounds = partition(pivot, vals, lb, ub);
        //System.err.println("After partitioning with " + pivot + ", bounds: " + Arrays.toString(bounds));
        //System.err.println(Arrays.toString(vals));
        qsort(vals, lb, bounds[0]);
        qsort(vals, bounds[1], ub);
      } // More than one element
  } // qsort(T[], Comparator<T>, int, int)

  /**
   * Select a pivot from within positions [lb..ub) of vals.
   */
  public int selectPivot(int[] vals, int lb, int ub)
  {
    return vals[(lb+ub)/2];
  } // selectPivot(T[], Comparator<T>, int, int)

  /**
   * Reorganize the elements in positions [lb..ub) of vals such that
   * elements smaller than the pivot appear to the left, elements
   * bigger than the pivot appear to the right of the pivot, and
   * copies of the pivot are in the middle.  Return a two-element
   * array that gives the lower bound (inclusive) and upper bound
   * (exclusive) of the section of the array that contains the equal
   * values.
   *
   * @param
   *    pivot, a value
   * @param
   *    values, an array.
   * @param
   *    order, a comparator.
   * @param
   *    lb, an integer.
   * @param
   *    ub, an integer.
   * @return
   *    mid, the index of the pivot.
   *
   * @pre
   *    order can be applied to any pair of elements in vals.
   * @pre
   *    0 <= lb < ub < values.length.
   * @post
   *    lb <= mid < ub
   * @post
   *    values[mid] == pivot, for some value pivot
   * @post
   *    For all i, lb <= i < mid, order.compare(values[i],pivot) <= 0
   *    For all i, mid < i < ub, order.compare(pivot, values[i]) < 0
   */

  int[] partition(int pivot, int[] vals, int lb, int ub)
  {
    int lessThan = lb;
    int greaterThan = ub - 1;
    int tmp; 
    for (int i = lb; i < ub; i++)
      {
        if (vals[i]>pivot && i <= greaterThan)
          {
            tmp = vals[i];
            vals[i] = vals[greaterThan];
            vals[greaterThan--] = tmp;
            i--; //check the swapped value. 
            ub--; //decrease the length of loop
          }//if values[i] is greater than val

        else if (vals[i]<pivot)
          {
            tmp = vals[i];
            vals[i] = vals[lessThan];
            vals[lessThan++] = tmp;
          }//else if
        else if (vals[i]==pivot)
          {
            tmp = vals[i];
            vals[i] = vals[lessThan];
            vals[lessThan] = tmp;
          }//else if
      }//for
    return new int[] { lessThan, greaterThan + 1 };
  } // partition

} // NewQuicksorter<T>