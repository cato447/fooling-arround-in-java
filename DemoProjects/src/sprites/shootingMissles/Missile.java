package sprites.shootingMissles;

public class Missile extends Sprite {

    private final int BOARD_WIDTH = 390;
    private final int MISSILE_SPEED = 2;

    public Missile(int x, int y) {
        super(x, y);

        initMissile();
    }

    private void initMissile() {
        loadImage("/home/bitecoding/Pictures/laser.png",35,35);
        getImageDimensions();
    }

    public void move() {

        y -= MISSILE_SPEED;

        if (y < 0) {
            visible = false;
        }
    }
}