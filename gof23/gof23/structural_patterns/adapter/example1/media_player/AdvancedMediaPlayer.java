package gof23.structural_patterns.adapter.example1.media_player;

public interface AdvancedMediaPlayer {
    void playVlc(String fileName);
    void playMp4(String fileName);
}
