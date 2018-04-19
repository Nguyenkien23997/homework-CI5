import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Window extends JFrame {

    private Game game;
    private long lastTime = 0;

    public Window(){
        this.setSize(1024,600);
        this.setupGame();
        this.eventKeyboard();
        this.windowEvent();
        this.setVisible(true);
    }

    private void setupGame(){
        this.game = new Game();
        this.add(this.game);
    }

    private void eventKeyboard(){
        this.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent keyEvent) {

            }

            @Override
            public void keyPressed(KeyEvent keyEvent) {
                if (keyEvent.getKeyCode() == keyEvent.VK_LEFT){
//                        game.player.
                }
                if (keyEvent.getKeyCode() == keyEvent.VK_RIGHT){
//                        game.player.angle = -5.0;
                }
            }

            @Override
            public void keyReleased(KeyEvent keyEvent) {
                if (keyEvent.getKeyCode() == keyEvent.VK_LEFT){
//                        game.player.angle = 0.0;
                }
                if (keyEvent.getKeyCode() == keyEvent.VK_RIGHT){
//                        game.player.angle = 0.0;
                }
            }
        });
    }
    private void windowEvent(){
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent windowEvent) {
                System.exit(1);
            }
        });
    }

    public void gameLoop(){
        while (true){
            long currentTime = System.nanoTime();
            if (currentTime - lastTime >= 17_000_000){
                this.game.runAll();
                this.game.renderAll();
                this.lastTime = currentTime;
            }
        }
    }
}
