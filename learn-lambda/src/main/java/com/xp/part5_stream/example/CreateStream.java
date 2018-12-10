package com.xp.part5_stream.example;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.Stream;

/**
 * Created by xp-zhao on 2018/12/10.
 */
public class CreateStream
{
	public static void main(String[] args) {

		// 由值创建流
		Stream<String> stream = Stream.of("Java 8 ", "Lambdas ", "In ", "Action");
		stream.map(String::toUpperCase).forEach(System.out::println);
		// 空流
		Stream<String> emptyStream = Stream.empty();
		// 由数组创建流
		int[] nums = {2 , 3 , 4 , 5 , 6 , 7 , 8};
		int sum = Arrays.stream(nums).sum();
		System.out.println(sum);
		// 由文件生成流
		long uniqueWords = 0;
		try(Stream<String> lines = Files.lines(Paths.get("D:\\Users\\github\\learn-java\\learn-lambda\\src\\main\\java\\com\\xp\\part5_stream\\example\\data.txt"), Charset.defaultCharset())){
			uniqueWords = lines.flatMap(line -> Arrays.stream(line.split(" ")))
					.distinct()
					.count();
		}catch (IOException e){
			e.printStackTrace();
		}
		System.out.println(uniqueWords);
		// 由函数生成流
		Stream.iterate(0,n -> n + 2)
			.limit(10)
			.forEach(System.out::println);
		// 斐波那契元组序列
		Stream.iterate(new int[]{0,1}, t -> new int[]{t[1],t[0] + t[1]})
			.limit(20)
			.forEach(t -> System.out.println("("+t[0] + ","+t[1]+")"));
		// 斐波那契数列
		Stream.iterate(new int[]{0,1}, t -> new int[]{t[1],t[0] + t[1]})
			.limit(10)
			.map(t -> t[0])
			.forEach(System.out::println);
	}
}
