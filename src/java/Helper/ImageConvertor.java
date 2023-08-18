package Helper;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.Base64;
import javax.imageio.ImageIO;

/**
 *
 * @author vinnie chin
 */
public class ImageConvertor {

    public static String getImage(Blob blob) throws SQLException, IOException {
        
        // Convert blob image into base64 string
        byte byteArray[] = blob.getBytes(1, (int) blob.length());

        BufferedImage img = ImageIO.read(new ByteArrayInputStream(byteArray));

        ByteArrayOutputStream output = new ByteArrayOutputStream();
        ImageIO.write(img, "png", output);
        String imageAsBase64 = Base64.getEncoder().encodeToString(output.toByteArray());

        // Return to the converted base64 string to the caller
        return imageAsBase64;
    }
}