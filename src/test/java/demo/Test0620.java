package demo;

import java.util.*;

public class Test0620 {
    public static void main(String[] args) {
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("==========");

        long l1 = System.currentTimeMillis();
        List<String> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>();
        for (int i = 0; i < 10000000; i++) {
            if (i >= 5000000) {
                String string = UUID.randomUUID().toString();
                list1.add(string + string + string);
                list2.add(string + string + string);
            }
            list1.add(UUID.randomUUID().toString() + UUID.randomUUID().toString());
            list2.add(UUID.randomUUID().toString() + UUID.randomUUID().toString());
        }

        long l2 = System.currentTimeMillis();
        System.out.println("初始化两个1千万条uuid的list，其中有一条数据是重复的:" + (l2 - l1) + "ms");
        System.out.println(list1.size() + "=====" + list2.size());
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        long l21 = System.currentTimeMillis();
        Set<String> map = new HashSet<>();
        // 将被比较的表作为map的key  value设为固定值
        list2.forEach(k -> {
            map.add(k);
        });
        long l3 = System.currentTimeMillis();

        System.out.println("list数据作为key存入map:" + (l3 - l21) + "ms    " + "map大小:" + map.size());

        List<String> list = new ArrayList<>();
        //将基准表的数据作为key从map中get,get出的值不等于固定值  说明被比较的表中不存在基准表中的数据
        list1.forEach(k -> {
            if (map.contains(k)) {
                list.add(k);
            }
        });
        long l4 = System.currentTimeMillis();
        System.out.println("从map中取数据并比较结果耗时:" + (l4 - l3) + "ms");
        System.out.println("不一致的结果集合大小" + list.size());
//        System.out.println(list);
//
//        list1.forEach(k -> {
//            list.remove(k);
//        });
//        System.out.println(list);
//        long l5 = System.currentTimeMillis();
//        System.out.println("containsAll时间:" + (l5 - l4) + "ms");
    }
}


//list数据作为key存入map:1663ms    map大小:10000000
//        从map中取数据并比较结果耗时:1256ms
//        不一致的结果集合大小1
//        [UUID.randomUUID().toString()]