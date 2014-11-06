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
  } // decreasingIArrayBuilder

  public static int[] randomIntArrBuilder(int length)
  {
    int[] vals = new int[length];
    Random random = new Random();
    for (int i = 0; i < length; i++)
      vals[i] = random.nextInt(length);
    return vals;
  } // decreasingIArrayBuilder

  /**
   * Test a generic Quicksorter against a primitive Quicksorter with a decreasing array
   * Note both choose their pivot as (ub+lb)/2
   * @param length
   * @param PrintWriter
   */
  public static void randomTest(int length, PrintWriter p)
  {
    //declare things
    SimpleTimer time = new SimpleTimer();
    PrimitiveQuicksort primQuick = new PrimitiveQuicksort();
    NewQuicksorter<Integer> genericQuick = new NewQuicksorter<Integer>();
    ArrayBuilder<Integer> b1 = SorterAnalyzer.randomIntArrBuilder;
    //build the arrays
    int[] random = randomIntArrBuilder(length);
    Integer[] random2 = b1.build(length);
    long elapsedGen; //time for generic sorter
    long elapsedPrim; //time for primitive sorter
    time.start();
    genericQuick.sort(random2, StandardIntegerComparator.COMPARATOR);
    elapsedGen = time.elapsed();
    time.reset();
    time.start();
    primQuick.sorti(random);
    elapsedPrim = time.elapsed();
    time.reset();
    p.println(length + "     " + elapsedGen + "        " + elapsedPrim
              + "          " + (elapsedGen - elapsedPrim));
  }//random test

  public static void reverseTest(int length, PrintWriter p)
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
  }//decreasing test

  /**
   * this test shows us that the primitive version is much more efficient. 
   * Almost all the time that our generic sorters take are from dealing with generics
   */
  public static void main(String args[])
  {
    PrintWriter p = new PrintWriter(System.out,true);
    p.println("Decreasing order test");
    p.println("Length Generic  Primitive  Difference");
    p.println("--------------------------------------");
    for (int i = 1000; i < 10000; i += 1000)
        reverseTest(i, p);
    p.println("--------------------------------------");
    p.println("Random order test");
    for (int i = 50000; i < 60000; i += 1000)
      randomTest(i,p);
    
  }//main
}
