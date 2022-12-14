package info.game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import info.game.PacManGame;

public class GameOver extends State {
    private Texture background;
    private Texture gameOver;

    public GameOver(GameStateManager gsm) {
        super(gsm);
        background = new Texture("Picture/background.jpg");
        gameOver = new Texture("Picture/gameOver.png");
    }

    @Override
    protected void handleInput() {
        if (Gdx.input.justTouched()) {
            gsm.set((new PlayState(gsm)));
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
        sb.draw(gameOver, PacManGame.WIDTH / 2 - 130, PacManGame.HEIGHT - 150, 260, 97);
        sb.end();


    }

    @Override
    public void dispose() {
        background.dispose();
        gameOver.dispose();

    }
}
