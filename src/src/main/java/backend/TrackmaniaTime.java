package backend;

public class TrackmaniaTime {
    private final String PLAYER, MAP;
    private final Time time;

    public TrackmaniaTime(String PLAYER, String MAP, Time time) {
        this.PLAYER = PLAYER;
        this.MAP = MAP;
        this.time = time;
    }

    public String getPLAYER() {
        return PLAYER;
    }

    public String getMAP() {
        return MAP;
    }

    public Time getTime() {
        return time;
    }
}
