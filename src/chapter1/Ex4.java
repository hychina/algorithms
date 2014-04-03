package chapter1;

// Write a method to decide if two strings are anagrams or not
public class Ex4 {

	public static void main(String[] args) {
		boolean res = isAnagram("ascfasd", "faadssd");
		System.out.println(res);
	}
	
	public static boolean isAnagram(String a, String b) {
		if (a.length() != b.length()) return false;
		int[] count = new int[256];
		for (char c : a.toCharArray())
			count[c]++;
		for (char c : b.toCharArray()) {
			if (count[c] == 0) return false;
		}
		return true;
	}

}
