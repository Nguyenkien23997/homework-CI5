import java.awt.*;
import java.awt.image.BufferedImage;

public class Enemy extends GameObject{
    public EnemyShoot enemyShoot;
    public Vector2D velocity;
//    public BufferedImage image;
//    public int width;
//    public int height;

    public Enemy(){
        this.enemyShoot =  new EnemyShoot();
        this.velocity = new Vector2D();
        this.renderer = new ImageRenderer("resources/images/circle.png",20,20);
    }

    @Override
    public void run(){
        super.run();
        this.enemyShoot.run(this);
        this.position.addUp(this.velocity);
        this.enemyShoot.bulletEnemies.forEach(bulletEnemy -> bulletEnemy.run());

    }

    @Override
    public void render(Graphics graphics){
        super.render(graphics);
        this.enemyShoot.bulletEnemies.forEach(bulletEnemy -> bulletEnemy.render(graphics));
        this.renderer.render(graphics, this.position);
    }
}
