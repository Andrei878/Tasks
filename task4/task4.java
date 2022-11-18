import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class task4 {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: Need to attach one file");
            return;
        }
        String num = args[0];
        File fileNum = new File(num);
        Scanner sc;
        try {
            sc = new Scanner(fileNum);
        } catch (Exception e) {
            System.out.println("Error:" + e.getMessage());
            return;
        }
        ArrayList<Integer> numb = new ArrayList<>();
        getMyNumbers(numb, sc);

        var nums = new Integer[numb.size()];
        numb.toArray(nums);

        int max=0;
        Arrays.sort(nums);
        for (Integer integer : nums) {
            int x = Math.abs(nums[nums.length / 2] - integer);
            max += x;
        }
        System.out.print(max);

    }

    static private void getMyNumbers (ArrayList <Integer> numbers, Scanner sc){
        while (sc.hasNext()) {
            numbers.add(Integer.valueOf(sc.next()));
        }
    }
}
