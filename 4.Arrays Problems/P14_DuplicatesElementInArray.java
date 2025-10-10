import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class P14_DuplicatesElementInArray {

    public static void main(String[] args) {

        int[] arr = { 2, 3, 5, 6, 7, 54, 34, 6, 2 };

        System.out.println("simply checking duplicates element ");
        duplicateElementBruteForce(arr);
        System.out.println("Brtue force ");
        duplicateElementBruteForceOptimize(arr);
        System.out.println("HashMap approach");
        duplicateElementHashMap(arr);

    }

    public static void duplicateElementBruteForce(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] == arr[j]) {
                    System.out.println(arr[i]);
                }
            }
        }
    }

    public static void duplicateElementBruteForceOptimize(int[] arr)
    {
        boolean[] visited = new boolean[arr.length];

        for(int i = 0;i<arr.length;i++)
        {
            if(visited[i]) continue;
            int count = 1;
            for(int j = i+1;j<arr.length;j++)
            {
                if(arr[i]==arr[j])
                {
                    visited[j]=true;
                    count++;
                }
            }
            if(count>1)
            {
                System.out.println(arr[i]+" : "+count);
            }
        }


    }


    public static void duplicateElementHashMap(int[] arr)
    {
       HashMap<Integer , Integer> map = new HashMap<>();
        for(int i = 0 ;i<arr.length;i++)
        {
            map.put(arr[i], map.getOrDefault(arr[i], 0)+1);
        }
        for(Map.Entry<Integer ,Integer> entry : map.entrySet())
        {
            if(entry.getValue() > 1 )
             {
                System.out.println(entry.getKey() +" : "+entry.getValue());
            }
        }
    }


}
