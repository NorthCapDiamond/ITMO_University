package data;

public enum MusicGenre implements Comparable<MusicGenre>{
    ROCK("rock"),
    PSYCHEDELIC_CLOUD_RAP("psychedelic cloud rap"),
    JAZZ("jazz"),
    POP("pop"),
    POST_PUNK("post punk");

    private final String name;
    MusicGenre(String name) {
        this.name = name;
    }
    public String getName(){
        return name;
    }
    public boolean compareTo(MusicGenre genre1, MusicGenre genre2){
        return (genre1.getName().length() > genre2.getName().length());
    }
}