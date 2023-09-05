package com.land.tinnova.questoes_de_um_a_quatro;

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {3, 2, 4, 5, 1, 7, 0, 6};
        boolean swapped;
        int n = arr.length;
        do {
            swapped = false;
            for (int i = 1; i < n; i++) {
                if (arr[i - 1] > arr[i]) {
                    int temp = arr[i - 1];
                    arr[i - 1] = arr[i];
                    arr[i] = temp;
                    swapped = true;
                }
            }
        }while (swapped) ;
            for (int num : arr) {
                System.out.print(num + " ");
            }
        }
}
