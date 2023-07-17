package gof23.structural_patterns.adapter.media_player;

public class Mp4Player implements AdvancedMediaPlayer{
    @Override
    public void playVlc(String fileName) {
        //什么也不做
    }

    @Override
    public void playMp4(String fileName) {
        System.out.println("Mp4,启动...");
    }
}
