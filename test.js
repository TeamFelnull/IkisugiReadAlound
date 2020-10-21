var tts    = WScript.CreateObject("SAPI.SpVoice");
var stream = WScript.CreateObject("SAPI.SpFileStream");


// ストリームを開いて
stream.open( "fuga.wav", 3 );

// TTSの読み上げ先をストリームにセット
tts.AudioOutputStream = stream;

// しゃべる（WAVに書き込みされる）
tts.Speak("Hello world! Konnichiwa!");
tts.Speak("I think that that that that that boy wrote is wrong."); // 英語の早口言葉

// ストリームを閉じる
stream.close();