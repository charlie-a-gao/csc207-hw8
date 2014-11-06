package taojava.labs.sorting;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Sort using insertion sort.
 * 
 * @author Samuel A. Rebelsky
 */
public class InsertionSorterB<T>
    extends SorterBridge<T>
{
  /**
   * Sort vals using insertion sort. See the Sorter<T> interface for additional
   * details.
   */
  @Override
  public T[] sorti(T[] vals, Comparator<T> order)
  {
    for (int i = 1; i < vals.length; i++)
      {
        insert(vals, order, i);
      } // for
    return vals;
  } // sorti(T[], Comparator<T>)

  /**
   * Insert the value in position i into the sorted subarray in positions
   * 0..(n-1).
   * Insert method: shift 
   * @param values
   *   the array into which we are inserting values.
   * @param order
   *   the comparator used to determine order.
   * @param n
   *   the bound on the end of the subarray.
   * 
   * @pre 0 <= n < values.length
   * @pre Utils.sorted(values, order, 0, n).
   * @pre order can be compared to any pair of values in values.
   * @post Utils.sorted(values, order, 0, n-1)
   * @post No elements have been added or removed.
   */
  void insert(T[] vals, Comparator<T> order, int n)
  {
    // Invariants:
    //   I1(i): Utils.sorted(values,0,i).
    //   I2(i): Utils.sorted(values,i+1,n).
    //   I3(i): For all l and r, 0 <= l <= i, i < r <= n,
    //           order.compare(vals[l],vals[r]) <= 0
    // Analysis:
    //   I1(n) holds at the because it's a precondition.
    //   I2(n) holds at the beginning because that subarray is empty
    //   I3(n) holds at the beginning because the second subarray is empty
    //   Note during this, it is not longer a permutation until it is done. 
    T temp = vals[n];
    int i = n;
    while ((i > 0) && order.compare(vals[i - 1], temp) > 0)
      {
        vals[i] = vals[i - 1]; //set the current to the previous value. 
        i--;
      } // while

    vals[i] = temp;

    // We move down the list until we find the position that should be replaced,
    // while moving everything else over.
    //I1 will still hold, because all we have done is shift over
    // i is positive, in which case we know that the left part is
    // sorted (I1), the right part is sorted (I2), and the element at
    // the boundary is in the right position.
  } // insert(T[], Comparator<T>, int)

} // InsertionSorter<T>
