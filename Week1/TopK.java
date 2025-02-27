public class TopK{

    /*
        Hoàn thiện phương thức getTopk trả lại giá trị lớn thứ k trong dãy
        k <= a.length
    */
    public static int getTopk(int[] a, int k)
    {
        int[] get = new int[a.length];
        get = bubbleSort(a);
        return get[a.length - k];
    }


    public static void main(String[] args)
    {
        int[] a = {1, 3, 2, 1, 4, 5, 7, 9, 8, 5, 6};
        int k = 1;

        System.out.printf("Phần tử lớn thứ %d là: %d",k,getTopk(a,k));

    }

    public static int[] bubbleSort(int[] a)
    {
        for (int i = 0; i < a.length - 1; i++)
        {
            for (int j = i + 1; j < a.length; j++)
            {
                if (a[i] > a[j]) {
                    int temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                }
            }
        }
        return a;





    }
}
