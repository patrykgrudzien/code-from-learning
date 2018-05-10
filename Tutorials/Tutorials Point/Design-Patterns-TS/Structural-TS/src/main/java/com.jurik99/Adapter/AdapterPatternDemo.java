package com.jurik99.Adapter;

public class AdapterPatternDemo
{
	public static void main(final String[] args)
	{
		final AudioPlayer audioPlayer = new AudioPlayer();

		audioPlayer.play(AudioType.MP3, "beyond the horizon.mp3");
		audioPlayer.play(AudioType.MP4, "alone.mp4");
		audioPlayer.play(AudioType.VLC, "far far away.vlc");
		audioPlayer.play(null, "mind me.avi");
	}
}
