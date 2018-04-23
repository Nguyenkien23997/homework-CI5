import java.awt.*;
import java.awt.image.BufferedImage;

public class Backgroundrenderer implements Renderer{
    private Color color;
    private int width;
    private int height;

    public Backgroundrenderer(int width, int height, Color color){
        this.width = width;
        this.height = height;
        this.color = color;

    }

    @Override
    public void render(Graphics graphics, Vector2D position) {
        graphics.setColor(this.color);
        graphics.fillRect((int)position.x,(int)position.y,this.width,this.height);
    }
}
