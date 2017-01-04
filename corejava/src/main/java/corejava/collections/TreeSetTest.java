package corejava.collections;

/**
 * @version 1.12 2012-01-26
 * @author Cay Horstmann
 */

import java.util.Comparator;
import java.util.Objects;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * This program sorts a set of item by comparing
 * their descriptions.
 */
public class TreeSetTest {
    public static void main(String[] args) {
        SortedSet<Item> parts = new TreeSet<>();
        parts.add(new Item("Toaster", 1234));
        parts.add(new Item("Widget", 4562));
        parts.add(new Item("Modem", 9912));
        System.out.println(parts);

        SortedSet<Item> sortByDescription = new TreeSet<>((Comparator<Item>) (a, b) -> {
            String descrA = a.getDescription();
            String descrB = b.getDescription();
            return descrA.compareTo(descrB);
        });

        sortByDescription.addAll(parts);
        System.out.println(sortByDescription);
    }

    /**
     * An item with a description and a part number.
     */
    public static class Item implements Comparable<Item> {
        private String description;
        private int partNumber;

        /**
         * Constructs an item.
         *
         * @param aDescription the item's description
         * @param aPartNumber  the item's part number
         */
        public Item(String aDescription, int aPartNumber) {
            description = aDescription;
            partNumber = aPartNumber;
        }

        /**
         * Gets the description of this item.
         *
         * @return the description
         */
        public String getDescription() {
            return description;
        }

        public String toString() {

            return "[descripion=" + description + ", partNumber=" + partNumber + "]";
        }

        public boolean equals(Object otherObject) {
            if (this == otherObject)
                return true;
            if (otherObject == null)
                return false;
            if (getClass() != otherObject.getClass())
                return false;
            Item other = (Item) otherObject;
            return Objects.equals(description, other.description) && partNumber == other.partNumber;
        }

        public int hashCode() {
            return Objects.hash(description, partNumber);
        }

        public int compareTo(Item other) {
            return Integer.compare(partNumber, other.partNumber);
        }
    }
}