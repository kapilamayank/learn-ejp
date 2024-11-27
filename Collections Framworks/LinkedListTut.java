import java.util.*;

public class LinkedListTut {
    public static void main(String[] args) {
        LinkedList<String> ll = new LinkedList<>();

        // adding an element :
        ll.add("Element");
        ll.add("Element");

        // adding an element specifically at the first position 
        ll.addFirst("Element0");

        // adding an elements specifically at the last position 
        ll.addLast("Element1");

        // adding elements at a specific position
        ll.add(1, "Element0.5");

        LinkedList<String> ll2 = new LinkedList<>();
        ll2.add("New");
        ll2.add("List");

        // adding multiple elements
        ll2.addAll(ll2);

        // removing an element (first occ.)
        ll.remove("Element");

        // removing all elements of ll2 from ll1
        ll.removeAll(ll2);

        // remove the first element
        ll.removeFirst();

        // remove the last element
        ll.removeLast();

        System.out.println(ll);

        // linkedList reverse :
        LinkedList<String> reverse = new LinkedList<>();

        Iterator<String> it = ll.iterator();

        while (it.hasNext()) {
            String ele = it.next();
            reverse.addFirst(ele);
        }

        System.out.println(reverse);

        reverse.remove(1);  // to remove at a particular index
    }    
}
