package ma.zs.generated.service.util;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class ImageUtil {
    public static String storeImage(String path,String fileName,String base64String){
        String base64Image = base64String.split(",")[1];
        byte[] imageBytes = javax.xml.bind.DatatypeConverter.parseBase64Binary(base64Image);
        String filePath=path+fileName+".jpg";
        try (OutputStream stream = new FileOutputStream(filePath)) {
            stream.write(imageBytes);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return filePath;
    }
}
