package info.game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Array;

import java.util.ArrayList;

import info.game.PacManGame;

import info.game.sprites.Dot;
import info.game.sprites.Ghost;
import info.game.sprites.PacMan;

public class PlayState extends State {

    private PacMan pacMan;
    private Texture bg;
    private Ghost ghost;
    public static String pacManOrin = "RIGHT";
    public static int SPACING = 15;
    public static int DOTS_COUNT = 100;
    private Music musicGame;
    private Sound sound;
    private Dot dot;
    private Array<Dot> dots;


    public PlayState(GameStateManager gsm) {
        super(gsm);
        pacMan = new PacMan(825, 25); // позиция
        bg = new Texture("Picture/playBackground.jpg");
        sound = Gdx.audio.newSound((Gdx.files.internal("Sound/pacman_chomp.wav")));
        musicGame = Gdx.audio.newMusic((Gdx.files.internal("Sound/game.mp3")));
        musicGame.setLooping(true);
        musicGame.setVolume(PacManGame.VOLUME);
        ghost = new Ghost(PacManGame.WIDTH / 2 - 35 / 2, 275);
        dots = new Array<Dot>();
        for (int i = 0; i < DOTS_COUNT; i++) {
            if (i < 15) {
                dots.add(new Dot(278, i * SPACING + Dot.DOTS_SIZE + 150));
            } else if (i >= 15 && i < 32) {
                dots.add(new Dot(i * SPACING + Dot.DOTS_SIZE + 65, 366));
            } else if (i >= 32 && i < 46) {
                dots.add(new Dot(535, 833 - (i * SPACING)));
            } else if (i >= 47 && i < 63) {
                dots.add(new Dot(i * SPACING + Dot.DOTS_SIZE - 415, 215));
            } else if (i >= 63 && i < 70) {
                dots.add(new Dot(i * SPACING + Dot.DOTS_SIZE - 660, 155));
            } else if (i >= 70 && i < 76) {
                dots.add(new Dot(i * SPACING + Dot.DOTS_SIZE - 610, 155));
            }
        }
    }

    @Override
    protected void handleInput() {
        // Обнуление counterAnimation, при нажатие (не удерживание) кнопки
        if(Gdx.input.isKeyJustPressed(Input.Keys.LEFT) || Gdx.input.isKeyJustPressed(Input.Keys.RIGHT) || Gdx.input.isKeyJustPressed(Input.Keys.UP) || Gdx.input.isKeyJustPressed(Input.Keys.DOWN)){
            PacMan.counterAnimation = 0.0f; //Обнуление счетчика, когда меняется ориентация
        }
        if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            pacManOrin = "LEFT";
            pacMan.moveLeft();


        }
        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            pacManOrin = "RIGHT";
            pacMan.moveRight();

        }
        if (Gdx.input.isKeyPressed(Input.Keys.UP)) {
            pacManOrin = "UP";
            pacMan.moveUp();

        }
        if (Gdx.input.isKeyPressed(Input.Keys.DOWN)) {
            pacManOrin = "DOWN";
            pacMan.moveDown();

        }

    }

        @Override
    public void update(float dt) {
        handleInput();
        pacMan.update(dt);

        for (int i = 0; i < 100; i++) {
            ghost.reposition();
        }

        for (Dot dot : dots) {
            if (dot.collides(pacMan.getPacManCube())) {
                dot.dispose();
                //sound.play(0.01f);
            }
        }

        if (ghost.collides(pacMan.getPacManCube())) {
            PacManGame.MUSIC = "TWO";
            musicGame.stop();
            gsm.set((new GameOver(gsm)));
        }


    }

    @Override
    public void render(SpriteBatch sb) {
        // sb.setProjectionMatrix(camera.combined);
        sb.begin();
        musicGame.play();
        sb.draw(bg, 0, 0); // фон для второго экрана
        for (Dot dot : dots) {
            sb.draw(dot.getDot(), dot.getPosDot().x, dot.getPosDot().y);
        }

        switch (pacManOrin) {
            case "RIGHT":

                sb.draw(pacMan.getPacManRight(), pacMan.getPosition().x, pacMan.getPosition().y);

                break;
            case "LEFT":
                sb.draw(pacMan.getPacManLeft(), pacMan.getPosition().x, pacMan.getPosition().y);

                break;
            case "UP":
                sb.draw(pacMan.getPacManUp(), pacMan.getPosition().x, pacMan.getPosition().y);
                break;
            case "DOWN":
                sb.draw(pacMan.getPacManDown(), pacMan.getPosition().x, pacMan.getPosition().y);
                break;
        }

        sb.draw(ghost.getGhostOne(), ghost.getPosGhostOne().x, ghost.getPosGhostOne().y);
        sb.end();

    }

    @Override
    public void dispose() {
        bg.dispose();
        sound.dispose();
        pacMan.dispose();
        ghost.dispose();
        for (Dot dot : dots) {
            dot.dispose();

        }
    }
}
