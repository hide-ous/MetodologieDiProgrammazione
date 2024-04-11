package lecture13.jukebox;

public class Song {
	private String title;
	public Song(String title) {
		this.title=title;
	}
	
	public String getTitle() {
		return title;
	}
	@Override
	public String toString() {
		return title;
	}
}
