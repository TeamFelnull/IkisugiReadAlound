package red.felnull.irab.readaloud;

import am.ik.voicetext4j.Emotion;
import am.ik.voicetext4j.EmotionalSpeaker;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class ReadAloudListenerAdapter extends ListenerAdapter {
    @Override
    public void onMessageReceived(MessageReceivedEvent e) {


        if (e.getChannel().getIdLong() != 608914022883917824l || e.getMessage() == null || e.getAuthor().isBot())
            return;

        ReadAloundManager.getInstance().addRATrack(new ReadAloundTrack(EmotionalSpeaker.HIKARI, 100, Emotion.ANGER, Emotion.Level.HIGH, 100, e.getMessage().getContentRaw()));

//        PlayerManager.getInstance().loadAndPlay("D:\\本編\\太いシーチキンが欲しい.mp3");
//        PlayerManager.getInstance().getGuildMusicManager(e.getGuild()).player.setVolume(10);

    }
}
