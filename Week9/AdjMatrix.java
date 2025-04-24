import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
@SuppressWarnings({"unchecked", "deprecation"})
public class AdjMatrix {
	
	private int[][] matrix;// ma trận kề
	private String[] v;// danh sách các đỉnh
	private int n;// số đỉnh
	
	public void loadGraphFromFile(String fileName)
	{
	    try {
			Scanner scanner = new Scanner(new FileReader(fileName));
			n = scanner.nextInt();
			v = new String[n];
			for (int i = 0; i < n; i++) {
				v[i] = scanner.next();
			}
			
			matrix = new int[n][n];
			
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					matrix[i][j] = scanner.nextInt();
				}
			}
			
			scanner.close();
		} catch (FileNotFoundException e) {
			System.out.println("File not found: " + fileName);
			e.printStackTrace();
		}
	}
	
	public  List<String> getAdjList()
	{
		List<String> adjList = new ArrayList<>();
		
		for (int i = 0; i < n; i++) {
			StringBuilder sb = new StringBuilder();
			sb.append(v[i]);
			
			for (int j = 0; j < n; j++) {
				if (matrix[i][j] > 0) {
					sb.append("->").append(v[j]);
				}
			}
			
			adjList.add(sb.toString());
		}
		
		return adjList;
	}
	

}
