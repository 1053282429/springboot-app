package demo;

import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class BloomFilterExample {


    public static void main(String[] args) {

        long l1 = System.currentTimeMillis();
        int expectedInsertions = 10000000;
        double fpp = 0.000001;
        BloomFilter<CharSequence> bloomFilter = BloomFilter.create(Funnels.unencodedCharsFunnel(), expectedInsertions, fpp);
        long l2 = System.currentTimeMillis();


        List<String> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>();
        // 添加元素到列表
        for (int i = 0; i < 10000000; i++) {
            if (i >= 5000000) {
                String string = UUID.randomUUID().toString();
                list1.add(string + string + string);
                list2.add(string + string + string);
            }
            list1.add(UUID.randomUUID().toString() + UUID.randomUUID().toString());
            list2.add(UUID.randomUUID().toString() + UUID.randomUUID().toString());
        }



        System.out.println("初始化时间" + " "+ (l2-l1));
        // 添加数据到布隆过滤器
        for (String data : list1) {
            bloomFilter.put(data);
        }
        long l3 = System.currentTimeMillis();
        System.out.println("插数时间" + " "+ (l3-l2));

        List<Object> list = new ArrayList<>();
        list2.forEach(k -> {
            if (bloomFilter.mightContain(k)) {
                list.add(k);
            }
        });
        long l4 = System.currentTimeMillis();
        System.out.println("查询时间" + " "+ (l4-l3));

//        System.out.println(list);
        System.out.println(list.size());
    }



}





