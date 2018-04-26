package game.enemy;

import base.GameObject;
import base.GameObjectManager;
import game.player.Player;
import physic.BoxCollider;
import renderer.ImageRenderer;

public class Enemy extends GameObject {
    public EnemyShoot enemyShoot;
    public EnemyMove enemyMove;
    public BoxCollider boxCollider;

    public Enemy() {
        this.enemyShoot = new EnemyShoot();
        this.enemyMove = new EnemyMove();
        this.renderer = new ImageRenderer("resources/images/circle.png", 20, 20);
        this.boxCollider = new BoxCollider(20, 20);
    }

    @Override
    public void run() {
        super.run();
        this.enemyShoot.run(this);
        this.enemyMove.run(this);
        this.boxCollider.position.set(this.position);
        this.Collision();
    }

    private void Collision() {
        Player player = GameObjectManager.instance.Collision(this.boxCollider);
        if(player != null){
            player.getHit();
            this.getHit();
        }
    }

    public void getHit(){
        this.isAlive = false;
    }
}
