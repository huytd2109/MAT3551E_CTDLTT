@SuppressWarnings("unchecked")
public class Dictionary {

    private DictList<String> viList = null; // Danh sách lưu các từ tiếng Việt
    private DictList<String> enList = null; // Danh sách lưu các từ tiếng Anh

    // Phương thức nạp từ điển
    public void loadDictionary(String[] vi, String[] en) {
        viList = new DictList<String>();
        enList = new DictList<String>();

        for (int i = 0; i < vi.length; i++) {
            viList.add(vi[i]);
            enList.add(en[i]);
        }
    }

    // Dịch danh sách từ tiếng Việt sang tiếng Anh
    public DictList<String> translate(DictList<String> vi) {
        DictList<String> result = new DictList<String>();

        for (int i = 0; i < vi.size(); i++) {
            String word = vi.get(i);
            boolean found = false;

            for (int j = 0; j < viList.size(); j++) {
                if (viList.get(j).equals(word)) {
                    result.add(enList.get(j));
                    found = true;
                    break;
                }
            }

            if (!found) {
                result.add("UNKNOWN");
            }
        }

        return result;
    }
}
