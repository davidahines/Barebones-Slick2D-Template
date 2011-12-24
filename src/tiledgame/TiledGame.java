package tiledgame;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;
/**
 * @author HadesVine
 */
public class TiledGame extends BasicGame {

    private GameContainer gc;
    private float moveSpeed = 1;
    private int WIDTH = 1024;
    private int HEIGHT = 768;
    private Image snakeSprite;
    private Image mouseSprite;
    private Image emptyTile;
    private Point mousePoint;
    public static final int UP = 0;
    public static final int RIGHT = 1;
    public static final int DOWN = 2;
    public static final int LEFT = 3;
    private int snakeFacing = 1;
    private SpriteSheet sprites;
    private List<Point> snakeBody = new ArrayList<Point>();
    public TiledGame() {
        super("Snake Game");
    }

    public static void main(String[] args) throws SlickException {
        AppGameContainer app = new AppGameContainer(new TiledGame());
        app.setDisplayMode(1024, 768, false);
        app.setTargetFrameRate(60);
        app.setFullscreen(true);
        app.start();
    }

    @Override 
    public void init(GameContainer gc) throws SlickException {
        sprites = new SpriteSheet("com/hadesvine/tiledgame/tiles/snake_tileset.png", 32, 32,new Color(255,0,176));
        emptyTile = sprites.getSprite(0, 0);
        snakeSprite = sprites.getSprite(1, 0);
        mouseSprite = sprites.getSprite(2, 0);
    }

    @Override
    public void update(GameContainer gc, int delta) throws SlickException {
        float rate = delta / 10f;
        updateSnakeDirection(gc);
        switch (snakeFacing) {
            case 1:  monthString = "January";
                     break;
            case 2:  monthString = "February";
                     break;
            case 3:  monthString = "March";
                     break;
            case 4:  monthString = "April";
                     break;
        }
    }

    private void updateSnakeDirection(GameContainer gc) {
        Input input = gc.getInput();
        if (input.isKeyDown(Input.KEY_W)) {
            snakeFacing = UP;
        }
        if (input.isKeyDown(Input.KEY_D)) {
            snakeFacing = RIGHT;
        }
        if (input.isKeyDown(Input.KEY_S)) {
            snakeFacing = DOWN;
        }
        if (input.isKeyDown(Input.KEY_A)) {
            snakeFacing = LEFT;
        }
    }

    @Override
    public void render(GameContainer gc, Graphics g) throws SlickException {

    }
}
