package red.felnull.irab;

import com.jagrosh.jdautilities.command.CommandClient;
import com.jagrosh.jdautilities.command.CommandClientBuilder;
import net.dv8tion.jda.api.AccountType;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;
import red.felnull.irab.audio.PlayerManager;
import red.felnull.irab.command.CallCommand;
import red.felnull.irab.command.DisconnectsCommand;
import red.felnull.irab.readaloud.ReadAloudListenerAdapter;
import red.felnull.irab.readaloud.ReadAloundHandler;
import red.felnull.irab.readaloud.ReadAloundManager;

import javax.security.auth.login.LoginException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {
    public static JDA jda;
    public static final String botID = "767708881316610079";
    public static final String botTaken = "nna-";
    public static final Path tmpPath = Paths.get("tmp");

    public static void main(String[] args) throws LoginException {
        tmpPath.toFile().mkdirs();
        PlayerManager.init();
        ReadAloundManager.init();
        loopStart();


        // AudioInputStream stream = EmotionalSpeaker.BEAR.ready().pitch(105).speed(105).sad().getResponse("やったぜ。　投稿者：変態糞土方 (8月16日（水）07時14分22秒)昨日の8月15日にいつもの浮浪者のおっさん（60歳）と先日メールくれた汚れ好きの土方のにいちゃん（45歳）とわし（53歳）の3人で県北にある川の土手の下で盛りあったぜ").audioInputStream();
        //   AudioSystem.write(stream, AudioFileFormat.Type.WAVE, Paths.get("test.wav").toFile());


        CommandClient commandClient = new CommandClientBuilder()
                .setPrefix("!1919")
                .setStatus(OnlineStatus.ONLINE)
                .setActivity(Activity.watching("本編"))
                .setOwnerId("328520268274204673")
                .addCommands(new CallCommand(), new DisconnectsCommand())
                .build();

        jda = new JDABuilder(AccountType.BOT)
                .setToken(botTaken)
                .addEventListeners(commandClient)
                .addEventListeners(new ReadAloudListenerAdapter())
                .build();

    }

    public static void loopStart() {
        LoopThread lt = new LoopThread();
        lt.start();
    }
}

class LoopThread extends Thread {
    @Override
    public void run() {
        while (true) {
            try {
                sleep(100);
            } catch (InterruptedException e) {
            }
            ReadAloundHandler.loop();
        }
    }
}