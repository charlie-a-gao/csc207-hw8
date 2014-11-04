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
  @Override
  public T selectPivot(T[] vals, Comparator<T> order, int lb, int ub)
  {
    Random rand = new Random();
    T p1 = vals[rand.nextInt((ub - lb)  + lb)];
    return p1;
  }
}
