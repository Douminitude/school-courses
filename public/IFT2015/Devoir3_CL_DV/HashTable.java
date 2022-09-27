// Catherine Lariviere 0955948
// Dominique Vigeant 20129080
 
// Prennez le soin de bien lire l'énoncé pdf! Assurez-vous que votre implémentation
// respecte tout ce qui est demandé!
 
// source: https://stackoverflow.com/questions/15518418/whats-behind-the-hashcode-method-for-string-in-java

@SuppressWarnings (value="unchecked")
public class HashTable<T extends Object> {

    public Node<String, T>[] hashTable;
    public int capacite;    // Taille de la table.
    public int nbrElements; // Nombre d'éléments dans la table.

    // Constructeur pour une table de hachage vide.
    public HashTable() {
        capacite = 16;
        hashTable = new Node[capacite];
        nbrElements = 0;
    }

    // Fonction de hashage principale.
    // La sortie devrait être le plus possible uniforme dans l'interval [0, Integer.MAX_VALUE].
    // Devrait être en O(key.length()).
    public static int hash(String keyToHash) {
        int h = 0;
        int keyLength = keyToHash.length();
        if (keyToHash != null) {
            for (int i = 0; i < keyLength; i++) {
                h += keyToHash.charAt(i) * Math.pow(31, keyLength - i - 1);
            }
        }
        return h & 0xfffffff;
    }

    // Insert un élément dans la table de hashage.
    // S'il y a déjà un élément d'associé à cette clé, remplace l'élément
    // par ce nouvel élément.
    // (J'ai mis un "throws Exception" dans le cas où vous voudriez lancer
    // un exception si on ne peu plus inserer parce que la taille du tableau
    // a atteint la limite permise par java, mais mon ordinateur n'a pas assez
    // de mémoire pour se rendre jusque là, alors je ne testerai pas ça.)
    // Devrait être en O(1) en moyenne, en ignorant le cout du hachage initial.
    public void insert(T elem, String keyToInsert) throws Exception {

        // On agrandit la table si elle est pleine à plus de 70%.
        if (1.0 * nbrElements / capacite >= 0.7) {
            capacite *= 2;
            resizeTable(capacite);
        }

        int hash = hash(keyToInsert);
        HashNode<T> insert = new HashNode<>(keyToInsert, elem, hash);
        int index = insert.hashCode & (capacite - 1);
        int x = index;

        // Linear probing
        while (hashTable[index] != null) {
            // Cas 1: La clé est déjà présente dans la table.
            if (keyToInsert.equals(hashTable[index].key)) {

                // On écrase la valeur associée à la clé par la nouvelle valeur.
                hashTable[index].value = insert.value;
                return;

            } 
            // Cas 2: On arrive à une tombstone.
            else if (hashTable[index] instanceof Tombstone) {

                // On remplace la tombstone par l'élément à insérer.
                hashTable[index] = insert;

                // Il faut cependant chercher si la clé était déjà présente plus loin.
                // Si c'est le cas, on la remplace par une tombstone.
                if (++index == hashTable.length) index = 0;

                while (hashTable[index] != null) {
                    if (keyToInsert.equals(hashTable[index].key)) {
                        hashTable[index] = new Tombstone<>(null, null, hashTable[index].hashCode);
                        return;
                    }
                    if (++index == hashTable.length) index = 0;
                }

                // Sinon, on incrémente le compteur d'éléments dans la table.
                nbrElements++;
                return;
            }
            index = (++x) & (capacite - 1);
            if (index == capacite) index = 0;
        }
        // Cas 3: La clé n'était pas présente, on l'ajoute à une place libre.
        hashTable[index] = insert;
        nbrElements++;
    }

    // Retourne true s'il y a une élément d'associé à la clé key, et false sinon.
    // Devrait être en O(1) en moyenne, en ignorant le cout du hachage initial.
    public boolean contains(String keyToLookFor) {
        int index = hash(keyToLookFor) & (capacite - 1);
        int x = index;
        Node<String, T> node = hashTable[index];

        if (node == null) return false;

        while (node != null || node instanceof Tombstone) {
            if (node.key != null && keyToLookFor.equals(node.key)) return true;

            index = (++x) & (capacite - 1);
            if (index == capacite) index = 0;
            
            node = hashTable[index];
        }
        return false;
    }

    // Retourne l'élément associé à la clé key.
    // retourne null s'il n'y a rien d'associé à key.
    // Devrait être en O(1) en moyenne, en ignorant le cout du hachage initial.
    public T get(String keyToGet) {
        int index = hash(keyToGet) & (capacite - 1);
        int x = index;
        Node<String, T> node = hashTable[index];

        while (node != null || node instanceof Tombstone) {
            if (node.key != null && keyToGet.equals(node.key)) return node.value;

            index = (++x) & (capacite - 1);
            if (index == capacite) index = 0;

            node = hashTable[index];
        }
        return null;
    }

    // Supprime l'élément associé à la clé key.
    // Ne fait rien s'il n'y a rien d'associé à key.
    // Devrait utiliser un effacement paresseux.
    // Devrait être en O(1) en moyenne, en ignorant le cout du hachage initial.
    public void delete(String keyToDelete) {

        // Si la table contient 30% d'éléments, on diminue sa taille
        if (1.0 * nbrElements / capacite <= 0.3) {
            if (capacite > 8) capacite /= 2;
            resizeTable(capacite);
        }

        int index = hash(keyToDelete) & (capacite - 1);
        int x = index;

        if (hashTable[index] == null) return;
        
        while (hashTable[index] != null) {
            if (keyToDelete.equals(hashTable[index].key)) {
                nbrElements--;
                hashTable[index] = new Tombstone<>(null, null, hashTable[index].hashCode);
                return;
            }
            index = (++x) & (capacite - 1);
            if (index == capacite) index = 0;
        }
    }

    // Retourne la taille du tableau utilisé (incluant les cases vides)
    // Devrait être en O(1).
    public int getTableLength() {
        return capacite;
    }

    // Retourne le nombre d'éléments présents dans la table.
    // Devrait être en O(1).
    public int getNumberOfElements() {
        return nbrElements;
    }

    public void resizeTable(int capacite) {

        Node<String, T>[] temp = this.hashTable;
        this.hashTable = new Node[capacite];

        int i = 0;
        while(i < temp.length) {
            if (temp[i] instanceof Tombstone || temp[i] == null) i++;
            else {
                // On calcule le nouveau hashage avec la nouvelle capacité.
                int index = temp[i].hashCode & (capacite - 1);
                int x = index;

                while (hashTable[index] != null) {
                    index = (++x) & (capacite - 1);
                    if (index == capacite) index = 0;
                }
                hashTable[index] = temp[i];
                i++;
            }
        }
    }
}
