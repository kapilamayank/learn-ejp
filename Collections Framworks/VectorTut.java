import java.util.Vector;

public class VectorTut {
    public static void main(String[] args) {
        Vector vect = new Vector();  // creates a default vector which can hold different data types, like list in python

        Vector<String> vect2 = new Vector<> (5, 5); 
        // capacityIncrement --> when vector runs out of space, this much new space is allocated

        // .add(), .get(), .set(), .remove(index), .remove(element)
    }
}
