package chapter3;
import utils.BST;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;

public class Ex3_1 {

	public static void main(String[] args) { 
        int[] keys = {1, 2, 3, 4, 5, 6, 7};
        String[] values = {"a", "b", "c", "d", "e", "f", "g"};
        HashMap<Integer, String> map = new HashMap<>();

        for (int i = 0; i < keys.length; i++) { 
            map.put(keys[i], values[i]);
        }

        ArrayList<Map.Entry<Integer, String>> list = new ArrayList<>(map.entrySet());
        Collections.shuffle(list);
        BST<Integer, String> bst = new BST<>();

        for (Map.Entry<Integer, String> entry : list) { 
            bst.put(entry.getKey(), entry.getValue());
        }
        bst.display();
        System.out.println(bst.isBalanced());
	}

}
