// Catherine Lariviere 0955948
// Dominique Vigeant 20129080
 
public class Tombstone<T> extends Node<String, T> {

    public Tombstone(String key, T value, int hashCode) {
        super(key, value, hashCode);
    }
}
