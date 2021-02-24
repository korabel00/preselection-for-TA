package com.epam.part2.task2_collections_speed;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class CollectionsSpeed {

    public static void main(String[] args) {

        final int ITERATIONS = 10000;

        CollectionsSpeed collectionsSpeed = new CollectionsSpeed();

        List<Integer> arrayList = new ArrayList<>();
        List<Integer> linkedList = new LinkedList<>();
        Set<Integer> hashSet = new HashSet<>();
        Set<Integer> treeSet = new TreeSet<>();
        Map<Integer, Integer> hashMap = new HashMap<>();
        Map<Integer, Integer> treeMap = new TreeMap<>();

        System.out.println("------------------------Add---------------------------------------");
        collectionsSpeed.addToCollection(ITERATIONS, arrayList);
        collectionsSpeed.addToCollection(ITERATIONS, linkedList);
        collectionsSpeed.addToCollection(ITERATIONS, hashSet);
        collectionsSpeed.addToCollection(ITERATIONS, treeSet);
        collectionsSpeed.addToCollection(ITERATIONS, hashMap);
        collectionsSpeed.addToCollection(ITERATIONS, treeMap);

        System.out.println("------------------------Search---------------------------------------");
        int indexToSearch = ThreadLocalRandom.current().nextInt(1, ITERATIONS + 1);
        collectionsSpeed.searchInCollection(arrayList, indexToSearch);
        collectionsSpeed.searchInCollection(linkedList, indexToSearch);
        collectionsSpeed.searchInCollection(hashSet, indexToSearch);
        collectionsSpeed.searchInCollection(treeSet, indexToSearch);
        collectionsSpeed.searchInCollection(hashMap, indexToSearch);
        collectionsSpeed.searchInCollection(treeMap, indexToSearch);

        System.out.println("------------------------Delete---------------------------------------");
        int indexToDelete = ThreadLocalRandom.current().nextInt(1, 10000 + 1);
        collectionsSpeed.deleteInCollection(arrayList, indexToDelete);
        collectionsSpeed.deleteInCollection(linkedList, indexToDelete);
        collectionsSpeed.deleteInCollection(hashSet, indexToDelete);
        collectionsSpeed.deleteInCollection(treeSet, indexToDelete);
        collectionsSpeed.deleteInCollection(hashMap, indexToDelete);
        collectionsSpeed.deleteInCollection(treeMap, indexToDelete);
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
