import java.util.HashMap;
import java.util.Map;

public class CountMapImpl<T> implements CountMap<T> {

    private Map<T, Integer> container = new HashMap<>();

    @Override
    public void add(T t) {
        Integer value = container.get(t);
        if (value == null) {
            container.put(t, 1);
        } else {
            container.put(t, ++value);
        }
    }

    @Override
    public int getCount(T t) {
        return container.get(t) == null ? 0 : container.get(t);
    }

    @Override
    public int remove(T t) {
        Integer value = container.get(t);
        if (value != null) {
            container.remove(t);
            return value;
        }
        return 0;
    }

    @Override
    public int size() {
        return container.size();
    }

    @Override
    public void addAll(CountMap<? extends T> source) {
        for (Map.Entry entry: source.toMap().entrySet()) {
            Integer value = container.get((T) entry.getKey());
            if (value == null) {
                container.put((T) entry.getKey(), (Integer) entry.getValue());
            } else {
                container.put((T) entry.getKey(), (Integer) entry.getValue() + value);
            }
        }
    }

    @Override
    public Map<T, Integer> toMap() {
        return container;
    }

    @Override
    public void toMap(Map<T, Integer> destination) {
        destination.putAll(container);
    }


}
