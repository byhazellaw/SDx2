import java.text.Collator;
import java.util.Iterator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.TreeSet;

/*
 * SD2x Homework #1
 * Implement the methods below according to the specification in the assignment description.
 * Please be sure not to change the signature of any of the methods!
 */

public class LinkedListUtils {

	public static void insertSorted(LinkedList<Integer> list, int value) {

		if (list != null) {
			if (list.isEmpty()) {
				list.add(value);

			} else {
				for (int i = 0; i < list.size(); i++) {
					if (list.get(i) >= value) {
						list.add(i, value);
						break;
					}
					// if i is the last element
					if (i == list.size() - 1) {
						list.addLast(value);
						break;
					}
				}

			}
		}

	}

	public static void removeMaximumValues(LinkedList<String> list, int N) {

		if (list != null && N > 0) {
			if (N >= list.size()) {
				list.removeAll(list);
				return;

			} else {
				
				//need to use "compareTo" to find largest value
				//alternatively .sort or max is simpler and faster
				int removed = 0;
				while (removed < N) {
					String max = list.get(0);
					for (int k = 0; k < list.size() - 1; k++) {
						if (list.get(k).compareTo(list.get(k + 1)) > 0) {
							max = list.get(k);
						}
					}
					while (list.contains(max)) {
						list.remove(max);
					}
					removed++;
				}
			}
		}
	}

	public static boolean containsSubsequence(LinkedList<Integer> one, LinkedList<Integer> two) {

		if (one == null || one.isEmpty() || two == null || two.isEmpty()) {
			return false;
		}
		// one>two, only need to test the difference between one and two plus size of
		// two to see if the interger matches or not
		for (int i = 0; i <= one.size() - two.size(); i++) {
			boolean result = true;
			for (int j = 0; j < two.size(); j++) {
				if (one.get(i + j) != two.get(j)) {
					result = false;
					break;
				}
			}
			if (result) {
				return true;
			}
		}

		return false;
	}
}
