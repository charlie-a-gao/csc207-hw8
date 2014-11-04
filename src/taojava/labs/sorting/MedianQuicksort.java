package taojava.labs.sorting;

import java.util.Comparator;
import java.util.Random;

/**
 * 
 * @author Nicolas Knoebber
 *
 * Chooses the median of 3 randomly selected points as the pivot.
 * 
 * used http://stackoverflow.com/questions/363681/generating-random-integers-in-a-range-with-java
 * for finding random int in range
 * 
 * used http://stackoverflow.com/questions/1582356/fastest-way-of-finding-the-middle-value-of-a-triple
 * for finding the fastest way to get median of 3 points. 
 */
public class MedianQuicksort<T>
    extends NewQuicksorter<T>
{
  @Override
  public T selectPivot(T[] vals, Comparator<T> order, int lb, int ub)
  {
    Random rand = new Random();
    
    T p1 = vals[rand.nextInt((ub - lb)  + lb)];
    T p2 = vals[rand.nextInt((ub - lb)  + lb)];
    T p3 = vals[rand.nextInt((ub - lb) + lb)];
    
    if(order.compare(p1, p2)>0)
      {
        if(order.compare(p2,p3)>0)
          return p2;
        
        else if (order.compare(p1,p3)>0)
          return p3;
        
        else
          return p1;
      }
    else
      {
        if(order.compare(p1,p3)>0)
          return p1;
        
        else if(order.compare(p2,p3)>0)
          return p3;
        
        else
          return p2;
      }
  } // selectPivot(T[], vals, Comparator<T> order, int lb, int ub)

}//NewestQuicksorter
