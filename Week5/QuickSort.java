public class QuickSort{


    public int partition(int[] a) {
        double sum = 0;
        for (int val : a) {
            sum += val;
        }
        double avg = sum / a.length;

        double minDiff = Double.MAX_VALUE;
        int keyIndex = 0;
        for (int i = 0; i < a.length; i++) {
            double diff = Math.abs(a[i] - avg);
            if (diff < minDiff || (diff == minDiff && a[i] < a[keyIndex])) {
                minDiff = diff;
                keyIndex = i;
            }
        }

        int pivot = a[keyIndex];
        a[keyIndex] = a[0];
        a[0] = pivot;

        int i = 0;

        for (int j = 1; j < a.length; j++) {
            if (a[j] < pivot) {
                i++;
                int temp = a[i];
                a[i] = a[j];
                a[j] = temp;
            }
        }

        int temp = a[0];
        a[0] = a[i];
        a[i] = temp;

        return i;
    }


    public static void main(String[] args)
    {
        QuickSort q = new QuickSort();

        int[] a = {1,2,5,3,4,1,3,4,5,6,10};

        int key = q.partition(a);

        System.out.println("key = "+a[key]+" index = "+key);
        System.out.print("Array a = ");
        for(int i = 0 ; i < a.length ; i++)
            System.out.print(a[i]+" ");
    }

}
