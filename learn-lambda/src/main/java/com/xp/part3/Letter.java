package com.xp.part3;

import java.util.function.Function;

/**
 * Created by xp-zhao on 2018/12/7.
 */
public class Letter
{
	public static String addHeader(String text){
		return "From Raoul, Mario and Alan: " + text;
	}
	public static String addFooter(String text){
		return text + " Kind regards";
	}
	public static String checkSpelling(String text){
		return text.replaceAll("labda", "lambda");
	}

	public static void main(String[] args) {
		Function<String,String> addHeader = Letter::addHeader;
		Function<String, String> transformationPipeline = addHeader.andThen(Letter::checkSpelling)
			.andThen(Letter::addFooter);
	}
}
