import com.gameengine.main.Game;
import com.gameengine.main.util.RendererVariables;

import java.awt.*;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main extends Game {
    public Main(String gameName) {
        super(gameName);
        createWindow(800, 600);
        start();
        RendererVariables.ANTIALIASING = RenderingHints.VALUE_ANTIALIAS_ON;
        getUpdater().setURL("https://github.com/Vidrolll/Game-Engine2D/raw/master/Game%20Engine.jar");
        getUpdater().checkForUpdates();
    }

    public static void main(String[] args) {
        new Main("Test Game");
    }

    @Override
    public void drawForeground(Graphics2D g) {
        g.setColor(Color.BLACK);
        g.fillRect(50, 50, 50, 50);
    }
}