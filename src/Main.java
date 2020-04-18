import java.lang.module.FindException;

public class Main {
    public static void main(String[] args) {
        int[] arr = new int[]{1,8,9,15,5,2};
//        int[] newArr = selectionSort(arr);
//        for(int i = 0; i < arr.length; i++)
//        {
//            System.out.println(newArr[i]);
//        }
        //recursion(5);
        //System.out.println(factorial(5))p;

        recursiveQuicksort(arr);

    }


    public static int[] selectionSort(int[] arr) {
        int smallestIndex;
        int smallestValue;
        for (int i = 0; i < arr.length; i++) {
            smallestIndex = i;
            smallestValue = arr[i];
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < smallestValue) {
                    smallestIndex = j;
                    smallestValue = arr[j];
                }
            }
            arr[smallestIndex] = arr[i];
            arr[i] = smallestValue;

        }
        return arr;
    }

    public static void recursion(int num) {
        System.out.println(num);
        if (num <= 0) {
            return;
        } else {
            recursion(num - 1);
        }

    }

    public static int factorial(int num) {

        if (num == 1) {
            return num;
        } else {
            num *= factorial(num - 1);
        }

        return num;

    }

    // We'll just copy, then step through
    public static void recursiveQuicksort(int[] array) {
        doQuickSort(array, 0, array.length - 1);
        showQuickSortedArray(array);
    }

    public static void doQuickSort(int array[], int start, int end) {
        int pivotPoint;

        if (start < end) {
            pivotPoint = partition(array, start, end);

            //by subtracting and adding one to pivotPiont, pivot point is not included in the next round.
            doQuickSort(array, start, pivotPoint - 1);

            doQuickSort(array, pivotPoint + 1, end);
        }

    }

    public static int partition(int array[], int start, int end) {
        int pivotValue;
        int endOfLeftList;
        int mid;

        mid = (start + end) / 2;

        swap(array, start, mid);

        pivotValue = array[start];

        endOfLeftList = start;

        for (int x = start + 1; x <= end; x++) {
            if (array[x] < pivotValue) {
                endOfLeftList++;
                swap(array, endOfLeftList, x); // Figure out swap when it seems redundant
            }
        }

        swap(array, start, endOfLeftList);

        return endOfLeftList;

    }

    public static void swap(int[] array, int a, int b) {
        int temp;

        temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }

    public static void showQuickSortedArray(int[] array){
        for (int element : array)
        {
            System.out.print(element + " ");
        }
        System.out.println();
    }

}
