import java.time.Duration;
import java.time.Instant;
import java.util.*;

public class BenchmarkZone {

    public static List<Integer> generator(int numberOfElements) {
        List<Integer> generatedList = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < numberOfElements; i++)
            generatedList.add(random.nextInt());

        return generatedList;
    }

    public static void main(String[] args) {

        List<Integer> myList = generator(60_000_000);
        int index1 = 0;
        int index2 = 0;
        int index3 = 0;
        int index4 = 0;
        int index5 = 0;

// For Each
        Instant start1 = Instant.now();
        for (Integer i : myList) {
            index1++;
        }
        Instant end1 = Instant.now();
        System.out.println("For Each   -> " + Duration.between(start1, end1));

// For Loop
        Instant start2 = Instant.now();
        for (int i = 0; i < myList.size(); i++) {
            index2++;
        }
        Instant end2 = Instant.now();
        System.out.println("For Loop   -> " + Duration.between(start2, end2));

// Iterator
        Instant start3 = Instant.now();
        Iterator<Integer> it = myList.iterator();
        while (it.hasNext()) {
            index3++;
            it.next();
        }
        Instant end3 = Instant.now();
        System.out.println("Iterator   -> " + Duration.between(start3, end3));

// List Iterator
        Instant start4 = Instant.now();
        ListIterator<Integer> listIt = myList.listIterator();
        while (listIt.hasNext()) {
            index4++;
            listIt.next();
        }
        Instant end4 = Instant.now();
        System.out.println("List It    -> " + Duration.between(start4, end4));

// Simple while loop
        Instant start5 = Instant.now();
        while (index5<myList.size()) {
            index5++;
        }
        Instant end5 = Instant.now();
        System.out.println("While Loop -> " + Duration.between(start5, end5));
    }

}
