package chapter1;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.HashMap;

public class Ex1 {
	public static void main(String[] args) {
		isUnique4("快乐撒旦就发了卡上的减肥上的发生的房间爱熟练地将发生里的款到即发");
	}
	
	public static void solution1(String input) {
		HashMap<Character, Integer> uniqueChars = new HashMap<>();
        int len = input.length();
		for (int i = 0; i < len; i++) {
			char ch = input.charAt(i);
			Integer count = uniqueChars.get(ch);
			if (count == null) {
				uniqueChars.put(ch, 1);
			} else {
				uniqueChars.put(ch, count + 1);
			}
		}
		
		System.out.println(uniqueChars.toString());
	}
	
	public static void solution2(String input) {
		int len = input.length();
		for (int i = 0; i < len; i++) {
			for (int j = i + 1; j < len; j++) {
				char ch1 = input.charAt(i);
				char ch2 = input.charAt(j);
				System.out.println("i:" + i +", j:" + j);
				if (ch1 == ch2) {
					System.out.println(ch1 + "==" + ch2);
				} else {
					System.out.println(ch1 + "!=" + ch2);
				}
			}
		}
	}
	
	public static boolean isUnique3(String input) {
		boolean[] char_set = new boolean[0x10000];
		for (int i = 0; i < input.length(); i++) {
			int val = input.charAt(i);
			if (char_set[val]) return false;
			char_set[val] = true;
		}
		return true;
	}
	
	public static void isUnique4(String input) {
		BitSet checker = new BitSet(0x10000);
		ArrayList<Character> dups = new ArrayList<>();
		int num_dup = 0;
		for (int i = 0; i < input.length(); i++) {
			int val = input.charAt(i);
			if (checker.get(val)) {
				num_dup++;
				dups.add((char)val);
			}
			checker.set(val);
		}
		assert num_dup == input.length() - checker.cardinality();
		
		System.out.println(num_dup + dups.toString());
	}
}
