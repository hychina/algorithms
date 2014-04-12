package chapter1;

// Write code to reverse a C-Style String (C-String means that ¡°abcd¡± is represented as 
// five characters, including the null character )
public class Ex2 {

//	public static void main(String[] args) {
//		char[] str = "ali°¢ÈøµÂÂ·¸½½üfdj\0ssd".toCharArray();
//		int len = 0;
//		for (int i = 0; str[i] != '\0'; i++) len++;
//		for (int i = 0; i < len; i++) {
//			char c = str[i];
//			str[i] = str[len - i - 1];
//			str[len - i - 1] = c;
//			System.out.println(str);
//		}
//		System.out.println(len);
//		System.out.println(str);
//	}

	public static void main(String[] args) {
		char[] str = "abcdefg\0".toCharArray();
		int end = 0;
		while(str[end] != '\0') end++;
		end--;
		int i = 0;
		for (; i < end; i++, end--) {
			char c = str[i];
			str[i] = str[end];
			str[end] = c;
		}
		System.out.println(i + " " + end);
		System.out.println(str);
	}
}
