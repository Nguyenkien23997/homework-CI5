package game.player;

import base.GameObject;
import base.Vector2D;
import physic.BoxCollider;
import renderer.PolygonRenderer;

import java.awt.*;

public class Player extends GameObject {

    public BoxCollider boxCollider;
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
        this.boxCollider = new BoxCollider(20,20);
    }

    @Override
    public void run() {
        super.run();
        this.playerMove.run(this);
        ((PolygonRenderer)this.renderer).angle = this.playerMove.angle;
        this.playerShoot.run(this);
        this.boxCollider.position.set(this.position);
    }

    public void getHit(){
        this.isAlive = false;
    }
}
