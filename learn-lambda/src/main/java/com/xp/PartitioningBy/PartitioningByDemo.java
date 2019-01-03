package com.xp.PartitioningBy;

import com.xp.model.Album;
import com.xp.model.Artist;
import com.xp.model.SampleData;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Stream;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.*;

/**
 * Created by xp-zhao on 2019/1/3.
 */
public class PartitioningByDemo
{
	public static void main(String[] args) {
		Stream<Artist> artists = SampleData.threeArtists();
//		Optional<Artist> result = biggestGroup(artists);
//		System.out.println(result);
//		bandsAndSolo(artists).forEach((k,v) -> System.out.println(k + "=" + v));
		System.out.println(getAllArtistName(artists));
		Stream<Album> albums = SampleData.albums;
		albumsByArtist(albums).forEach((k,v) -> System.out.println(k + "=" + v));
	}

	/**
	 * 找出成员最多的乐队
	 * @param artists
	 * @return
	 */
	public static Optional<Artist> biggestGroup(Stream<Artist> artists) {
		Function<Artist,Long> getCount = artist -> artist.getMembers().count();
		return artists.collect(maxBy(comparing(getCount)));
	}

	/**
	 * 将艺术家组成的流分成乐队和独唱歌手两部分
	 * @param artists
	 * @return
	 */
	public static Map<Boolean, List<Artist>> bandsAndSolo(Stream<Artist> artists) {
		return artists.collect(partitioningBy(artist -> artist.isSolo()));
	}

	/**
	 * 使用主唱对专辑分组
	 * @param albums
	 * @return
	 */
	public static Map<Artist,List<Album>>  albumsByArtist(Stream<Album> albums){
		return albums.collect(groupingBy(album -> album.getMainMusician()));
	}

	/**
	 * 使用流和收集器格式化艺术家姓名
	 * @param artists
	 * @return
	 */
	public static String getAllArtistName(Stream<Artist> artists){
		return artists.map(Artist::getName).collect(joining("," , "[" , "]"));
	}
}
