import java.util.*;

public class Main {
    public static void main(String[] args) {
        task1();
        task2();
    }

    private static void task1() {
        CountMap<Integer> map = new CountMapImpl<>();

        map.add(10);
        map.add(10);
        map.add(5);
        map.add(6);
        map.add(5);
        map.add(10);

        System.out.println(map.getCount(5)); // 2
        System.out.println(map.getCount(6)); // 1
        System.out.println(map.getCount(10)); // 3

        printMap(map);
        System.out.println("size: " + map.size());

        System.out.println("removed " + map.remove(10));
        printMap(map);

        System.out.println("size: " + map.size());

        CountMap<Integer> map2 = new CountMapImpl<>();
        map2.add(12345);
        map2.add(12345);
        map2.add(5);
        map.addAll(map2);
        printMap(map);

        CountMap<Integer> map3 = new CountMapImpl<>();
        map.toMap(map3.toMap());
        System.out.println("map3");
        printMap(map3);
    }

    private static void printMap(CountMap<Integer> map) {
        System.out.println("Map:       ==============");
        for (Map.Entry<Integer, Integer> entry : map.toMap().entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
        System.out.println("=========================");
    }

    private static void task2() {
        List<Integer> list = CollectionUtils.newArrayList();
        CollectionUtils.add(list, 5);
        System.out.println(list);

        List<Integer> list2 = new ArrayList<>(Arrays.asList(2, 3));
        CollectionUtils.addAll(list2, list);
        System.out.println(list);

        System.out.println("index of 2: " + CollectionUtils.indexOf(list, 2));
        System.out.println("limited to 2: " + CollectionUtils.limit(list, 2));

        CollectionUtils.removeAll(list, list2);
        System.out.println("removeAll: " + list);

        CollectionUtils.addAll(list2, list);
        System.out.println(list);
        System.out.println("containsAll");
        System.out.println(CollectionUtils.containsAll(list, list2));
        System.out.println(CollectionUtils.containsAll(list, List.of(2, 7)));

        System.out.println("containsAny");
        System.out.println(CollectionUtils.containsAny(list, List.of(2, 7)));
        System.out.println(CollectionUtils.containsAny(list, List.of(7)));

        List<Integer> range1 = CollectionUtils.range(list, 2, 5);
        System.out.println(range1);

        List<Integer> range2 = CollectionUtils.range(list, 2, 5, new LocalComparator<Integer>());
        System.out.println(range2);

    }

    static class LocalComparator<T extends Comparable<T>> implements Comparator<T> {
        public int compare(T a, T b) {
            return a.compareTo(b);
        }
    }
}