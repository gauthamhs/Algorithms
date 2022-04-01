package algorithms.datastructures.arrays.extras;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;

// In this method, we are trying to skip a character if there is a backspace in front of it.
// For example, if we have characters followed by two backspaces, we skip two characters preceeding it
public class BackspaceStringCompare {
	public static boolean backspaceCompare(String S, String T) {

		Deque<Character> stack = new ArrayDeque<>();

		String s1 = filteredString(stack, S);
		String s2 = filteredString(stack, T);

		return s1.equals(s2);

	}

	public static String filteredString(Deque<Character> stack, String str) {

		StringBuilder sb = new StringBuilder("");
		for (char i : str.toCharArray()) {
			if (!stack.isEmpty() && i == '#') {
				stack.pop();
			} else {
				if (i != '#')
					stack.addFirst(i);
			}
		}

		String updatedString = stack.stream().map(ch -> sb.append(ch)).collect(Collectors.joining());

		return updatedString;

	}

	public static boolean backSpaceCompareConstantSpace(String S, String T) {
		String s1 = constantFilteredString(S);
		String s2 = constantFilteredString(T);

		return s1.equals(s2);
	}

	public static String constantFilteredString(String str) {

		StringBuilder sb = new StringBuilder("");

		int l = str.length() - 1;
		int skips = 0;

		while (l >= 0) {
			if (str.charAt(l) == '#') {
				++skips;
			} else {
				if (skips > 0) {
					--skips;
				} else {
					sb.append(str.charAt(l));
				}
			}
			--l;
		}

		return sb.toString();
	}

	public static void main(String[] args) {
		Boolean val = backspaceCompare("y#fffo##f", "y#ffff#o##f");
		System.out.println(val);
		Boolean val2 = backSpaceCompareConstantSpace("y#fffo##f", "y#ffff#o##f");
		System.out.println(val2);
	}
}