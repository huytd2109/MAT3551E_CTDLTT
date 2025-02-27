//Sinh viên hoàn thành phương thức countPath(int M, int N, int t)
public class Robot {
	public int countPath(int M, int N, int t)
	{
		return count(M, t) + count(M, N - t);
	}
	
	public static int count(int M, int N) {
	    if (M > 1 && N > 1){
	        return count(M - 1, N) + count(M, N - 1);
	    }
	    return 1;
	}
	
}
