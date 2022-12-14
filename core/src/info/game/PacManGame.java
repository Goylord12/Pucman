package info.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.ScreenUtils;

import java.awt.Rectangle;
import java.util.Iterator;
import java.util.TreeMap;

import info.game.sprites.Animation;
import info.game.sprites.Ghost;
import info.game.sprites.PacMan;
import info.game.states.GameOver;
import info.game.states.GameStateManager;
import info.game.states.MenuState;
import info.game.states.PlayState;

public class PacManGame extends ApplicationAdapter {
    public static final int WIDTH = 825;
    public static final int HEIGHT = 525;
    public static final int SPEED = 2;
    public static final float VOLUME = 0f;
    public static final String TITLE = "Pac-Man";
    public static final String ICON = "Picture/icon.png";
    private GameStateManager gsm;
    private SpriteBatch batch;
    private Music music;
    private Music musicEnd;
    public static String MUSIC = "ONE";


    @Override
    public void create() {
        batch = new SpriteBatch();
        gsm = new GameStateManager();
        music = Gdx.audio.newMusic((Gdx.files.internal("Sound/pacman_beginning.mp3")));
        musicEnd = Gdx.audio.newMusic((Gdx.files.internal("Sound/pacman_death.mp3")));
        music.setLooping(true);
        music.setVolume(VOLUME);
        musicEnd.setVolume(VOLUME);
        musicEnd.stop();
        music.play();
        Gdx.gl.glClearColor(1, 0, 0, 1);
        gsm.push(new MenuState(gsm));
    }

    public void render() {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        if (MUSIC.equals("STOP")) {
            music.stop();
        } else if (MUSIC.equals("TWO")) {
            music.stop();
            music.setLooping(false);
            musicEnd.play();
            MUSIC = "STOP";
        } else if (MUSIC.equals("ONE")) {
            musicEnd.stop();
            music.setLooping(true);
            music.play();
        }


        gsm.update(Gdx.graphics.getDeltaTime());
        gsm.render(batch);

    }

    public void dispose() {
        super.dispose();
        music.dispose();
        musicEnd.dispose();

    }

}

