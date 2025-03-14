public class Pattern{
    
    
    
    public int match(int[] a, int[] b)
    {
        if (a == null || b == null || a.length == 0 || b.length == 0 || a.length > b.length) {
            return -1;
        }

        for (int i = 0; i <= b.length - a.length; i++) {
            boolean found = true;
            for (int j = 0; j < a.length; j++) {
                if (a[j] != b[i + j]) {
                    found = false;
                    break;
                }
            }
            if (found) {
                return i;
            }
        }

        return -1;    
        
    }
    
    
}
