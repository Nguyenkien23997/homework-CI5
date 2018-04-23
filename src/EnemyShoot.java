import java.util.ArrayList;
import java.util.List;

public class EnemyShoot {
    public List<BulletEnemy> bulletEnemies;
    private FrameCounter frameCounter;


    public EnemyShoot() {
        this.bulletEnemies = new ArrayList<>();
        this.frameCounter = new FrameCounter(100);
    }

    public void run(Enemy enemy) {

        if (this.frameCounter.run()) {
            for (int i = 0; i < 20; i++) {
                BulletEnemy bulletEnemy = new BulletEnemy();
                bulletEnemy.position.set(enemy.position);
                bulletEnemy.velocity.set((new Vector2D(20, 0)).rotate(i * 50));
                this.bulletEnemies.add(bulletEnemy);
                this.frameCounter.reset();
            }
        }
    }
}
