package audio;

import javafx.application.Application;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

import java.io.File;

public class PlayMp3JavaFX extends Application {
    @Override
    public void start(Stage stage) {
        String path = "c:\\Users\\saran\\Downloads\\Gulabi Saawariya Ek Chatur Naar 320 Kbps.mp3";
        Media media = new Media(new File(path).toURI().toString());
        MediaPlayer player = new MediaPlayer(media);
        player.play();

        System.out.println("Playing MP3 with JavaFX...");
    }

    public static void main(String[] args) {
        launch(args);
    }
}
