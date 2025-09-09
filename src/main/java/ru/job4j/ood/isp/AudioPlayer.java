package ru.job4j.ood.isp;

public class AudioPlayer implements MultimediaPlayer {
    @Override
    public void playAudio() {
        System.out.println("Playing audio");
    }

    @Override
    public void playVideo() {
        throw new UnsupportedOperationException("AudioPlayer cannot play video");
    }

    @Override
    public void playSubtitle() {
        throw new UnsupportedOperationException("AudioPlayer cannot play subtitles");
    }
}
