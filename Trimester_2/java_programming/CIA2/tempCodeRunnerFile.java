public class playingCat {
    public boolean isCatPlaying(boolean summer, int temperature) {
        if (summer && temperature >= 25 && temperature <= 45) {
            return true;
        }
        else if (summer==false && temperature >= 25 && temperature <= 35) {
            return true;
        }
        else {
            return false;
        }
    }

    public static void main(String[] args) {
        playingCat cat = new playingCat();
        boolean isPlaying = cat.isCatPlaying(true, 46);
        System.out.println(isPlaying);
    }
}