package taojava.labs.sorting;

import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Random;

public class PrimitiveSortTest
{
  /**
   * Build arrays of random integer values.
   */
  public static int[] decreasingIntArrBuilder(int length)
  {
    int[] vals = new int[length];
    for (int i = 0; i < length; i++)
      vals[i] = length - i;

    return vals;
  } // randomIArrayBuilder

  /**
   * Test a generic Quicksorter against a primitive Quicksorter with a decreasing array
   * Note both choose their pivot as (ub+lb)/2
   * @param length
   * @param PrintWriter
   */
  public static void test(int length, PrintWriter p)
  {
    //declare things
    SimpleTimer time = new SimpleTimer();
    PrimitiveQuicksort primQuick = new PrimitiveQuicksort();
    NewQuicksorter<Integer> genericQuick = new NewQuicksorter<Integer>();
    ArrayBuilder<Integer> b1 = SorterAnalyzer.reverseOrderBuilder;
    //build the arrays
    int[] decreasing = decreasingIntArrBuilder(length);
    Integer[] decreasing2 = b1.build(length);
    long elapsedGen; //time for generic sorter
    long elapsedPrim; //time for primitive sorter
    p.println("Length Generic  Primitive  Difference");
    p.println("--------------------------------------");
    time.start();
    genericQuick.sort(decreasing2, StandardIntegerComparator.COMPARATOR);
    elapsedGen = time.elapsed();
    time.reset();
    time.start();
    primQuick.sorti(decreasing);
    elapsedPrim = time.elapsed();
    time.reset();
    p.println(length + "     " + elapsedGen + "        " + elapsedPrim
              + "          " + (elapsedGen - elapsedPrim));

  }//test
/**
 * this test shows us that the primitive version is much more efficient. 
 * Almost all the time that our generic sorters take are from dealing with generics
 */
  public static void main(String args[])
  {
    for (int i = 1000; i < 10000; i +=500)
      {
        test(i, new PrintWriter(System.out, true));
      }//for
  }//main
}
