package taojava.labs.sorting;

import java.util.Comparator;
import java.util.Random;
/**
 * 
 * @author Nicolas
 *
 * A quicksort that chooses the pivot randomly.
 */

public class RandomQuicksort<T> extends NewQuicksorter<T>
{
  Random rand = new Random();
  @Override
  public T selectPivot(T[] vals, Comparator<T> order, int lb, int ub)
  {
    int index = rand.nextInt(ub - lb) + lb;
    //System.err.println("selectPivot(" + lb + ", " + ub + ") -> " + index);
    T p1 = vals[index];
    return p1;
  }
}
