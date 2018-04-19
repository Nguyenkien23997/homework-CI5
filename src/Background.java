import java.awt.*;

public class Background {
    private Backgroundrenderer renderer;
    public Vector2D position;

    public Background(){
       this.position = new Vector2D();
       this.renderer = new Backgroundrenderer(1024, 600,Color.BLACK);

    }

    public void render(Graphics graphics){
        this.renderer.renderer(graphics, this.position);
    }
}
