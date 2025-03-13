
public class LZ77 {
    /**
     * This function takes an input array t, the current position in the array,
     * and the size of the window. It returns the largest Occurrence found in the window.
     * Don't forget that the current character is not in the window.
     * @param t
     * @param currentPosition
     * @param windowSize
     * @return an occurrence
     */

    public static Occurrence longestOccurrence(int[] t, int currentPosition, int windowSize) {
        // If we're at the start of the array, no previous occurrences exist
        if (currentPosition == 0) {
            return new Occurrence(0, 0);
        }

        // Calculate window boundaries
        int windowStart = Math.max(0, currentPosition - windowSize);
        int windowEnd = currentPosition;

        int maxLength = 0;
        int bestPosition = 0;

        for (int i = windowStart; i < windowEnd; i++) {
            int currentLength = 0;

            while (currentPosition + currentLength < t.length &&
                   i + currentLength < windowEnd &&
                   t[i + currentLength] == t[currentPosition + currentLength]) {
                currentLength++;
            }

            if (currentLength > maxLength) {
                maxLength = currentLength;
                bestPosition = i;
            }
        }

        if (maxLength > 0) {
            return new Occurrence(currentPosition - bestPosition, maxLength);
        } else {
            return new Occurrence(0, 0);
        }
    }

    /**
     * Computes the length of the compressed array.
     * @param t
     * @param windowSize
     * @return the length of the compressed array.
     */
    public static int length(int[] t, int windowSize) {
        if (t == null || t.length == 0) {
        return 0;
    }

        int count = 0;
        int pos = 0;

        while (pos < t.length) {
            Occurrence o = longestOccurrence(t, pos, windowSize);
            count++;
            pos += o.size + 1;
        }

        return count;
    }

    /**
     * Compresses an array t.
     * @param t
     * @param windowSize
     * @return an array of Element.
     */
    public static Element[] compress(int[] t, int windowSize) {
        if (t == null || t.length == 0) {
            return new Element[0];
        }

        int resultSize = length(t, windowSize);
        Element[] result = new Element[resultSize];

        int pos = 0;
        int resultIndex = 0;

        while (pos < t.length) {
            Occurrence o = longestOccurrence(t, pos, windowSize);
            int nextSymbol = (pos + o.size < t.length) ? t[pos + o.size] : 0;
            result[resultIndex++] = new Element(o, nextSymbol);
            pos += o.size + 1;
        }

        return result;
    }

    /**
     * Prints out the compression array.
     * @param t
     */
    public static void printCompression(Element[] t) {
        StringBuilder sb = new StringBuilder(1024);
        for (Element e : t) {
            sb.append(e.toString());
        }
        System.out.println(sb);
    }

    /**
     * Computes the length of the decompressed data, given the
     * compressed data.
     * @param t
     * @return a length
     */
    public static int lengthInverse(Element[] t) {
        int len = 0;
        for (Element e : t) {
            len += e.o.size;
        }
        return len + t.length;
    }

    /**
     * Decompresses data.
     * @param t
     * @return an array representing decompressed data
     */
    public static int[] decompress(Element[] t) {
        if (t == null || t.length == 0) {
            return new int[0];
        }

        int[] result = new int[lengthInverse(t)];
        int currentPosition = 0;

        for (Element e : t) {
            if (e.o.size > 0) {
                int sourceStart = currentPosition - e.o.retour;
                blit(result, result, sourceStart, e.o.size, currentPosition);
                currentPosition += e.o.size;
            }
            result[currentPosition++] = e.s;
        }

        return result;
    }

    /**
     * Copy the characters of array t1, going from start1 to start1 + len - 1
     * to the array t2, starting from position start2.
     * @param t1
     * @param t2
     * @param start1
     * @param len
     * @param start2
     */
    static void blit(int[] t1, int[] t2, int start1, int len, int start2) {
        for (int i = 0; i < len; i++) {
            t2[start2 + i] = t1[start1 + i];
        }
    }

    public static void printDecompression(int[] t) {
        for (int i : t) {
            System.out.print(i);
            System.out.print(" ");
        }
        System.out.println();
    }
}

class Element {
    Occurrence o;
    int s;

    Element(Occurrence o, int s) {
        this.o = o;
        this.s = s;
    }

    @Override
    public String toString() {
        return o.toString() + s;
    }
}

class Occurrence {
    int retour;
    int size;

    Occurrence (int retour, int size) {
        this.retour = retour;
        this.size = size;
    }

    @Override
    public String toString() {
        return "(" + retour + "," + size + ")";
    }
}
