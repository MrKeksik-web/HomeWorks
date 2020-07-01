package FifteenthHomeWorks.Commands;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Date;

public class Dir implements Command{
    public File dir(String absPath){
        File file = new File(absPath);

        System.out.print("----------------------------------------------------------" + "\n");
        System.out.println("Folder contents " + file.getAbsolutePath());
        System.out.printf("%-32s%-18s%-20s%-11s%n","Last change","File or folder","Weight in bytes","Name");
        for(int i = 0;i < file.listFiles().length;i++){
            Date date = new Date(file.listFiles()[i].lastModified());
            String dirOrFile = file.listFiles()[i].isDirectory() ? "DIR" : "FILE";
            Long size = this.dirSize(file.listFiles()[i].getAbsolutePath());
            String name = file.listFiles()[i].getName();
            System.out.printf("%-32s%-18s%-20d%-11s%n",date,dirOrFile,size,name);
        }
        System.out.print("\n");
        return file;
    }

    private long dirSize(String absPath){
        File file = new File(absPath);
        long size = 0;

        if(file.isDirectory()){
            File[] listFiles = file.listFiles();
            if(listFiles != null) {
                for (int i = 0; i < listFiles.length; i++) {
                    if (listFiles[i].isFile()) {
                        size += listFiles[i].length();
                    } else {
                        size += this.dirSize(listFiles[i].getAbsolutePath());
                    }
                }
            }
        }
        return size + file.length();
    }

    @Override
    public File run(String absPath,String path) throws IOException {
        return  this.dir(absPath);
    }
}
