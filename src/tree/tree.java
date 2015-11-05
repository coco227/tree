package tree;
//树的参考资料： http://blog.chinaunix.net/uid-25434387-id-1745987.html

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class tree {
	
	private static Scanner s;
	
	public static ArrayList<TreeNode> treeArray = new ArrayList<>();

	public static void main(String[] args)  {
		s = new Scanner(System.in);
		  String str = null;
		       System.out.println("请输入您想遍历的文件路径：");
		       str = s.next();
		       str = "/Users/macuser/Desktop/js_codes/kangfuzhushou190_dev";
		       File file = new File(str);
		       System.out.println(file.getName());
		       traverseFolder(str, 0);
		       pri();
		       
	}
	
	public static void traverseFolder(String path, int level) {
		File file = new File(path);
        if (file.exists()) {
            File[] files = file.listFiles();
            if (files.length == 0) {
                System.out.println("文件夹是空的!");
                return;
            } else {
                for (File file2 : files) {
                    if (file2.isDirectory()) {
                    	   TreeNode tree = new TreeNode();
                        tree.level = level;
                        tree.name  = file2.getName();
                        treeArray.add(tree);
                        traverseFolder(file2.getAbsolutePath(), level + 1);
                    } else {
                        TreeNode tree = new TreeNode();
                        tree.level = level;
                        tree.name  = file2.getName();
                        treeArray.add(tree);
                    }
                }
            }
        } else {
            System.out.println("文件不存在!");
        }
	}
	
	public static void pri(){
		for (int i = 0; i < treeArray.size(); i++) {
			for (int j = 0; j < treeArray.get(i).level; j++) {
				System.out.print("        ");
			}
			System.out.print("|——");
			System.out.println(treeArray.get(i).name);
//			System.out.println(treeArray.get(i).name);
//			System.out.println(treeArray.get(i).level);
		}
	}
}
