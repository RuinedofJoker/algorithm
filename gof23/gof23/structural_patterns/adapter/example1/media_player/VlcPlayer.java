package gof23.structural_patterns.adapter.example1.media_player;

public class VlcPlayer implements AdvancedMediaPlayer{
    @Override
    public void playVlc(String fileName) {
        System.out.println("Vlc,启动...");
    }

    @Override
    public void playMp4(String fileName) {
        //什么也不做
    }
}
