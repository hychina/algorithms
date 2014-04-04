package chapter1;

// Write a method to replace all spaces in a string with '%20'
public class Ex5 {

	public static void main(String[] args) {
		String s = "al fj skl djf";
		replace(s.toCharArray());
	}
	
	public static void replace(char[] s) {
		int num_spaces = 0;
		for (int i = 0; i < s.length; i++) {
			if (s[i] == ' ') {
				num_spaces++;
			}
		}
		char[] ns = new char[s.length + 2 * num_spaces];
		int j = 0;
		for (int i = 0; i < s.length; i++) {
			if (s[i] == ' ') {
				ns[j++] = '%';
				ns[j++] = '2';
				ns[j++] = '0';
			} else {
				ns[j++] = s[i];
			}
		}
		System.out.println(ns);
	}

}
