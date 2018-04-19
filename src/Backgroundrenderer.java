import java.awt.*;
import java.awt.image.BufferedImage;

public class Backgroundrenderer {
    private Color color;
    private int width;
    private int height;

    public Backgroundrenderer(int width, int height, Color color){
        this.width = width;
        this.height = height;
        this.color = color;

    }

    public void renderer(Graphics graphics,Vector2D position){
        graphics.setColor(Color.BLACK);
        graphics.fillRect((int)position.x,(int)position.y,1024,600);
    }

}
