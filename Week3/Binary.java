@SuppressWarnings("unchecked")
public class Binary{
    
    public static String toBinary(int n)
    {
        if (n == 0){
            return "0";
        }
        String binary = toBinary(n/2)+n%2;
        return binary.replaceFirst("^0+","");
    }
    
    public static void main(String[] args)
    {
        int n =  6;
        
        System.out.println("So "+ n+" co dang nhi phan la: "+toBinary(n));
    }
}
