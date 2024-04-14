/**
 * 
 */
package lecture12.playlist;

import java.util.ArrayList;
import java.util.Iterator;


/**
 * 
 */
public class Playlist implements Iterable<Song> {

	private final ArrayList<Song> songs;
		
	public Playlist() {
		songs = new ArrayList<Song>();
	}
	public void addSong(Song song) {
		this.songs.add(song);
	}
	
	@Override
	public String toString() {
		String toReturn = "";
		for(int i=0; i<songs.size(); i++) {
			toReturn+=i+") "+songs.get(i).getTitle()+"\n";
		}
		return toReturn;
	}
	
	@Override
	public Iterator<Song> iterator() {
		return songs.iterator();
//		return new SongIterator(songs);	
	}

}
