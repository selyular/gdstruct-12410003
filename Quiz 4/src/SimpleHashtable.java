public class SimpleHashtable {

    private StoredPlayer[] hashtable;

    public SimpleHashtable() {
        hashtable = new StoredPlayer[10];
    }

    private int hashKey(String key) {
        return key.length() % hashtable.length;
    }

    private boolean isOccupied(int index) {
        return hashtable[index] != null;
    }

    public void put(String key, Player value) {
        int hashedKey = hashKey(key);

        if (isOccupied(hashedKey)) {
            int stoppingIndex = hashedKey;

            if (hashedKey == hashtable.length - 1) {
                hashedKey = 0;
            } else {
                hashedKey++;
            }

            while (isOccupied(hashedKey) && hashedKey != stoppingIndex) {
                hashedKey = (hashedKey + 1) % hashtable.length;
            }
        }

        if (isOccupied(hashedKey)) {
            System.out.println("Sorry, there is already an element at position " + hashedKey);
        } else {
            hashtable[hashedKey] = new StoredPlayer(key, value);
        }
    }

    public Player get(String key) {
        int hashedKey = findKey(key);

        // If findKey returns -1, we didn't find it
        if (hashedKey == -1) {
            return null;
        }

        return hashtable[hashedKey].value;
    }

    private int findKey(String key) {
        int hashedKey = hashKey(key);

        if (hashtable[hashedKey] != null && hashtable[hashedKey].key.equals(key)) {
            return hashedKey;
        }

        int stoppingIndex = hashedKey;

        if (hashedKey == hashtable.length - 1) {
            hashedKey = 0;
        } else {
            hashedKey++;
        }

        while (hashedKey != stoppingIndex &&
                hashtable[hashedKey] != null &&
                !hashtable[hashedKey].key.equals(key)) {
            hashedKey = (hashedKey + 1) % hashtable.length;
        }

        if (hashtable[hashedKey] != null && hashtable[hashedKey].key.equals(key)) {
            return hashedKey;
        } else {
            // Did not find the key
            return -1;
        }
    }

    public void printHashtable() {
        for (int i = 0; i < hashtable.length; i++) {
            // This will call the StoredPlayer.toString() method
            System.out.println("Element " + i + ": " + hashtable[i]);
        }
    }

    public Player remove(String key) {
        int hashedKey = findKey(key);

        if (hashedKey == -1) {
            return null;
        }

        Player removedPlayer = hashtable[hashedKey].value;

        hashtable[hashedKey] = null;

        StoredPlayer[] oldHashtable = hashtable;
        hashtable = new StoredPlayer[oldHashtable.length];

        for (StoredPlayer stored : oldHashtable) {
            if (stored != null) {
                put(stored.key, stored.value);
            }
        }

        return removedPlayer;
    }
}