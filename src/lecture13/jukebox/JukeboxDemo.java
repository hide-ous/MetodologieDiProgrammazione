package lecture13.jukebox;

import java.util.Iterator;

public class JukeboxDemo {
	public static void main(String[] args) {
		
		Jukebox jb = new Jukebox();
		Iterator<Song> it = jb.iterator();
		jb.addSong(new Song("Nunc fluens"));
		jb.addSong(new Song("Hyderomastgroningem"));
		jb.addSong(new Song("Blow Your Trumpets Gabriel"));
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		jb.addSong(new Song("The sound of muzak"));
		System.out.println(it.next());
				 
	}
}
