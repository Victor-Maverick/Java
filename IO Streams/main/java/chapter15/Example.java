package chapter15;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Example {
    //TODO: java.io and java.nio
    public static void main(String[] args) {
//        String location = "C:\\DELL\\Desktop\\";
//        Path path = Paths.get(location);
//        Path path1 = Path.of(location);
//        System.out.println(path.getRoot());
        //step 1

        try {
            Path path2 = Paths.get("C:\\Users\\DELL\\IdeaProjects\\untitled\\src\\main\\java\\chapter15\\");
            //step 2
            //Files.createFile(path2);
            DirectoryStream<Path> directoryStream = Files.newDirectoryStream(path2);
            directoryStream.forEach(System.out::println);
        }
        catch (IOException e) {
            e.printStackTrace();
        }


        //String path = "C:\\DELL\\Desktop\\";-->is not a path but a normal string;
        //Paths
        //windows ==> C:\DELL\\Desktop\...
        //unix ==> /home/usr/...
    }
}
