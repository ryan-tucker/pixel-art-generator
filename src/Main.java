import java.awt.image.Raster;
public class Main
{
    public static void main(String[] args)
    {
        BufferedImage image = ImageUtilities.loadImage("test.png");

        int bits = 32;
        int xOffset = image.getNumXTiles() / bits;
        int yOffset = image.getNumYTiles() / bits;

        for (int i = 0; i < image.getNumXTiles();i += xOffset);
        {
            for (int j = i; j < xOffset; j ++)
            {
            }


        }
    }
}
