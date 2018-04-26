package game.star;

import base.FrameCounter;
import base.GameObject;
import base.GameObjectManager;

import java.util.Random;

public class StarSqwaner extends GameObject {

    private Random random = new Random();
    private FrameCounter frameCounter = new FrameCounter(30);

    @Override
    public void run() {
        super.run();
        if (this.frameCounter.run()) {
            Star star = new Star();
            star.position.set(1024, this.random.nextInt(600));
            star.velocity.set(this.random.nextInt(2) + 1, 0);
            GameObjectManager.instance.add(star);
            this.frameCounter.reset();
        }
    }
}
