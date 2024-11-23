public abstract class Media {
    private String title;
    private int duration;

    public Media(String title, int duration) {
        this.title = title;
        this.duration = duration;
    }

    public abstract void play();

    public String getTitle() {
        return title;
    }

    public int getDuration() {
        return duration;
    }
}

class Video extends Media {
    private String resolution;

    public Video(String title, int duration, String resolution) {
        super(title, duration);
        this.resolution = resolution;
    }

    @Override
    public void play() {
        System.out.println("Playing video: " + getTitle());
        System.out.println("Duration: " + getDuration() + " seconds");
        System.out.println("Resolution: " + resolution);
    }
}

class Audio extends Media {
    private String artist;

    public Audio(String title, int duration, String artist) {
        super(title, duration);
        this.artist = artist;
    }

    @Override
    public void play() {
        System.out.println("Playing audio: " + getTitle());
        System.out.println("Duration: " + getDuration() + " seconds");
        System.out.println("Artist: " + artist);
    }
}
