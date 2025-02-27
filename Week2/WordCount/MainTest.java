
import java.util.Scanner;

public class MainTest {

	
		
	public static void main(String[] args) {
		SimpleArrayList<WordCount> wl = new SimpleArrayList<WordCount>(1000);
		Scanner reader = new Scanner(System.in);
		// đọc dữ liệu từ bàn phím
		String text = reader.nextLine();
		// tách dữ liệu thành các từ bởi dấu cách " "
		String[] tokens = text.split(" ");
		
		// thêm các từ vào danh sách
		for(int i = 0 ; i < tokens.length ; i++)
		{
			WordCount w = new WordCount(tokens[i]);
			int id = wl.indexOf(w);
			// nếu từ chưa có trong danh sách
			if(id == -1)
			{
				wl.add(w);
			}
			else
			// nếu từ đã có trong danh sách
			{
				wl.get(id).upCount();
			}
		}
		
		// sắp xếp bằng thuật toán sx chọn
		for(int i = 0 ; i < wl.size() -1 ; i++)
			for(int j = i+1 ; j < wl.size() ; j++)
			{
				if(wl.get(i).getCount() < wl.get(j).getCount() )
				{
					WordCount wi = wl.get(i).clone();
					WordCount wj = wl.get(j).clone();
					wl.set(i, wj);
					wl.set(j, wi);
				}
			}
		// in lại danh sách
		for(WordCount w:wl)
		{
			System.out.println(w);
		}
		
		
	}

}
