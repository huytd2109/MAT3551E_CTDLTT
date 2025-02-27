
import java.util.Comparator;
@SuppressWarnings("unchecked")
public class SimpleSort {
	
	// Phương thức sắp xếp cho dữ liệu có giao diện Comparable (có thể so sánh được)
	public static void sort(Comparable[] a)
	{
		int n = a.length;
		for (int i = 0; i < a.length; i++) {
			for(int j = i+1 ; j < a.length ; j++)
			{
				if(a[i].compareTo(a[j]) > 0)
				{
					swap(a,i,j);
				}
			}
		}
	}
	
	// Phương thức sắp xếp cho dữ liệu tổng quát T, thông qua bộ so sánh compare
	public  static <T> void sort(T[] a, Comparator<T> compare){
		for (int i = 0; i < a.length; i++) {
			for(int j = i+1 ; j < a.length ; j++)
			{
				if(compare.compare(a[i], a[j]) > 0)
				{
					swap(a,i,j);
				}
			}
		}
	}
	
	public static <T> void swap(T[] a, int i, int j)
	{
		T tmp = a[i];
		a[i] = a[j];
		a[j] = tmp;
	}
	
	private static void swap(Comparable[] a, int i, int j) {
		Comparable tmp = a[i];
		a[i] = a[j];
		a[j] = tmp;
	}
	
	public static void main(String[] args) {
		
		Integer[] a = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		
		Comparator<Integer> comp = new Comparator<Integer>() {			
			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				if (o1%2 == o2%2)
					return o1 - o2;
				else
					return o1%2 - o2%2;
			}
		};
		
		sort(a, comp);
		for(int i = 0 ; i < a.length ; i++)
			System.out.println(a[i]);
	}

}
