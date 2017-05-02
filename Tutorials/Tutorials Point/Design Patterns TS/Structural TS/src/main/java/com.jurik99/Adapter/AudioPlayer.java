package com.jurik99.Adapter;

public class AudioPlayer implements MediaPlayer
{
	@SuppressWarnings("FieldCanBeLocal")
	private MediaAdapter mediaAdapter;

	@Override
	public void play(final AudioType audioType, final String fileName)
	{
		// --- INBUILT SUPPORT TO PLAY MP3 MUSIC FILES ---
		if (audioType == AudioType.MP3)
		{
			System.out.println("Playing mp3 file. Name: " + fileName);
		}
		else if (audioType == AudioType.MP4 || audioType == AudioType.VLC)
		{
			mediaAdapter = new MediaAdapter(audioType);
			mediaAdapter.play(audioType, fileName);
		}
		else
		{
			System.out.println("Invalid media. " + audioType + " format not supported !");
		}
	}
}
