package tree;
//树的参考资料： http://blog.chinaunix.net/uid-25434387-id-1745987.html
import java.io.File;
import java.util.Scanner;
import javax.swing.*;

public class tree {
	
	private static Scanner s;
	private  int   treeLevel = 0;

	public static void main(String[] args)  {
		s = new Scanner(System.in);
		  String str = null;
		       System.out.println("请输入您想遍历的文件路径：");
		       str = s.next();
		       str = "/Users/macuser/Desktop/js_codes/kangfuzhushou190_dev";
		       File file = new File(str);
		       System.out.println(file.getName());
		       traverseFolder(str, -5);
		       
	}
	
	public static void traverseFolder(String path, int level) {
		//System.out.println(level);
        File file = new File(path);
        if (file.exists()) {
            File[] files = file.listFiles();
            for (File file2 : files) {
                if (file2.isDirectory()) {
            		for (int i = 0; i < level + 5; i++) {
					System.out.print(' ');System.out.print(' ');
				}
            		System.out.print('|');System.out.print('—');System.out.print('—');
                    System.out.println(file2.getName());
                    traverseFolder(file2.getAbsolutePath() , (level + 1));
                } else {
                	//System.out.print("|     ");
                		for (int i = 0; i < level + 5; i++) {
						System.out.print("  ");
					}
                		System.out.print('|');System.out.print('—');System.out.print('—');
                		System.out.println(file2.getName());
                }
            }
        } else {
            System.out.println("文件不存在!");
        }
    }
}
