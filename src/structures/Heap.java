package structures;

import java.util.*;

/**
 * Created by edma_ on 9/20/2016.
 */
public class Heap {
    private int[] heap;
    private int size;

    /**
     * Constructs a min-heap with a specified size
     * @param capacity max size of the heap
     */
    public Heap(int capacity) {
        heap = new int[capacity + 1];
    }

    /**
     * Returns heap's current size
     * @return size
     */
    public int getSize() {
        return size;
    }

    /**
     * Inserts a value into the heap
     * @param val integer to be inserted
     */
    public void insert(int val) {
        if (size == heap.length) {
            return;
        }
        heap[size++] = val;
        heapifyUp(size - 1);
    }

    /**
     * Deletes an item from the heap
     * @param i index of heap to be deleted
     * @return deleted integer
     */
    public int delete(int i) {
        if (size == 0) {
            throw new NoSuchElementException("Heap is empty");
        }
        int item = heap[i];
        size--;
        heapifyDown(i);
        return item;
    }

    /**
     * Deletes the smallest item in the heap
     * @return value of deleted item
     */
    public int deleteMin() {
        return delete(0);
    }

    /**
     * Gets the minimum element in the heap
     * @return smallest element in the heap
     */
    public int findMin() {
        if (size == 0) {
            throw new NoSuchElementException("Heap is empty");
        }
        return heap[0];
    }

    /**
     * Gets the parent index of the parameter index
     * @param i index to find parent
     * @return parent index of i
     */
    private int getParentIndex(int i) {
        return (i - 1) / 2;
    }

    /**
     * Gets the kth child index of an index
     * @param i index to find kth child
     * @param k kth child to find
     * @return index of kth child
     */
    private int getKthChild(int i, int k) {
        return (i * 2) + k;
    }

    /**
     * Heapifies up
     * @param childIndex child index
     */
    private void heapifyUp(int childIndex) {
        int temp = heap[childIndex];
        while (childIndex > 0 && temp < heap[getParentIndex(childIndex)]) {
            heap[childIndex] = heap[getParentIndex(childIndex)];
            childIndex = getParentIndex(childIndex);
        }
        heap[childIndex] = temp;
    }

    /**
     * Heapifies down
     * @param i index
     */
    private void heapifyDown(int i) {
        int child;
        int temp = heap[i];
        while (getKthChild(i, 1) < size) {
            child = getMinChild(i);
            if (heap[child] < temp) {
                heap[i] = heap[child];
            }
            else {
                break;
            }
            i = child;
        }
        heap[i] = temp;
    }

    /**
     * Gets smallest child of an index
     * @param i index
     * @return smallest child index
     */
    private int getMinChild(int i) {
        int minChild = getKthChild(i, 1);
        int k = 2;
        int position = getKthChild(i, k);
        while (k <= 2 && position < size) {
            if (heap[position] < heap[minChild]) {
                minChild = position;
            }
            position = getKthChild(i, k++);
        }
        return minChild;
    }

    /**
     * Heap sort; builds a heap then returns an array in sorted form using the heap
     * @param arr array to be sorted
     * @return array in sorted form
     */
    public static int[] heapSort(int[] arr) {
        int[] result = new int[arr.length];
        Heap heap = new Heap(arr.length);
        for (int i = 0; i < arr.length; i++) {
            heap.insert(arr[i]);
        }
        for (int j = 0; j < arr.length; j++) {
            result[j] = heap.deleteMin();
        }
        return result;
    }
}
