// Viết chương trình chèn 1 phần tử vào mảng đã được sắp xếp theo mô tả đề bài
import java.util.Scanner;
public class Insert{
    public static int[] inputArray(Scanner sc){
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        return a;
    }
    
    public static int findInsertPos(int[] a, int x){
        int index = 0;
        while (index < a.length && a[index] < x){
            index++;
        }
        return index;
    }
    
    public static int[] insertElement(int[] a, int x, int index){
        int[] newArr = new int[a.length + 1];
        for (int i = 0; i < index; i++){
            newArr[i] = a[i];
        }
        newArr[index] = x;
        for (int i = index; i < a.length; i++){
            newArr[i + 1] = a[i];
        }
        return newArr;
    }
    
    public static void printArray(int[] a){
        for (int i = 0; i < a.length; i++){
            System.out.println(a[i] + " ");
        }
        System.out.println();
    }
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int[] a = inputArray(sc);
        int x = sc.nextInt();
        int insertPos = findInsertPos(a, x);
        int[] newArr = insertElement(a, x, insertPos);
        printArray(newArr);
    }
}
