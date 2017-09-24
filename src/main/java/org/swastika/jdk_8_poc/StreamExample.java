package org.swastika.jdk_8_poc;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamExample {

	static List<String> nameList = Arrays.asList("John", "Bon", "James", "Test");

	public static void main(String[] args) {

		// System.out.println(nameList.stream().filter(s ->
		// s.contains("J")).collect(Collectors.toList()));
		addUp(Stream.of(1, 2, 3, 4));
		System.out.println(getArtistDetails(Stream.of(new Artist("A", "AP", true), new Artist("b", "BA", true))));
		System.out.println(getArtistMemberCount(Stream.of(new Artist("A", "AP", true, Arrays.asList("A", "AA", "AAA")),
				new Artist("b", "BA", true, Arrays.asList("B")))));
		System.out.println(countTheLowerCase("Swastika Basu"));
		System.out.println(getStringWithMaxLowerCase(Stream.of("SwaSTika","Swastika","Swas")));
		
	}

	public static void addUp(Stream<Integer> intStream) {
		System.out.println(intStream.reduce(0, (i1, i2) -> i1 + i2));

	}

	public static List<String> getArtistDetails(Stream<Artist> artistList) {
		return artistList.map(a -> "name is " + a.getName() + " lives at " + a.getPlace()).collect(Collectors.toList());
	}

	public static List<Integer> getArtistMemberCount(Stream<Artist> artistList) {
		// AtomicInteger count = new AtomicInteger();
		return artistList.map(s -> s.getMembers().size()).collect(Collectors.toList());
	}

	public static long countTheLowerCase(String s) {
		return s.chars().filter(c -> Character.isLowerCase(c)).count();
	}

	public static String getStringWithMaxLowerCase(Stream<String> names) {
		return names.max((s1, s2) -> Long.compare(countTheLowerCase(s1), countTheLowerCase(s2))).get();
		// return "";
	}
}

class Artist {

	private String name;
	private String place;
	private boolean isFamous;
	private List<String> members;

	public Artist(String name, String place, boolean isFamous) {
		this.name = name;
		this.place = place;
		this.isFamous = isFamous;
	}

	public Artist(String name, String place, boolean isFamous, List<String> members) {
		this.name = name;
		this.place = place;
		this.isFamous = isFamous;
		this.members = members;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public boolean isFamous() {
		return isFamous;
	}

	public void setFamous(boolean isFamous) {
		this.isFamous = isFamous;
	}

	public List<String> getMembers() {
		return members;
	}

	public void setMembers(List<String> members) {
		this.members = members;
	}

}