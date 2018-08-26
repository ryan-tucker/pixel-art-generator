import java.awt.image.BufferedImage;
import java.imageio.ImageIO;
import java.io.File;

public class ImageUtilities
{
    public BufferedImage loadImage(String path)
    {
        BufferedImage image = null;

        try
        {
            image = ImageIO.read(new File(path));
        }
        catch(IOException e)
        {
            System.printStackTrace();
            System.exit(0);
        }
        return image;
    }
}
