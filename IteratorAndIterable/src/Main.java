public class Main {

    public static void main(String[] args) {

        String[] string = {"This ", "is ", "a ", "test"};

        // Object Declaration
        IterableExample<String> obj = new IterableExample<>(string);

        //For-each loop
        for (String i : obj) {
            System.out.print(i);
        }
    }
}
