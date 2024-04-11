package lecture13.jukebox;

import java.util.Iterator;
import java.util.List;

public class SongIterator implements Iterator<Song> {
	private List<Song> songs;
	private int position;
	public SongIterator(List<Song> songs) {
		this.songs = songs;
		position=0;
	}

	@Override
	public boolean hasNext() {
		return position < songs.size();
	}

	@Override
	public Song next() {
		return songs.get(position++);
	}

}
