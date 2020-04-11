import java.lang.module.FindException;

public class Main
{
    public static void main(String[] args)
    {
        int[] arr = new int[]{1,8,9,15,5,2};
        int[] newArr = selectionSort(arr);
        for(int i = 0; i < arr.length; i++)
        {
            System.out.println(newArr[i]);
        }
    }



    public static int[] selectionSort(int[] arr)
    {
        int smallestIndex;
        int smallestValue;
        for(int i = 0; i < arr.length; i++)
        {
            smallestIndex = i;
            smallestValue = arr[i];
            for(int j = i + 1; j < arr.length; j++)
            {
                if(arr[j] < smallestValue)
                {
                    smallestIndex = j;
                    smallestValue = arr[j];
                }
            }
            arr[smallestIndex] = arr[i];
            arr[i] = smallestValue;

        }
        return arr;
    }

}
