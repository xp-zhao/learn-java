package com.xp.part5_stream.example;

import java.util.*;

import static java.util.stream.Collectors.groupingBy;

/**
 * Created by xp-zhao on 2018/12/7.
 */
public class Answer
{
	public static void main(String[] args) {
		Trader raoul = new Trader("Raoul", "Cambridge");
		Trader mario = new Trader("Mario","Milan");
		Trader alan = new Trader("Alan","Cambridge");
		Trader brian = new Trader("Brian","Cambridge");
		List<Transaction> transactions = Arrays.asList(
			new Transaction(brian, 2011, 300),
			new Transaction(raoul, 2012, 1000),
			new Transaction(raoul, 2011, 400),
			new Transaction(mario, 2012, 710),
			new Transaction(mario, 2012, 700),
			new Transaction(alan, 2012, 950)
		);
		// 找出2011年发生的所有交易，并按交易额排序（从低到高）.
		transactions.stream()
			.filter(t -> t.getYear() == 2011)
			.sorted(Comparator.comparing(Transaction::getValue))
			.forEach(System.out::println);
		// 交易员都在哪些不同的城市工作过?
		transactions.stream()
			.map(transaction -> transaction.getTrader().getCity())
			.distinct()
			.forEach(System.out::println);
		// 查找所有来自于剑桥的交易员，并按姓名排序。
		transactions.stream()
			.map(transaction -> transaction.getTrader())
			.filter(trader -> trader.getCity().equals("Cambridge"))
			.distinct()
			.sorted(Comparator.comparing(Trader::getName))
			.forEach(System.out::println);
		// 返回所有交易员的姓名字符串，按字母顺序排序。
		String str = transactions.stream()
			.map(transaction -> transaction.getTrader().getName())
			.distinct()
			.sorted()
			.reduce("",(n1,n2) -> n1 + n2);
		System.out.println(str);
		// 有没有交易员是在米兰工作的？
		boolean flag = transactions.stream()
			.anyMatch(transaction -> transaction.getTrader().getCity().equals("Milan"));
		System.out.println(flag);
		// 打印生活在剑桥的交易员的所有交易额。
		transactions.stream()
			.filter(transaction -> transaction.getTrader().getCity().equals("Cambridge"))
			.map(Transaction::getValue)
			.forEach(System.out::println);
		//所有交易中，最高的交易额是多少？
		Optional<Integer> highestValue = transactions.stream()
			.map(Transaction::getValue)
			.reduce(Integer::max);
		System.out.println(highestValue);
		//找到交易额最小的交易
		Optional<Transaction> smallestTransaction = transactions.stream()
			.min(Comparator.comparing(Transaction::getValue));
		System.out.println(smallestTransaction);
		// 交易总额
		int sum = transactions.stream().map(Transaction::getValue).reduce(0 , Integer::sum);
		System.out.println(sum);
		int sum1 = transactions.stream().mapToInt(Transaction::getValue).sum();
		System.out.println(sum1);
		// 按照交易时间分组
		Map<Integer, List<Transaction>> map = transactions.stream().collect((groupingBy(Transaction::getYear)));
	}
}
