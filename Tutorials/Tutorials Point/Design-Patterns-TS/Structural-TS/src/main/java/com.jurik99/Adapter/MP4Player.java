package com.jurik99.Adapter;

public class MP4Player implements AdvancedMediaPlayer {

	@Override
	public void playVLC(final String fileName) {
		// --- DO NOTHING ---
	}

	@Override
	public void playMP4(final String fileName) {
		System.out.println("Playing MP4 file. Name: " + fileName);
	}
}
