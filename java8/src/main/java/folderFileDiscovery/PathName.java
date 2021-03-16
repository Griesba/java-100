package folderFileDiscovery;

import java.io.File;

public class PathName {

    public static void listDirectory(String path){
        File file = new File(path);
        if (file != null) {
            File[] files = file.listFiles();
            if (files != null && files.length > 0) {
                for (File file1 : files){
                    if (file1.isDirectory()) {
                        System.out.println("D-" +file1.getName());
                        listDirectory(file1.getAbsolutePath());
                    } else {
                        System.out.println("F-" + file1.getName() + " ("+ file1.length() +" bytes)");
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        listDirectory(args[0]);
    }
}
