package lecture12.playlist;

import java.util.ArrayList;
import java.util.Iterator;

public class SongIterator implements Iterator<Song> {
	
	private ArrayList<Song> songs;
	private int currentPosition;
	public SongIterator(ArrayList<Song> songs) {
		this.songs = songs;
	}

	@Override
	public boolean hasNext() {
		return currentPosition<songs.size();
	}

	@Override
	public Song next() {
		return songs.get(currentPosition++);
	}

}
