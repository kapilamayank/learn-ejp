import java.util.ArrayList;
import java.util.Collections;  // class has a static method sort() which sorts the ArrayList....

public class ArrayListTut {
    public static void main(String[] args) {
        ArrayList<String> elements = new ArrayList<>();

        // adding an element : 
        elements.add("Mayank");
        elements.add("Hello");
        elements.add("Bye");

        // element at a particular index : 
        String secondElement = elements.get(1);
        
        // udpating elements at a particular index: 
        elements.set(1, "World");

        // removing an element : 
        elements.remove("Bye");

        elements.add("Actually");

        // sorting the elements
        Collections.sort(elements);

        // prints all the elements :
        for (int i = 0; i < elements.size(); i++) {
            System.out.println(elements.get(i));
        }
    }
}
