package uebung10justin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.IntPredicate;
import java.util.stream.Collector;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;


public class main {

	public static void main(String[] args) {
		

		System.out.println("Get char at:");
		System.out.println(getCharStream("hallo").collect(Collector.of(StringBuilder::new, StringBuilder::append, StringBuilder::append, StringBuilder::toString)));
		int[] arr = {};
		System.out.println(getMax(arr));
	}
	
	public static IntStream powersOfTwo() 
	{
		
		return IntStream.iterate(0, i -> i+1).map(i -> (int) Math.pow(2, i)).limit(30);
	}
	
	public static void testStream(IntStream stream, int num) 
	{
		stream.limit(num).forEach(System.out::println);
	}
	
	public static int[] toArray(ArrayList<Integer> list) 
	{
		
		return list
				.stream()
				.mapToInt(Integer::intValue)
				.toArray();
		
	}
	public static double[] getRandNumbers(int cnt) 
	{
		
		return DoubleStream.generate(() -> Math.random())
						.limit(cnt)
						.toArray();
	}
	
	public static Stream<Character> getCharStream(String s)
	{
		
		return IntStream.range(0, s.length())
						.mapToObj(i -> s.charAt(i));
	}
	
	public static int getMax(int[] arr) 
	{
		return Arrays
				.stream(arr)
				.parallel()
				.max()
				.getAsInt();
	}
	
	public static int[] getPos(String x, char c) 
	{
		return IntStream
				.range(0, x.length())
				.parallel().filter(i -> x.charAt(i) == c)
				.toArray();
	}
	
	public static boolean isPrime(long z) 
	{
		return IntStream.rangeClosed(2, (int) (z/2)).noneMatch(i -> (int) (z%i) == 0);
	}
	
	public static IntStream getFactors(int n) 
	{	// rangeClosed or range(1, n+1) bcs its exclusive
		return IntStream.rangeClosed(1, n).filter(i -> (n%i == 0));
	}

}
