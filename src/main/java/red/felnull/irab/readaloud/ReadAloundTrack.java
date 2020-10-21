package red.felnull.irab.readaloud;

import am.ik.voicetext4j.Emotion;
import am.ik.voicetext4j.EmotionalSpeaker;

public class ReadAloundTrack {
    private final EmotionalSpeaker speaker;
    private final int pich;
    private final Emotion emotion;
    private final Emotion.Level emotionLevel;
    private final int speed;
    private final String text;

    public ReadAloundTrack(EmotionalSpeaker speakerType, int pitch, Emotion emotion, Emotion.Level emotionLevel, int speed, String text) {
        this.speaker = speakerType;
        this.pich = pitch;
        this.emotion = emotion;
        this.emotionLevel = emotionLevel;
        this.speed = speed;
        this.text = text;
    }

    public EmotionalSpeaker getSpeaker() {
        return speaker;
    }

    public int getPich() {
        return pich;
    }

    public Emotion getEmotion() {
        return emotion;
    }

    public Emotion.Level getEmotionLevel() {
        return emotionLevel;
    }

    public int getSpeed() {
        return speed;
    }

    public String getText() {
        return text;
    }


}
