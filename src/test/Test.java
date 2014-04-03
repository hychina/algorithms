package test;

public class Test {
	public static void main(String[] args) {
		byte[] a = "aa".getBytes();
		byte[] b = "bb".getBytes();
		byte[] c = new byte[a.length];
		for (byte i : a)
			System.out.println(Integer.toHexString(i));
		for (byte i : b)
			System.out.println(Integer.toHexString(i));
		for (int i = 0; i < c.length; i++)
			c[i] = (byte) (a[i] ^ b[i]);
		for (byte i : c)
			System.out.println(Integer.toHexString(i));
    }
}
