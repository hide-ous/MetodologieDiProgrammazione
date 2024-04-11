package lecture13.jukebox;

import java.util.ArrayList;
import java.util.Iterator;

public class Jukebox implements Iterable<Song> {
	private final ArrayList<Song> songs=new ArrayList<Song>();
	
	public void addSong(Song aSong) {
		songs.add(aSong);
	}

	@Override
	public Iterator<Song> iterator() {
		return new SongIterator(songs);
	}

}
