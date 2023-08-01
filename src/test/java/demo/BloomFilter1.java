package demo;

import java.util.*;

public class BloomFilter1 {
    private BitSet bitSet;
    private int size;
    private int numHash;

    public BloomFilter1(int size, int numHash) {
        this.size = size;
        this.numHash = numHash;
        this.bitSet = new BitSet(size);
    }

    public void add(String item) {
        Random random = new Random();
        for (int i = 0; i < numHash; i++) {
            int hash = Math.abs(item.hashCode() ^ random.nextInt());
            int index = hash % size;
            bitSet.set(index, true);
        }
    }

    public boolean contains(String item) {
        Random random = new Random();
        for (int i = 0; i < numHash; i++) {
            int hash = Math.abs(item.hashCode() ^ random.nextInt());
            int index = hash % size;
            if (!bitSet.get(index)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

        long l1 = System.currentTimeMillis();
        List<String> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>();
        for (int i = 0; i < 10000000; i++) {
            if (i == 5000000) {
                list1.add("UUID.randomUUID().toString()");
                list2.add("UUID.randomUUID().toString()");
                continue;
            }
            list1.add(UUID.randomUUID().toString());
            list2.add(UUID.randomUUID().toString());
        }

        long l2 = System.currentTimeMillis();
        System.out.println("初始化两个1千万条uuid的list，其中有一条数据是重复的:" + (l2 - l1) + "ms");
        System.out.println(list1.size() + "=====" + list2.size());

        long l21 = System.currentTimeMillis();

        BloomFilter1 bloomFilter = new BloomFilter1(20000000, 3);
        list1.forEach(bloomFilter::add);

        long l3 = System.currentTimeMillis();

        System.out.println("list数据作为key存入map:" + (l3 - l21) + "ms    ");

        List<String> list = new ArrayList<>();

        list2.forEach(k -> {
            if (bloomFilter.contains(k)) {
                list.add(k);
            }
        });
        long l4 = System.currentTimeMillis();
        System.out.println("从map中取数据并比较结果耗时:" + (l4 - l3) + "ms");
        System.out.println("不一致的结果集合大小" + list.size());
//        System.out.println("不一致的结果集合大小" + list);
    }
}

//list数据作为key存入map:1209ms
//        从map中取数据并比较结果耗时:1465ms
