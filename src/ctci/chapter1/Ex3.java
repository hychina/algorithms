package chapter1;

//	Design an algorithm and write code to remove the duplicate characters in a string 
//	without using any additional buffer NOTE: One or two additional variables are fine 
//	An extra copy of the array is not
//	FOLLOW UP
//	Write the test cases for this method
public class Ex3 {

	public static void main(String[] args) {
		char[] str = "sl;dfjlsdfja".toCharArray();
		dedup(str);
	}
	
	public static void dedup(char[] str) {
		if (str == null) return;
		int len = str.length;
		if (len < 2) return;
		
		int tail = 1;
		for (int i = 1; i < len; i++) {
			int j;
			for (j = 0; j < tail; j++) {
				if (str[i] == str[j]) break;
			}
			if (j == tail) {
				str[tail] = str[i];
				tail++;
			}
		}
		str[tail] = 0;
		System.out.println(str);
	}

}
