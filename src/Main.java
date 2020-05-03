import javax.swing.*;
import java.lang.module.FindException;
import java.util.Stack;
import java.util.regex.*;

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

        //recursiveQuicksort(arr);

        System.out.println(palindromeOrNot("Eva, Can I Stab Bats In A Cave?"));

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

    public static boolean palindromeOrNot(String phrase) //disregard caps and punctuation
    {
        Stack myStack = new Stack();

        int length = phrase.length() / 2;

        for (int x = length-1; x >= 0; x--) {
            if (Character.isDigit(phrase.charAt(x)) || Character.isAlphabetic(phrase.charAt(x))) {
                myStack.push(Character.toLowerCase(phrase.charAt(x)));
            }
        }

        int y = phrase.length()-1;
        int x = 0;
        do
        {
            if(Character.isAlphabetic(phrase.charAt(y)) && myStack.lastElement().equals(Character.toLowerCase(phrase.charAt(y))))
            {
                myStack.pop();
                x++;
            }
            y--;
        }
        while(y > length);

        System.out.println(myStack);
        if(myStack.isEmpty())
        {
            return true;
        }
        return false;
    }


}
