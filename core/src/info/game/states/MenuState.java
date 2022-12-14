package info.game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import info.game.PacManGame;
import jdk.internal.org.jline.terminal.MouseEvent;

public class MenuState extends State {
    private Texture background;
    private Texture button;

    public MenuState(GameStateManager gsm) {
        super(gsm);
        background = new Texture("Picture/background.jpg");
        button = new Texture("Picture/button.png");
    }

    @Override
    protected void handleInput() {
        if (Gdx.input.justTouched()) {
            gsm.set((new PlayState(gsm)));
            PacManGame.MUSIC = "STOP";
        }


    }


    @Override
    public void update(float dt) {
        handleInput();
    }

    @Override
    public void render(SpriteBatch sb) {
        sb.begin();
        sb.draw(background, 0, 0, PacManGame.WIDTH, PacManGame.HEIGHT);
        sb.draw(button, PacManGame.WIDTH / 2 - 130, PacManGame.HEIGHT - 150, 260, 97);
        sb.end();


    }

    @Override
    public void dispose() {
        background.dispose();
        button.dispose();

    }
}
