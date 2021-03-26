package objects;

public class CompleteChair {
    private String seat;
    private String feet;
    private String backrest;
    private String stabilizerBar;

    public CompleteChair(){

    }
    public CompleteChair(String seat, String feet, String backrest, String stabilizerBar) {
        this.seat = seat;
        this.feet = feet;
        this.backrest = backrest;
        this.stabilizerBar = stabilizerBar;
    }

    @Override
    public String toString() {
        return "Chair{" +
                "seat='" + seat + '\'' +
                ", feet='" + feet + '\'' +
                ", backrest='" + backrest + '\'' +
                ", stabilizerBar='" + stabilizerBar + '\'' +
                '}';
    }
}
