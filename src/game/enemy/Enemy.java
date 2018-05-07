package game.enemy;

import base.GameObject;
import game.particle.Particle;
import physic.BoxCollider;
import physic.HitObject;
import physic.PhysicBody;
import renderer.ImageRenderer;

import java.awt.*;
import java.util.Random;

public class Enemy extends GameObject implements PhysicBody, HitObject {
    public EnemyMove enemyMove;
    public BoxCollider boxCollider;
    public Random random;

    public Enemy() {
        this.enemyMove = new EnemyMove();
        this.renderer = new ImageRenderer("resources/images/circle.png", 20, 20, Color.YELLOW);
        this.boxCollider = new BoxCollider(20, 20);
    }

    @Override
    public void run() {
        super.run();
        this.enemyMove.run(this);
        this.boxCollider.position.set(this.position);

    }

    @Override
    public void getHit(GameObject gameObject) {
        this.isAlive = false;
        if (this.isAlive == false){
            Particle.explostion(this.position,this.enemyMove.velocity.normalize().multiply(-50.0f),20,20,Color.WHITE,20,20);
        }
    }

    @Override
    public BoxCollider getBoxCollider() {
        return this.boxCollider;
    }
}
