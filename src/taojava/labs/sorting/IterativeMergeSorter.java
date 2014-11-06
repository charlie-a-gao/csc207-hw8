package taojava.labs.sorting;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Sort using iterative merge sort.
 * 
 * @author Samuel A. Rebelsky
 * @author Charlie Gao
 */
public class IterativeMergeSorter<T>
    extends SorterBridge<T>
{
  /**
   * Sort vals using iterative merge sort. See the Sorter<T> interface for
   * additional details.
   */
  @Override
  public T[] sorti(T[] vals, Comparator<T> order)
  {
    int size = 1;
    while (size < vals.length)
      {

        int pointer = 0;
        while (pointer < vals.length)
          {
            if (pointer + size * 2 > vals.length)
              {
                if (pointer + size < vals.length)
                  {
                    T[] output =
                        Utils.merge(order, Arrays.copyOfRange(vals, pointer,
                                                              pointer + size),
                                    Arrays.copyOfRange(vals, pointer + size,
                                                       vals.length));
                    for (int i = pointer; i < vals.length; i++)
                      {
                        vals[i] = output[i - pointer];
                      }
                  }
              }
            else
              {
                T[] output =
                    Utils.merge(order, Arrays.copyOfRange(vals, pointer,
                                                          pointer + size),
                                Arrays.copyOfRange(vals, pointer + size,
                                                   pointer + size * 2));
                for (int i = 0; i < size * 2; i++)
                  {
                    vals[pointer + i] = output[i];
                  }
              }
            pointer += size * 2;
          }

        size *= 2;
      } // while
    return vals;
  } // sorti(T[], Comparator<T>)
} // IterativeMergeSorter<T>
