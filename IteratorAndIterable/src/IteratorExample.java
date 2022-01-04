import java.util.*;

public class IteratorExample {
    public static void main(String[] args) {

        List<String> myList = new ArrayList<>();

        myList.add("This ");
        myList.add("Is ");
        myList.add("A ");
        myList.add("Test. ");

        Iterator<String> it = myList.iterator();

        while (it.hasNext()) {
            System.out.println(it.next());
        }

        ListIterator<String> listIt = myList.listIterator();

        while (listIt.hasNext()) {
            System.out.println(listIt.nextIndex() + " " + myList.get(listIt.nextIndex()));
            listIt.next();
        }

    }
}
