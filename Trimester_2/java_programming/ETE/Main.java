public class Main {
    public static void main(String[] args) {
        Video video = new Video("Piano video", 120, "1080p");
        video.play();

        System.out.println();

        Audio audio = new Audio("My mixtape", 180, "Anjaney");
        audio.play();
    }
}
