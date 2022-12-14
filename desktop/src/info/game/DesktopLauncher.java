package info.game;

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;

public class DesktopLauncher {
    public static void main(String[] arg) {
        Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();
        config.setForegroundFPS(60);
        config.setTitle(PacManGame.TITLE);
        config.setForegroundFPS(60);
        config.setWindowedMode(PacManGame.WIDTH, PacManGame.HEIGHT);
        config.setResizable(false);
        config.setWindowIcon(PacManGame.ICON);
        new Lwjgl3Application(new PacManGame(), config);
    }
}
