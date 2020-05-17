package TwentiethHomeWorks.Loader;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class Loader implements Runnable{
    private URL url;

    public URL getUrl() {
        return url;
    }

    public void setUrl(URL url) {
        this.url = url;
    }

    @Override
    public void run() {
        try {
            url = new URL("https://drive.google.com/u/0/uc?id=1JHdKkkJJZwd71GGLDCzOzc0wTFTO3dpB&export=download");
            URLConnection conn;
            conn = url.openConnection();
            conn.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.11 (KHTML, like Gecko) Chrome/23.0.1271.95 Safari/537.11");
            conn.connect();

            FileOutputStream out = new FileOutputStream("output20.txt");
            BufferedInputStream bis = new BufferedInputStream(conn.getInputStream());

            int ch;
            try {
                while ((ch = bis.read()) != -1 && !Thread.interrupted()) {
                    Thread.sleep(1);
                    out.write(ch);
                }
            } catch (InterruptedException e){
                return;
            }
            System.out.println("Файл скачан");
            bis.close();
            out.flush();
            out.close();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
