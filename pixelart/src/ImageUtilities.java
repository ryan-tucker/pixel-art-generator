import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class ImageUtilities
{
    public static BufferedImage loadImage(String path)
    {
        BufferedImage image = null;

        try
        {
            image = ImageIO.read(new File(path));
        }
        catch(IOException e)
        {
            e.printStackTrace();
            System.exit(0);
        }
        return image;
    }
}
