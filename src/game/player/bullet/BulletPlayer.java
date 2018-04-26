package game.player.bullet;

import base.GameObject;
import base.GameObjectManager;
import base.Vector2D;
import game.enemy.Enemy;
import physic.BoxCollider;
import renderer.ImageRenderer;

public class BulletPlayer extends GameObject {

    public Vector2D velocity;
    public BoxCollider boxCollider;

    public BulletPlayer() {
        this.velocity = new Vector2D();
        this.renderer = new ImageRenderer("resources/images/star.png", 5, 5);
        this.boxCollider = new BoxCollider(5, 5);
    }

    @Override
    public void run() {
        super.run();
        this.position.addUp(this.velocity);
        this.boxCollider.position.set(this.position);
        this.checkCollision();
    }

    private void checkCollision() {
        Enemy enemy = GameObjectManager.instance.checkCollision(this.boxCollider);
        if (enemy != null) {
            enemy.getHit();
            this.getHit();
        }
    }

    private void getHit() {
        System.out.println("Hit Enemy");
        this.isAlive = false;
    }

}
