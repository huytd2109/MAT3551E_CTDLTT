// Hoàn thành phương thức mergeArray thực hiện ghép 2 mảng a, b đã được sắp xếp thành 1 mảng đã được sắp xếp.

public class MergeArray{
    
    public int[] mergeArray(int[] a, int[] b)
    {
        int n1 = a.length;
        int n2 = b.length;
        int i = 0, j = 0, k = 0;
        int[] mergedArray = new int [n1 + n2];
        
        while(i < n1 && i < n2){
            if (a[i] <= b[j]){
                mergedArray[k++] = a[i++];
            }
            else{
                mergedArray[k++] = b[j++];

            }
        }
        
        while (i < n1){
            mergedArray[k++] = a[i++];
        }
        
        while (j < n2){
            mergedArray[k++] = b[j++];

        }
        return mergedArray;
    }
    
    
    
}

