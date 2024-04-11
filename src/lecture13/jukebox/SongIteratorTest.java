package lecture13.jukebox;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class SongIteratorTest {
	
	List<Song> songs;
	SongIterator it;
	@BeforeEach
	void setUp() {
		 songs = new ArrayList<Song>();
		 songs.add(new Song("Nunc fluens"));
		 songs.add(new Song("Hyderomastgroningem"));
		 songs.add(new Song("Blow Your Trumpets Gabriel"));
	}

	@Test
	void testEmpty() {
		it=new SongIterator(new ArrayList<Song>());
		assertFalse(it.hasNext());
		assertThrows(Exception.class, ()->it.next());
	}
	@Test
	void testHasNext() {
		it=new SongIterator(songs);
		for(int i=0; i<songs.size(); i++) {
			assertTrue(it.hasNext());
			System.out.println(it.next()); 
		}
		assertFalse(it.hasNext());
		
	}

}
