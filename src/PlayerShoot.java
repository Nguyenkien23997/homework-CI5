import java.util.ArrayList;
import java.util.List;

public class PlayerShoot {

    public List<Shoot> shoots;
    public boolean isPlayerShoot = false;
    private FrameCounter frameCounter;

    public PlayerShoot() {
        this.shoots = new ArrayList<>();
        this.frameCounter = new FrameCounter(10);
    }

    public void run(Player player) {
        if (this.isPlayerShoot) {
            if (this.frameCounter.run()) {
                Shoot shoot = new Shoot();
                shoot.position.set(player.position);
                shoot.velocity.set((new Vector2D(20, 0)).rotate(player.playerMove.angle));
                this.shoots.add(shoot);

                this.frameCounter.reset();

            }

        }else {
            this.frameCounter.reset();
        }
    }
}