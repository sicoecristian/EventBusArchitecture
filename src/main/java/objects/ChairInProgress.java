package objects;

public class ChairInProgress {
    private String seat;
    private String feet;
    private String backrest;
    private String stabilizerBar;

    public ChairInProgress() {

    }

    public ChairInProgress(String seat, String feet, String backrest, String stabilizerBar) {
        this.seat = seat;
        this.feet = feet;
        this.backrest = backrest;
        this.stabilizerBar = stabilizerBar;
    }

    public String getSeat() {
        return seat;
    }

    public void setSeat(String seat) {
        this.seat = seat;
    }

    public String getFeet() {
        return feet;
    }

    public void setFeet(String feet) {
        this.feet = feet;
    }

    public String getBackrest() {
        return backrest;
    }

    public void setBackrest(String backrest) {
        this.backrest = backrest;
    }

    public String getStabilizerBar() {
        return stabilizerBar;
    }

    public void setStabilizerBar(String stabilizerBar) {
        this.stabilizerBar = stabilizerBar;
    }
}
