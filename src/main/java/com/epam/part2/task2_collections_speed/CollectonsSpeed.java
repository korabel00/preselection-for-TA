package com.epam.part2.task2_collections_speed;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class CollectonsSpeed {

    public static void main(String[] args) {

        final int ITERATIONS = 10000;

        CollectonsSpeed collectonsSpeed = new CollectonsSpeed();

        List<Integer> arrayList = new ArrayList<>();
        List<Integer> linkedList = new LinkedList<>();
        Set<Integer> hashSet = new HashSet<>();
        Set<Integer> treeSet = new TreeSet<>();
        Map<Integer, Integer> hashMap = new HashMap<>();
        Map<Integer, Integer> treeMap = new TreeMap<>();

        System.out.println("------------------------Add---------------------------------------");
        collectonsSpeed.addToCollection(ITERATIONS, arrayList);
        collectonsSpeed.addToCollection(ITERATIONS, linkedList);
        collectonsSpeed.addToCollection(ITERATIONS, hashSet);
        collectonsSpeed.addToCollection(ITERATIONS, treeSet);
        collectonsSpeed.addToCollection(ITERATIONS, hashMap);
        collectonsSpeed.addToCollection(ITERATIONS, treeMap);

        System.out.println("------------------------Search---------------------------------------");
        int indexToSearch = ThreadLocalRandom.current().nextInt(1, ITERATIONS + 1);
        collectonsSpeed.searchInCollection(arrayList, indexToSearch);
        collectonsSpeed.searchInCollection(linkedList, indexToSearch);
        collectonsSpeed.searchInCollection(hashSet, indexToSearch);
        collectonsSpeed.searchInCollection(treeSet, indexToSearch);
        collectonsSpeed.searchInCollection(hashMap, indexToSearch);
        collectonsSpeed.searchInCollection(treeMap, indexToSearch);

        System.out.println("------------------------Delete---------------------------------------");
        int indexToDelete = ThreadLocalRandom.current().nextInt(1, 10000 + 1);
        collectonsSpeed.deleteInCollection(arrayList, indexToDelete);
        collectonsSpeed.deleteInCollection(linkedList, indexToDelete);
        collectonsSpeed.deleteInCollection(hashSet, indexToDelete);
        collectonsSpeed.deleteInCollection(treeSet, indexToDelete);
        collectonsSpeed.deleteInCollection(hashMap, indexToDelete);
        collectonsSpeed.deleteInCollection(treeMap, indexToDelete);
    }


    public void addToCollection(int iterations, Object collection) {

        long startTime = System.nanoTime();

        //Если объект типа Map то используем метод put и кладем ключ + значение
        //Если другая коллекция то используем метод add и кладем одно значение
        for (int i = 0; i < iterations; i++) {
            if (collection instanceof AbstractMap) {
                ((AbstractMap) collection).put(i, i);
            } else {
                ((Collection) collection).add(i);
            }
        }

        long stopTime = System.nanoTime();

        System.out.println("Add to " + collection.getClass().getSimpleName());
        System.out.printf("%,d", stopTime - startTime);
        System.out.println();
    }

    public void searchInCollection(Object collection, int index) {

        long startTime = System.nanoTime();

        if (collection instanceof AbstractMap) {
            ((AbstractMap) collection).containsKey(index);
        } else {
            ((Collection) collection).contains(index);
        }

        long stopTime = System.nanoTime();

        System.out.println("Search " + index + " in " + collection.getClass().getSimpleName());
        System.out.printf("%,d", stopTime - startTime);
        System.out.println();
    }

    public void deleteInCollection(Object collection, int index) {

        long startTime = System.nanoTime();

        if (collection instanceof AbstractMap) {
            ((AbstractMap) collection).remove(index);
        } else {
            ((Collection) collection).remove(index);
        }

        long stopTime = System.nanoTime();

        System.out.println("Delete " + index + " in " + collection.getClass().getSimpleName());
        System.out.printf("%,d", stopTime - startTime);
        System.out.println();
    }
}
