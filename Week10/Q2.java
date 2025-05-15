import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@SuppressWarnings("unchecked")
public class Q2 {

    // Tính tổng kích thước của thư mục (bao gồm cả thư mục con)
    public static long size(File file) {
        if (file.isFile()) {
            return file.length();
        }

        long total = 0;
        File[] children = file.listFiles();
        if (children != null) {
            for (File child : children) {
                total += size(child); // đệ quy cho thư mục con
            }
        }
        return total;
    }

    // Liệt kê các tệp trong thư mục (không bao gồm thư mục con), sắp xếp theo kích thước giảm dần
    public static List<String> ls(File file) {
        List<File> files = new ArrayList<>();
        File[] children = file.listFiles();

        if (children != null) {
            for (File child : children) {
                if (child.isFile()) {
                    files.add(child);
                }
            }
        }

        // Sắp xếp theo kích thước giảm dần
        Collections.sort(files, new Comparator<File>() {
            public int compare(File f1, File f2) {
                return Long.compare(f2.length(), f1.length());
            }
        });

        // Trả về danh sách tên tệp đã sắp xếp
        List<String> result = new ArrayList<>();
        for (File f : files) {
            result.add(f.getName());
        }

        return result;
    }
}
