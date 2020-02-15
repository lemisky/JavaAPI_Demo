package demo18_File;

import java.io.File;
import java.io.FileFilter;

/**
 * 文件过滤类
 * java.io  * 接口 FileFilter
 * java.io  * 接口 FilenameFilter
 * <p>
 * 小示例：获取本项目下所有jpg，png图片文件
 */
public class MyFileFilter {
    public static void main(String[] args) {
        File project = new File(".");

        dg1(project);
    }

    private static void dg1(File project) {
        File[] fs = project.listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                if (pathname.isDirectory()) {
                    return true;
                }
                String name = pathname.getName().toLowerCase();
                if (name.endsWith(".jpg") || name.endsWith(".png")) {
                    return true;
                }
                return false;
            }
        });
        for (File f :
                fs) {
            if (f.isFile()) {
                System.out.println(f.getName());
            }else {
                dg1(f);
            }
        }
    }

    //简写方式
    private static void dg(File project) {
        //参数是文件夹
        for (File f : project.listFiles(f -> f.isDirectory() || f.getName().toLowerCase().endsWith(".png") || f.getName().toLowerCase().endsWith(".jpg"))) {
            if (f.isFile()) {
                System.out.println(f.getName());
            } else {
                dg(f);
            }
        }
    }


}
