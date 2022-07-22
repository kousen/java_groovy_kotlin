package sorting;

public record Golfer(String first, String last, int score) implements Comparable<Golfer> {
    public int compareTo(Golfer other) {
        return Integer.compare(score, other.score);
    }
}