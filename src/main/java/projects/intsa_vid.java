package projects;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.FileOutputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

public class intsa_vid {
    public static void main(String[] args) {
        String videoUrl = "https://www.instagram.com/reel/C1ADigusuRk/?igshid=MTc4MmM1YmI2Ng==";
        String saveDirectory = "C:\\Users\\Admin\\OneDrive\\Desktop\\Programming";
        String videoName = "my_video2.mp4";
        String savePath = saveDirectory + "\\" + videoName;

        try {
            downloadVideo(videoUrl, savePath);
            System.out.println("Video downloaded successfully!");
        } catch (IOException e) {
            System.out.println("Failed to download video.");
            e.printStackTrace();
        }
    }

    private static void downloadVideo(String videoUrl, String savePath) throws IOException {
        URL url = new URL(videoUrl);
        try (InputStream in = url.openStream(); OutputStream out = new FileOutputStream(savePath)) {
            Files.copy(in, Path.of(savePath), StandardCopyOption.REPLACE_EXISTING);
        }
    }
}