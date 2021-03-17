package folderFileDiscovery;

import java.io.File;

public class PathName {

    public static boolean listDirectory(String path, String fileName){
        File file = new File(path);
        if (file != null) {
            File[] files = file.listFiles();
            if (files != null && files.length > 0) {
                for (File file1 : files){
                    if (file1.isDirectory()) {
                        //System.out.println("D-" +file1.getName());
                        if (listDirectory(file1.getAbsolutePath(), fileName)) {
                            return true;
                        }
                    } else {
                        if (file1.getName().equals(fileName) || file1.getName().startsWith(fileName + ".")) {
                            System.out.println("File found in directory "+ file.getName());
                            return true;
                        }
                        System.out.println("F-" + file1.getName() + " ("+ file1.length() +" bytes)");
                    }
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        if (args.length != 2) {
            throw new IllegalArgumentException("Invalid input. Usage: <directory name> <file name>");
        }
        if (!listDirectory(args[0], args[1])) {
            System.out.println(args[1] + " not found");
        }
    }
}
