public class InsertionPosition{
    
    public static int getInsertPosition(int[] a, int x){
        for (int i = 0; i < a.length; i++) {
            if (a[i] >= x){
                return i;
            }
        }
        return a.length;
    }
    
    
    
    public static void main(String[] args){
        
        
        
    }
    
    
    
}
