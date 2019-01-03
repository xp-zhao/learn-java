package com.xp.exercises;

import com.xp.model.Album;
import com.xp.model.Artist;
import com.xp.model.SampleData;

import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by xp-zhao on 2019/1/3.
 */
public class Question1
{
	public static void main(String[] args) {
		Stream<Integer> stream = Stream.of(1,2,3);
		System.out.println(addUp(stream));
		List<Artist> artists = SampleData.getThreeArtists();
		System.out.println(getNamesAndOrigins(artists));
		List<Album> albums = SampleData.getThreeAlbums();
		List<Album> result = getAlbumsWithAtMostThreeTracks(albums);
		result.stream().forEach(System.out::println);
		System.out.println(countBandMembersInternal(artists));
		Album album = SampleData.manyTrackAlbum;
		IntSummaryStatistics statistics = album.getTrackList().stream().mapToInt(track -> track.getLength()).summaryStatistics();
		System.out.printf("Max: %d, Min: %d, Ave: %f, Sum: %d",
			statistics.getMax(),
			statistics.getMin(),
			statistics.getAverage(),
			statistics.getSum());
	}

	/**
	 * 计算流中所有数之和
	 * @param numbers
	 * @return
	 */
	public static int addUp(Stream<Integer> numbers){
		return numbers.reduce(0 , (acc , x) -> acc + x);
	}

	/**
	 * 统计艺术家的姓名和国籍
	 * @param artists
	 * @return
	 */
	public static List<String> getNamesAndOrigins(List<Artist> artists) {
		return artists.stream()
			.flatMap(artist -> Stream.of(artist.getName(),artist.getNationality()))
			.collect(Collectors.toList());
	}

	/**
	 * 统计最多包含 3 首歌曲的专辑
	 * @param input
	 * @return
	 */
	public static List<Album> getAlbumsWithAtMostThreeTracks(List<Album> input) {
		return input.stream()
			.filter(album -> album.getTrackList().size() <= 3)
			.collect(Collectors.toList());
	}

	public static int countBandMembersInternal(List<Artist> artists){
		int totalMembers = 0;
//		for (Artist artist : artists) {
//			Stream<Artist> members = artist.getMembers();
//			totalMembers += members.count();
//		}
		totalMembers = artists.stream()
			.map(artist -> artist.getMembers().count())
			.reduce(0L,Long::sum)
			.intValue();
		return totalMembers;
	}
}
