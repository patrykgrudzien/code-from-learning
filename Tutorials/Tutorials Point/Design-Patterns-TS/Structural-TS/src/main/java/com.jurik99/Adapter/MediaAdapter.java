package com.jurik99.Adapter;

public class MediaAdapter implements MediaPlayer
{
	private AdvancedMediaPlayer advancedMediaPlayer;

	public MediaAdapter(final AudioType audioType)
	{
		if (audioType == AudioType.VLC)
		{
			advancedMediaPlayer = new VLCPlayer();
		}
		else if (audioType == AudioType.MP4)
		{
			advancedMediaPlayer = new MP4Player();
		}
	}

	@Override
	public void play(final AudioType audioType, final String fileName)
	{
		if (audioType == AudioType.VLC)
		{
			advancedMediaPlayer.playVLC(fileName);
		}
		else if (audioType == AudioType.MP4)
		{
			advancedMediaPlayer.playMP4(fileName);
		}
	}
}
