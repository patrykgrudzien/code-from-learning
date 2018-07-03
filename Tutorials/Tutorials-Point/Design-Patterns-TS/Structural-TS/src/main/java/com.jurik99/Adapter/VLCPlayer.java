package com.jurik99.Adapter;

public class VLCPlayer implements AdvancedMediaPlayer {

	@Override
	public void playVLC(final String fileName) {
		System.out.println("Playing VLC file. Name: " + fileName);
	}

	@Override
	public void playMP4(final String fileName) {
		// --- DO NOTHING ---
	}
}
