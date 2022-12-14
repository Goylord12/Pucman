package info.game.sprites;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;

import info.game.PacManGame;
import info.game.states.PlayState;

public class PacMan {
    private Vector3 position;
    private Texture pacManRight;
    private Texture pacManLeft;
    private Texture pacManUp;
    private Texture pacManDown;
    private Rectangle pacManCube;
    private Animation pacManAnimation;
    public static float counterAnimation = 0.0f;


    public TextureRegion getPacManLeft() {

        if(counterAnimation == 1.5f) counterAnimation = 0.0f; // Обнуление, когда одна ориентация
        if(counterAnimation == 0.0f)pacManAnimation =new Animation(new TextureRegion(pacManLeft), 3, 0.5f);
        counterAnimation += 0.1f;
        return pacManAnimation.getFrame();
    }
    public TextureRegion getPacManRight() {
        if(counterAnimation == 1.5f) counterAnimation = 0.0f;
        if(counterAnimation == 0.0f)pacManAnimation =new Animation(new TextureRegion(pacManRight), 3, 0.5f);
        counterAnimation += 0.1f;
        return pacManAnimation.getFrame();
    }
    public TextureRegion getPacManUp() {
        if(counterAnimation == 1.5f) counterAnimation = 0.0f;
        if(counterAnimation == 0.0f)pacManAnimation =new Animation(new TextureRegion(pacManUp), 3, 0.5f);
        counterAnimation += 0.1f;
        return pacManAnimation.getFrame();
    }
    public TextureRegion getPacManDown() {
        if(counterAnimation == 1.5f) counterAnimation = 0.0f;
        if(counterAnimation == 0.0f)pacManAnimation =new Animation(new TextureRegion(pacManDown), 3, 0.5f);
        counterAnimation += 0.1f;
        return pacManAnimation.getFrame();
    }

    public PacMan(int x, int y) {
        position = new Vector3(x/ 2 - 35 / 2, 208, 0);
        pacManLeft = new Texture("Picture/leftFullPacMan.png");
        pacManRight = new Texture("Picture/rightFullPacMan.png");
        pacManUp = new Texture("Picture/upFullPacMan.png");
        pacManDown = new Texture("Picture/downFullPacMan.png");

        switch (PlayState.pacManOrin) {
            case "LEFT":
                pacManAnimation =new Animation(new TextureRegion(pacManLeft), 3, 0.5f);
                break;
            case "RIGHT":
                pacManAnimation =new Animation(new TextureRegion(pacManRight), 3, 0.5f);
                break;
            case "UP":
                pacManAnimation =new Animation(new TextureRegion(pacManUp), 3, 0.5f);
                break;
            case "DOWN":
                pacManAnimation =new Animation(new TextureRegion(pacManDown), 3, 0.5f);
                break;
        }
        pacManCube = new Rectangle(x/ 2 - 35 / 2, 208,35, 35);
    }

    public Vector3 getPosition() {
        return position;
    }
    public Rectangle getPacManCube(){
        return pacManCube;
    }


    public void update(float dt) {
        pacManAnimation.update(dt);

        if (position.x < 265) {
            position.x = 265;
        }
        if (position.x > 560-35) {
            position.x = 560-35;
        }
        if (position.y < 175-35) {
            position.y = 175-35;
        }
        if (position.y > 382-35) {
            position.y = 382-35;
        }

/////
        if (position.y > 242 && position.x < 523 && position.x > 267 && position.y < 346) {
            position.y = 346;
        }
        else if (position.y < 242 && position.x < 523 && position.x > 267 & position.y > 207) {
            position.y = 207;
        }

        if (position.y < 343 && position.y > 208 && position.x > 266 && position.x < 348) {
            position.x = 265;
        }
        else if (position.y < 343 && position.y > 208 && position.x < 524 && position.x > 477) {
            position.x = 525;
        }
/////

        if (position.y > 176 && position.x < 523 && position.x > 267 && position.y < 208) {
            position.y = 207;
        }
        else if (position.y < 176 && position.x < 523 && position.x > 267 & position.y > 139) {
            position.y = 139;
        }
        if (position.y < 204 && position.y > 140  && position.x > 266 && position.x < 348) {
            position.x = 265;
        }
        else if (position.y < 204 && position.y > 140 && position.x < 524 && position.x > 477) {
            position.x = 525;
        }


//////
        if (position.y > 80 && position.x < 415 && position.x > 355 && position.y < 160) {
            position.x = 355;
        }
        else if (position.y > 80 && position.x < 435 && position.x > 415 && position.y < 160) {
            position.x = 435;
        }


        pacManCube.setPosition(position.x, position.y);

    }


    public void moveLeft() {
        position.x -= PacManGame.SPEED;

    }

    public void moveRight() {

        position.x += PacManGame.SPEED;
    }

    public void moveUp() {

        position.y += PacManGame.SPEED;
    }

    public void moveDown() {

        position.y -= PacManGame.SPEED;
    }


    public void dispose() {
        pacManLeft.dispose();
        pacManRight.dispose();
        pacManUp.dispose();
        pacManDown.dispose();
    }
}
