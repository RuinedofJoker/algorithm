package gof23.structural_patterns.adapter.example1.media_player;

import gof23.structural_patterns.adapter.example1.adapter.MediaAdapter;

public class AudioPlayer implements MediaPlayer{

    MediaAdapter mediaAdapter;

    @Override
    public void play(String audioType, String fileName) {
        if ("mp3".equals(audioType)) {
            System.out.println("mp3,启动...");
        }else if ("vlc".equals(audioType) || "mp4".equals(audioType)) {
            mediaAdapter = new MediaAdapter(audioType);
            mediaAdapter.play(audioType, fileName);
        }else {
            System.out.println("不支持该类型的播放器...");
        }
    }
}
