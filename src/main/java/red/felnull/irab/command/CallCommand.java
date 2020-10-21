package red.felnull.irab.command;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;
import net.dv8tion.jda.api.entities.VoiceChannel;
import net.dv8tion.jda.api.managers.AudioManager;

public class CallCommand extends Command {
    public CallCommand() {
        this.name = "call";
        this.help = "BOTをボイスチャットに呼び出す";
    }

    @Override
    protected void execute(CommandEvent e) {
        VoiceChannel chanel = e.getMember().getVoiceState().getChannel();
        if (chanel == null) {
            e.reply("ボイスチャットに入ってから打ってください");
            return;
        }
        AudioManager audioManager = e.getGuild().getAudioManager();
        if (audioManager.isAttemptingToConnect()) {
            e.reply("すでに接続しようとしています");
            return;
        }
        audioManager.openAudioConnection(chanel);
    }
}
