package main.java.Encapsulation.assigment_problems;



public class Playlist {
    
    private final String[] songs;
    private int count = 0;

    
    public Playlist(int maxSize) {
        this.songs = new String[maxSize];
    }

   
    public void addSong(String song) {
        if (song != null && count < songs.length) {
            songs[count] = song;
            count++;
        }
    }

   
    public String[] getSongs() {
        String[] safeCopy = new String[count];
        for (int i = 0; i < count; i++) {
            safeCopy[i] = songs[i];
        }
        return safeCopy;
    }

  
    public int getSongCount() {
        return count;
    }

    public static void main(String[] args) {
        Playlist p = new Playlist(10);
        p.addSong("Song A");
        p.addSong("Song B");

        String[] copy = p.getSongs();
        copy[0] = "Hacked"; 

        System.out.println("copy[0] -> " + copy[0]);
        System.out.println("p.getSongs()[0] -> " + p.getSongs()[0]); 
        System.out.println("Song count -> " + p.getSongCount());      
    }
}