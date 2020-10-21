package red.felnull.irab.readaloud;

import red.felnull.irab.Main;
import red.felnull.irab.util.StringHelper;

import javax.sound.sampled.AudioFileFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import java.io.SequenceInputStream;
import java.util.*;

public class ReadAloundManager {
    private static ReadAloundManager INSTANCE;

    public final List<UUID> tracs = new ArrayList<>();
    public final Set<UUID> dwonloadnow = new HashSet<>();

    public static void init() {
        INSTANCE = new ReadAloundManager();
        System.setProperty("voicetext.apikey", "dy8n11mtlj97jis0");
    }

    public static ReadAloundManager getInstance() {
        return INSTANCE;
    }

    public void addRATrack(ReadAloundTrack track) {
        UUID uuid = UUID.randomUUID();
        tracs.add(uuid);
        downloadRAT(uuid, track);
    }

    public void downloadRAT(UUID uuid, ReadAloundTrack track) {
        dwonloadnow.add(uuid);
        try {
            String[] stars = StringHelper.split(199, track.getText());
            AudioInputStream stream = track.getSpeaker().ready().pitch(track.getPich()).speed(track.getSpeed()).emotion(track.getEmotion(), track.getEmotionLevel()).getResponse(stars[0]).audioInputStream();
            if (stars.length > 1) {
                for (int i = 1; i < stars.length; i++) {
                    AudioInputStream strea = track.getSpeaker().ready().pitch(track.getPich()).speed(track.getSpeed()).emotion(track.getEmotion(), track.getEmotionLevel()).getResponse(stars[i]).audioInputStream();
                    stream = new AudioInputStream(new SequenceInputStream(stream, strea), stream.getFormat(), stream.getFrameLength() + strea.getFrameLength());
                    Thread.sleep(100);
                }
            }
            AudioSystem.write(stream, AudioFileFormat.Type.WAVE, Main.tmpPath.resolve(uuid.toString() + ".wav").toFile());
        } catch (Exception e) {
            e.printStackTrace();
        }
        dwonloadnow.remove(uuid);
    }
}
