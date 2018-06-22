package com.jurik99.Adapter;

public class Intro {
	/*
	 * Adapter pattern works as a bridge between two incompatible interfaces. This type of design pattern comes under
	 * structural pattern as this pattern combines the capability of two independent interfaces.
	 *
	 * This pattern involves a single class which is responsible to join functionalities of independent or
	 * incompatible interfaces. A real life example could be a case of card reader which acts as an adapter between
	 * memory card and a laptop. You plugin the memory card into card reader and card reader into the laptop so that
	 * memory card can be read via laptop.
	 *
	 * We are demonstrating use of Adapter pattern via following example in which an audio player device can play mp3
	 * files only and wants to use an advanced capable of playing VLC and MP4 files.
	 *
	 * --- IMPLEMENTATION ---
	 * We have a "MediaPlayer" interface and a concrete class "AudioPlayer" implementing the MediaPlayer interface.
	 * AudioPlayer can play MP3 format audio files by default.
	 *
	 * We are having another interface "AdvancedMediaPlayer" and concrete classes implementing the
	 * "AdvancedMediaPlayer" interface. These classes can play VLC and MP4 format files.
	 *
	 * We want to make AudioPlayer to play other formats as well. To attain this, we have created an adapter class
	 * "MediaAdapter" which implements the "MediaPlayer" interface and uses AdvancedMediaPlayer objects to play the
	 * required format.
	 *
	 * "AudioPlayer" uses the adapter class "MediaAdapter" passing it the desired audio type without knowing the
	 * actual class which can play the desired format. "AdapterPatternDemo" or just "Main" demo class will use
	 * "AudioPlayer" class to play various formats.
	 *
	 * Step-by-step:
	 * 1) Create interfaces for "Media Player" and "Advanced Media Player"
	 * 2) Create concrete classes implementing the "AdvancedMediaPlayer"
	 * 3) Create adapter class implementing the "MediaPlayer" interface
	 * 4) Create concrete class implementing the "MediaPlayer" interface
	 * 5) Use the "AudioPlayer" to play different types of audio formats
	 */
}
