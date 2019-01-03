package com.xp.model;

import java.util.stream.Stream;

import static java.util.stream.Stream.concat;

/**
 * Created by xp-zhao on 2019/1/3.
 */
public interface Performance
{
	public String getName();

	public Stream<Artist> getMusicians();

	// TODO: test
	public default Stream<Artist> getAllMusicians() {
		return getMusicians().flatMap(artist -> {
			return concat(Stream.of(artist), artist.getMembers());
		});
	}
}
