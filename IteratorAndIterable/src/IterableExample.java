import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class IterableExample<T> implements Iterable<T> {

    private List<T> stringList;

    public IterableExample(T[] temp) {
        stringList = Arrays.asList(temp);
    }

    @Override
    public Iterator<T> iterator() {
        return stringList.iterator();
    }
}
