import java.util.*;

public class SpliteratorExamples {
    public static void main(String[] args) {
//        Spliterator estimateSize and getExactSizeIfKnown method
        System.out.println("estimateSize and getExactSizeIfKnown");
        ArrayList<String> list = new ArrayList<>();

        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");

        Spliterator<String> spliteratorExamples = list.spliterator();

        System.out.println(spliteratorExamples.estimateSize());
        System.out.println(spliteratorExamples.getExactSizeIfKnown());

//        Spliterator getComparator() example
        System.out.println("\ngetComparator");
        SortedSet<String> set = new TreeSet<>(Collections.reverseOrder());

        set.add("A");
        set.add("D");
        set.add("C");
        set.add("B");

        System.out.println(set);

        System.out.println(set.spliterator().getComparator());


//        Spliterator trySplit() method
        System.out.println("\ntrySplit()");
        ArrayList<String> list1 = new ArrayList<>();

        list1.add("A");
        list1.add("B");
        list1.add("C");
        list1.add("D");
        list1.add("E");
        list1.add("F");

        Spliterator<String> spliterator1 = list1.spliterator();
        Spliterator<String> spliterator2 = spliterator1.trySplit();

        spliterator1.forEachRemaining(System.out::println);

        System.out.println("========");

        spliterator2.forEachRemaining(System.out::println);

//       Spliterator forEachRemaining() example (Perform hasNext() and next() operation in a single statement

        System.out.println("\nforEachRemaining");
        Spliterator<String> spliterator = list.spliterator();

        spliterator.forEachRemaining(System.out::println);
    }
}
