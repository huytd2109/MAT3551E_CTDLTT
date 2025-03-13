public class RLE {

    /**
     * Computes the length of the compression array.
     * @param t a binary array
     * @return an integer.
     */
    public static int length(int[] t) {
        if (t == null || t.length == 0) {
            return 0;
        }

        int count = 2; 
        int currentValue = t[0];
    
        for (int i = 1; i < t.length; i++) {
            if (t[i] != currentValue) {
                count += 2; 
                currentValue = t[i];
            }
        }
    
        return count;
    }

    /**
     * Compresses an array in RLE format and return the result.
     * @param t
     * @return compressed array.
     */
    public static int[] compress(int[] t) {
        if (t == null || t.length == 0) {
            return new int[0];
        }
    
        int compressedLength = length(t);
        int[] result = new int[compressedLength];
    
        int currentValue = t[0];
        int count = 1;
        int resultIndex = 0;
    
        for (int i = 1; i < t.length; i++) {
            if (t[i] == currentValue) {
                count++;
            } else {
                result[resultIndex++] = currentValue;
                result[resultIndex++] = count;
    
                currentValue = t[i];
                count = 1;
            }
        }
        result[resultIndex++] = currentValue;
        result[resultIndex] = count;
    
        return result;
    }

    /**
     * Computes the length of the decompressed array.
     * @param t
     * @return an integer.
     */
    public static int lengthInverse(int[] t) {
        if (t == null || t.length == 0) {
            return 0;
        }

        int length = 0;
        for (int i = 1; i < t.length; i += 2) {
            length += t[i];
        }
    
        return length;
    }

    /**
     * Decompresses the array.
     * @param t
     * @return an array
     */
    public static int[] decompress(int[] t) {
        if (t == null || t.length == 0) {
            return new int[0];
        }
    
        int decompressedLength = lengthInverse(t);
        int[] result = new int[decompressedLength];
    
        int resultIndex = 0;
    
        for (int i = 0; i < t.length; i += 2) {
            int value = t[i];
            int count = t[i + 1];
    
            for (int j = 0; j < count; j++) {
                result[resultIndex++] = value;
            }
        }
    
        return result;
    }
}
