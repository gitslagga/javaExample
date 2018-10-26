package jean.runoob;

import java.util.*;

public class TestList {
    public static void main(String [] args) {
        List<String> list = new ArrayList<String>();
        list.add("Hello");
        list.add("World");
        list.add("HAHAHAHA");
        //链表遍历
        for (String str : list) {
            System.out.println(str);
        }

        //数组遍历
        String[] strings = new String[list.size()];
        list.toArray(strings);
        for (int i = 0; i < strings.length; i++) {
            System.out.println(strings[i]);
        }

        //迭代器遍历
        Iterator<String> ite = list.iterator();
        while (ite.hasNext()) {
            System.out.println(ite.next());
        }



        Map<String, String> map = new HashMap<String, String>();
        map.put("1", "value1");
        map.put("2", "value2");
        map.put("3", "value3");

        System.out.println("通过 Map.keySet遍历key value :");
        for (String key : map.keySet()){
            System.out.println("key = " + key + " and value = " + map.get(key));
        }

        System.out.println("通过 Map.entrySet 使用iterator遍历key value :");
        Iterator<Map.Entry<String, String>> it = map.entrySet().iterator();
        while (it.hasNext()){
            Map.Entry<String, String> entry = it.next();
            System.out.println("key= " + entry.getKey() + " and value= " + entry.getValue());
        }

        System.out.println("通过Map.entrySet 遍历key value");
        for (Map.Entry<String, String> entry : map.entrySet()){
            System.out.println("key = " + entry.getKey() + " and value = " + entry.getValue());
        }

        System.out.println("通过Map.values遍历所有的value, 单不能遍历key");
        for (String v : map.values()){
            System.out.println("value = " + v);
        }

    }
}
