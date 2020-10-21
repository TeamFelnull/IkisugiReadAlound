package red.felnull.irab.readaloud;

import red.felnull.irab.Main;
import red.felnull.irab.audio.PlayerManager;

import javax.sound.sampled.AudioSystem;
import java.nio.file.Path;
import java.util.UUID;

public class ReadAloundHandler {
    private static long cooldwon = 0;
    private static long lasttime;

    public static void loop() {
        if (ReadAloundManager.getInstance().tracs.size() != 0) {
            UUID luuid = ReadAloundManager.getInstance().tracs.get(0);
            if (!ReadAloundManager.getInstance().dwonloadnow.contains(luuid)) {
                if (cooldwon <= 0) {
                    Path path = Main.tmpPath.resolve(luuid.toString() + ".wav");
                    PlayerManager.getInstance().loadAndPlay(path.toString());
                    try {
                        cooldwon = AudioSystem.getAudioFileFormat(path.toFile()).getFrameLength();
                        PlayerManager.getInstance().getGuildMusicManager(Main.jda.getGuildById(600929948529590272l)).player.setVolume(100);
                    } catch (Exception ex) {
                    }
                    ReadAloundManager.getInstance().tracs.remove(0);
                }
            }
        }
        if (lasttime == 0) {
            lasttime = System.currentTimeMillis();
        } else {
            if (cooldwon > 0) {
                cooldwon = cooldwon - (System.currentTimeMillis() - lasttime);
            }
        }
        if (cooldwon < 0) {
            cooldwon = 0;
        }
    }
}
