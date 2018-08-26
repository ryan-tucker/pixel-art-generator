import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class Main
{
    public static void main(String[] args)
    {
        BufferedImage image = ImageUtilities.loadImage("monalisa.jpg");
        BufferedImage finalImage = new BufferedImage(image.getWidth(),image.getHeight(), BufferedImage.TYPE_INT_RGB);
        Graphics g = finalImage.getGraphics();
        int bits = 64;
        ArrayList<Color> colors = new ArrayList<>();

        int[] currentPixels = null;
        int red, green, blue;
        red = 0;
        green = 0;
        blue = 0;

        int xOffset = image.getTileWidth() / bits;
        int yOffset = image.getTileHeight() / bits;

        for (int i = 0; i < image.getTileWidth() - xOffset; i += xOffset)
        {
            for (int j = 0; j < image.getTileHeight() - yOffset; j += yOffset)
            {
                currentPixels = image.getRGB(i, j, xOffset, yOffset, null, 0, xOffset);

                for (Integer pixel: currentPixels)
                {
                    colors.add(new Color(pixel));
                }

                for (Color c: colors)
                {
                    red += c.getRed();
                    green += c.getGreen();
                    blue += c.getBlue();
                }

                red /= colors.size();
                green /= colors.size();
                blue /= colors.size();

                g.setColor(new Color(red,green,blue));
                g.fillRect(i,j,xOffset,yOffset);
                colors = new ArrayList<>();
                red = 0;
                green = 0;
                blue = 0;
            }

        }

        try
        {
            ImageIO.write(finalImage,"png",new File("monapixel.png"));
        }
        catch (IOException e)
        {

        }

    }
}
