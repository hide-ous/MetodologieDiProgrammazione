package lecture12.playlist;

public class Song {
	private String title;
	
	public Song(String songTitle) {
		this.title=songTitle;
	}
	
	public String getTitle() {
		return title;
	}
	
	@Override
	public String toString() {
		
		return title;
	}
	

}
