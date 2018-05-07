package game.player;

import base.GameObject;
import base.Vector2D;
import game.enemy.Enemy;
import game.particle.Particle;
import physic.BoxCollider;
import physic.HitObject;
import physic.PhysicBody;
import physic.RunHitObject;
import renderer.PolygonRenderer;

import java.awt.*;

public class Player extends GameObject implements PhysicBody, HitObject {

    public PlayerMove playerMove;
    public PlayerShoot playerShoot;
    private RunHitObject runHitObject;
    private BoxCollider boxCollider;

    public Player() {
        this.position = new Vector2D();
        this.renderer = new PolygonRenderer(Color.RED,
                new Vector2D(),
                new Vector2D(0, 16),
                new Vector2D(20, 8)
        );
        this.playerMove = new PlayerMove();
        this.playerShoot = new PlayerShoot();
        this.boxCollider = new BoxCollider(20, 16);
        this.runHitObject = new RunHitObject(
                Enemy.class
        );
    }

    @Override
    public void run() {
        super.run();
        this.playerMove.run(this);
        this.boxCollider.position.set(this.position.x - 10, this.position.y - 8);
        ((PolygonRenderer) this.renderer).angle = this.playerMove.angle;
        this.playerShoot.run(this);
        this.runHitObject.run(this);
        Particle.effectSmoke(this.position, this.playerMove.velocity.normalize().multiply(-3.5f), 10, 10, Color.ORANGE, 7, 15);

    }

    @Override
    public void getHit(GameObject gameObject) {
        this.isAlive = false;
        if (isAlive == false){
            Particle.explostion(this.position,this.playerMove.velocity.normalize().multiply(-50.0f),20,20,Color.WHITE,20,20);
        }
    }

    @Override
    public BoxCollider getBoxCollider() {
        return this.boxCollider;
    }
}
