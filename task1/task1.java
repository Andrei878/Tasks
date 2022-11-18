public class task1 {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Usage: Сheck the number of variables entered(n,m)");
            return;
        }
        int n = Integer.parseInt(args[0]);
        int m = Integer.parseInt(args[1]);
        if(n>0 && m>0) {
            int[] array1 = new int[n];
            for (int i = 0; i < array1.length; i++) {
                array1[i] = i + 1;
            }
            int numb1 = array1[0];
            Array(m, numb1, n);
        }
        else {
            System.out.println("Error: variables cannot be equal to zero or negative");
        }
    }
    public static void Array(int m, int y, int n) {
        int numb1 = y;
        while (true) {
            int[] array = new int[m];
            for (int i = 0; i < array.length; i++) {
                array[i] = y + i;
                if (array[i]>=n && array.length-i != 1) {
                    y = 0 - i;
                }
            }
            System.out.print(array[0]);
            if (array[array.length-1]==numb1) {
                break;
            }
            else {
                y += m - 1;
            }
        }
    }
}
