package IntroductionToJavaProgramming.chapter22_lists_stacks_queues;

import java.io.File;
import java.util.LinkedList;
import java.util.Queue;

public class DirectorySize22_18 {

    public static void main(String[] hh){

        System.out.println(getSize(new File("path")));

    }

    private static long getSize(File directory){
        long size = 0;
        Queue<File> queue = new LinkedList<>();
        queue.add(directory);

        while (queue.size() > 0){
            File t = queue.remove();
            if (t.isDirectory()){
                File[] files = t.listFiles();
                for (File file :
                        files) {
                    queue.offer(file);
                }
            }else size += t.length();
        }
        return size;
    }
}
