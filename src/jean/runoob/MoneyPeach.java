package jean.runoob;

import java.util.LinkedList;
import java.util.List;

public class MoneyPeach {

    public static void main( String[] args )
    {
    	Solution.addElement(1);
    	Solution.addElement(4);
    	Solution.addElement(2);
    	Solution.addElement(3);

		System.out.println(Solution.sSorted);

		
    	int x, y, n;
    	for (x = 1, n = 0; n < 9; y = (x + 1) * 2, x = y, n++) {
        	System.out.println(x);
    	}
    	System.out.println(x);
    }
}

class Solution {
    public static List<Integer> sSorted = new LinkedList<>();

    public static void addElement(int e) {
        int i;
        for (i = 0; i < sSorted.size(); ++i) {
            if (e <= sSorted.get(i)) {
                break;
            }
        }
        
        sSorted.add(i, e);
    }
}
