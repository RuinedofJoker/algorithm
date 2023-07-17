package gof23.structural_patterns.adapter.example1.adapter;

import gof23.structural_patterns.adapter.example1.media_player.AdvancedMediaPlayer;
import gof23.structural_patterns.adapter.example1.media_player.MediaPlayer;
import gof23.structural_patterns.adapter.example1.media_player.Mp4Player;
import gof23.structural_patterns.adapter.example1.media_player.VlcPlayer;

public class MediaAdapter implements MediaPlayer {

    AdvancedMediaPlayer mediaPlayer;

    public MediaAdapter(String audioType) {
        if ("vlc".equals(audioType)) {
            mediaPlayer = new VlcPlayer();
        }else if ("mp4".equals(audioType)) {
            mediaPlayer = new Mp4Player();
        }else {
            throw new RuntimeException("没有该类型播放器...");
        }
    }

    @Override
    public void play(String audioType, String fileName) {
        if ("vlc".equals(audioType)) {
            mediaPlayer.playVlc(fileName);
        }else if ("mp4".equals(audioType)) {
            mediaPlayer.playMp4(fileName);
        }else {
            throw new RuntimeException("没有该类型播放器...");
        }
    }
}
