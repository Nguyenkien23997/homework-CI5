import java.awt.*;

public class Shoot extends GameObject {

    public Vector2D velocity;


    public Shoot() {

        this.velocity = new Vector2D();
        this.renderer = new ImageRenderer("resources/images/circle.png", 5, 5);
    }

    public void run() {
        this.position.addUp(this.velocity);
    }

    public void render(Graphics graphics) {
        super.run();
        this.position.addUp(this.velocity);
    }
}
