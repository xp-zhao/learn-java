package com.xp.part5_stream.example;

import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Created by xp-zhao on 2018/12/10.
 */
public class MathExample
{
	public static void main(String[] args) {
	    // 勾股数
	    Stream<int[]> pythagoreanTriples = IntStream.rangeClosed(1,100).boxed()
		    .flatMap(a ->
		    	IntStream.rangeClosed(a,100)
		    		.filter(b -> Math.sqrt( a * a + b * b) % 1 == 0)
		    		.mapToObj(b ->
					new int[] {a,b,(int)Math.sqrt( a * a + b * b)}));
	    pythagoreanTriples.limit(5).forEach( t -> System.out.println(t[0]+","+t[1]+","+t[2]));
	}
}
