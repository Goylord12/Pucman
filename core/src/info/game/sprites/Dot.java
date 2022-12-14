package info.game.sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

import java.util.ArrayList;

public class Dot {
    public static final int FLUCTUATION = 10;
    public static int DOTS_SIZE = 5;
    private Texture dot;
    private Vector2 posDot;
    private Rectangle dotCube;

    public static int getFLUCTUATION() {
        return FLUCTUATION;
    }

    public Texture getDot() {
        return dot;
    }

    public Vector2 getPosDot() {
        return posDot;
    }

    public Dot(float x, float y){
        dot = new Texture("Picture/dot.png");
        posDot = new Vector2(x, y);
        dotCube = new Rectangle(posDot.x, posDot.y, DOTS_SIZE, DOTS_SIZE);
    }

   public void reposition(){
        dotCube.setPosition(posDot.x, posDot.y);
    }

    public boolean collides(Rectangle player){
        return player.overlaps(dotCube);
    }

    public void dispose() {
        dot.dispose();

    }

}
