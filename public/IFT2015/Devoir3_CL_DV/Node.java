// Catherine Lariviere 0955948
// Dominique Vigeant 20129080
 
public class Node<S, T> {
    String key;
    T value;
    int hashCode;

    public Node(String key, T value, int hashCode) {
        this.key      = key;
        this.value    = value;
        this.hashCode = hashCode;
    }
}
