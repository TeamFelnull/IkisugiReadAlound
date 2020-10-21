package red.felnull.irab.command;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;
import net.dv8tion.jda.api.entities.VoiceChannel;
import net.dv8tion.jda.api.managers.AudioManager;
import red.felnull.irab.Main;

public class DisconnectsCommand extends Command {
    public DisconnectsCommand() {
        this.name = "otiro";
        this.help = "BOTをボイスチャットから切させます";
    }

    @Override
    protected void execute(CommandEvent e) {
        VoiceChannel chanel = e.getGuild().getMemberById(Main.botID).getVoiceState().getChannel();
        if (chanel == null) {
            e.reply("すでに切断しています");
            return;
        }
        AudioManager audioManager = e.getGuild().getAudioManager();
        audioManager.closeAudioConnection();
    }
}
