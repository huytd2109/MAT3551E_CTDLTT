@SuppressWarnings("unchecked")
public class Dictionary {
    private DictList<String> enList = null; // Danh sách lưu các từ tiếng Anh
	private DictList<String> viList = null; // Danh sách lưu các từ tiếng Việt

	
	//	Phương thức loadDictionary(String[] en, String[] vi), phương thức này thực hiện nạp từ điển, 
	//lưu các phần tử trong mảng en vào danh sách chứa các từ tiếng Anh, 
	//và các phần từ trong mảng vi vào danh sách chứa các từ tiếng Việt.
	public void loadDictionary(String[] en, String[] vi)
	{
	    // Khởi tạo các danh sách nếu chưa được khởi tạo
	    if (enList == null) {
	        enList = new DictList<String>();
	    }
	    if (viList == null) {
	        viList = new DictList<String>();
	    }
	    
	    // Nạp từ điển từ hai mảng en và vi
	    for (int i = 0; i < en.length; i++) {
	        enList.add(en[i]);
	        viList.add(vi[i]);
	    }
	}
	
	//	Phương thức translate(DictList en), 
	//phương thức này trả lại 1 danh sách các từ tiếng Việt tương ứng với các từ trong danh sách en.
	public DictList<String> translate(DictList<String> en)
	{
		DictList<String> result = new DictList<String>();
		
		for (int i = 0; i < en.size(); i++) {
		    String englishWord = en.get(i);
		    
		    for (int j = 0; j < enList.size(); j++) {
		        if (enList.get(j).equals(englishWord)) {
		            result.add(viList.get(j));
		            break;
		        }
		    }
		}
		
		return result;
	}
}
