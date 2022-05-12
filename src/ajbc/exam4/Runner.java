package ajbc.exam4;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Runner {

	public static void main(String[] args) {
		Tent tent1 = new Tent(2, 3, 3, 1.5);
		Tent tent2 = new Tent(3, 4, 4, 1);
		Tent tent3 = new Tent(4, 5, 3, 1.5);
		Tent tent4 = new Tent(4, 5, 7, 2);
		Tent tent5 = new Tent(2, 3, 3, 2);
		Tent tent6 = new Tent(5, 3.5, 6, 2.5);
		Tent tent7 = new Tent(6, 7, 4, 2.5);
		Tent tent8 = new Tent(10, 11, 3, 2);
		Tent tent9 = new Tent(3, 4, 3, 1.5);
		Tent tent10 = new Tent(5, 3.5, 5, 1);

		ArrayList<Tent> tents = new ArrayList<Tent>(10);
		tents.add(tent1);
		tents.add(tent2);
		tents.add(tent3);
		tents.add(tent4);
		tents.add(tent5);
		tents.add(tent6);
		tents.add(tent7);
		tents.add(tent8);
		tents.add(tent9);
		tents.add(tent10);

		System.out.println("-----Q1-----");
		List<Tent> tentsSortedByArea = sortTentsByAreas(tents);
		tentsSortedByArea.forEach(System.out::println);

		System.out.println("-----Q2-----");
		int num = 5;
		List<Tent> tentsWithNumOfPeople = getTentsWithNumOfPeople(tents, num);
		tentsWithNumOfPeople.forEach(System.out::println);

		System.out.println("-----Q3-----");
		Tent tent = new Tent(1, 2, 4, 2.5);
		boolean isMax = checkIfHighestTent(tents, tent);
		System.out.println("The tent is the Highest? " + isMax);

		System.out.println("-----Q4-----");
		Map<Double, List<Tent>> mapTentsByHeights = mapByHeights(tents);
		mapTentsByHeights.forEach((key, value) -> System.out.println(key + ":" + value));

		System.out.println("-----Q5-----");
		double maxHeight = 2, minHeight = 1;
		List<Tent> tentsInRangeOfHeights = getTentsInRangeOfHeights(mapTentsByHeights, maxHeight, minHeight);
		tentsInRangeOfHeights.forEach(System.out::println);
	}

	private static List<Tent> getTentsInRangeOfHeights(Map<Double, List<Tent>> mapTentsByHeights, double maxHeight,
			double minHeight) {

		List<List<Tent>> tentsInRangeOfHeight = mapTentsByHeights.entrySet().stream()
				.filter(entry -> entry.getKey() >= minHeight && entry.getKey() <= maxHeight)
				.map(entry -> entry.getValue()).collect(Collectors.toList());

		return tentsInRangeOfHeight.stream().flatMap(List::stream).collect(Collectors.toList());
	}

	private static Map<Double, List<Tent>> mapByHeights(ArrayList<Tent> tents) {
		return tents.stream().collect(Collectors.groupingBy(tent -> tent.getHeight()));
	}

	private static boolean checkIfHighestTent(ArrayList<Tent> tents, Tent tent) {
		List<Tent> tentsSortedByHeight = tents.stream().sorted(Comparator.comparing(Tent::getHeight))
				.collect(Collectors.toList());
		// tentsSortedByHeight.forEach(System.out::println);

		return tentsSortedByHeight.get(tents.size() - 1).getHeight() == tent.getHeight();
	}

	private static List<Tent> getTentsWithNumOfPeople(ArrayList<Tent> tents, int num) {
		return tents.stream().filter(tent -> tent.getNumOfPeople() >= num).collect(Collectors.toList());
	}

	private static List<Tent> sortTentsByAreas(ArrayList<Tent> tents) {		
		return tents.stream().sorted(Comparator.comparing(tent -> tent.getLength() * tent.getWidth())).collect(Collectors.toList());
	}

}
