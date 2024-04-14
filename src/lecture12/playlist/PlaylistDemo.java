package lecture12.playlist;

import java.util.ArrayList;
import java.util.Iterator;

public class PlaylistDemo {
	public static void main(String[] args) {
		Playlist pl = new Playlist();
		pl.addSong(new Song("Nunc fluens"));
		pl.addSong(new Song("The sound of muzak"));
		pl.addSong(new Song("Open car"));
		pl.addSong(new Song("Tio macaco"));
		System.out.println(pl);

		Iterator<Song> it = pl.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
	}
}
