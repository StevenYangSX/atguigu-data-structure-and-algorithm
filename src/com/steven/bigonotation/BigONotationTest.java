package com.steven.bigonotation;

import org.junit.Assert;
import org.junit.Test;

public class BigONotationTest {
    public static void main(String[] args) {

    }

    @Test
    public void testSelectionSort() {
        int[] testCase1 = new int[]{};
        int[] testCase2 = new int[]{1, 3, 5, 6, 8};
        int[] testCase3 = new int[]{9, 7, 5, 3, 1};
        int[] testCase4 = new int[]{1, 9, 2, 8, 3, 7, 5, 6};

        BigONotation.selectionSort(testCase1);
        BigONotation.selectionSort(testCase2);
        BigONotation.selectionSort(testCase3);
        BigONotation.selectionSort(testCase4);

        Assert.assertArrayEquals(new int[]{}, testCase1);
        Assert.assertArrayEquals(new int[]{1, 3, 5, 6, 8}, testCase2);
        Assert.assertArrayEquals(new int[]{1, 3, 5, 7, 9}, testCase3);
        Assert.assertArrayEquals(new int[]{1, 2, 3, 5, 6, 7, 8, 9}, testCase4);

    }
}
