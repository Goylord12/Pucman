package info.game.states;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;

public abstract class State {
    protected OrthographicCamera camera; // камера окно
    protected Vector3 keyboard; //
    protected GameStateManager gsm; // управляет окнами

    public State(GameStateManager gsm) {
        this.gsm = gsm;
        camera = new OrthographicCamera();
        keyboard = new Vector3();
    }

    protected abstract void handleInput(); // опрашивает пользовательский ввод

    public abstract void update(float dt); // обновление картинки

    public abstract void render(SpriteBatch sb); // предоставляет дял рисования

    public abstract void dispose(); // удаляет текстуры
}
