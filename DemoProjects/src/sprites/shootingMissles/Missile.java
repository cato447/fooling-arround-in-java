package sprites.shootingMissles;

public class Missile extends Sprite {

    private final int MISSILE_SPEED = 2;
    private final int FRAME_WIDTH = 400;

    public Missile(int x, int y) {
        super(x, y);

        initMissile();
    }

    private void initMissile() {
        loadImage("DemoProjects/res/laser.png",100,10);
    }

    public void move() {

        x += MISSILE_SPEED;

        if (x > FRAME_WIDTH) {
            visible = false;
        }
    }
}