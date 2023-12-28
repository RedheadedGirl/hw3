import java.util.*;
import java.util.stream.Collectors;

public class CollectionUtils {

    public static<T> void addAll(List<? extends T> source, List<? super T> destination) {
        destination.addAll(source);
    }

    public static<T> List<T> newArrayList() {
        return new ArrayList<>();
    }

    public static<T> int indexOf(List<T> source, T t) {
        return source.indexOf(t);
    }

    public static<T> List<T> limit(List<T> source, int size) {
        return source.stream().limit(size).collect(Collectors.toList());
    }

    public static<T> void add(List<? super T> source, T t) {
        source.add(t);
    }

    public static<T> void removeAll(List<T> removeFrom, List<T> c2) {
        removeFrom.removeAll(c2);
    }

    public static<T> boolean containsAll(List<T> c1, List<T> c2) {
        return new HashSet<>(c1).containsAll(c2);
    }

    public static<T> boolean containsAny(List<T> c1, List<T> c2) {
        return c1.stream().anyMatch(c2::contains);
    }

    public static<T> List<T> range(List<T> list, T min, T max) {
        list.sort(new MyComparator());
        if (!containsAll(list, List.of(min, max))) {
            throw new ElementNotFoundException();
        }
        int minIndex = list.indexOf(min);
        int maxIndex = list.lastIndexOf(max);
        return list.subList(minIndex, maxIndex);
    }

    public static<T> List<T> range(List<T> list, T min, T max, Comparator<T> comparator) {
        list.sort(comparator);
        if (!containsAll(list, List.of(min, max))) {
            throw new ElementNotFoundException();
        }
        int minIndex = list.indexOf(min);
        int maxIndex = list.lastIndexOf(max);
        return list.subList(minIndex, maxIndex);
    }

    static class MyComparator<T extends Comparable<T>> implements Comparator<T> {
        public int compare(T a, T b) {
            return a.compareTo(b);
        }
    }
}