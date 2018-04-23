import java.awt.*;

public class Player extends GameObject{


    public PlayerMove playerMove;
    public PlayerShoot playerShoot;

    public Player() {
        this.position = new Vector2D();
        this.renderer = new PolygonRenderer(Color.RED,
                new Vector2D(),
                new Vector2D(0, 16),
                new Vector2D(20, 8)
        );
        this.playerMove = new PlayerMove();
        this.playerShoot = new PlayerShoot();
    }

    @Override
    public void run() {
        super.run();
        this.playerShoot.run(this);
        this.playerShoot.shoots.forEach(shoot -> shoot.run());
        this.playerMove.run(this);
        ((PolygonRenderer)this.renderer).angle = this.playerMove.angle;
    }

    @Override
    public void render(Graphics graphics) {
        super.render(graphics);
        this.playerShoot.shoots.forEach(shoot -> shoot.render(graphics));
    }
}
