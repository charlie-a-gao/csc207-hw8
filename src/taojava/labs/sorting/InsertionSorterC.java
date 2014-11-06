package taojava.labs.sorting;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Sort using insertion sort.
 * 
 * @author Samuel A. Rebelsky
 */
public class InsertionSorterC<T>
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
   * Swaps until in right position.
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
    int i = n;
    while ((i > 0) && (order.compare(vals[i - 1], vals[i]) > 0))
      {
        Utils.swap(vals, i, i - 1);
        i--;
      } // while
  }//insertC

} // InsertionSorter<T>
