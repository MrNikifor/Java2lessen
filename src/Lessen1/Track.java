package Lessen1;

public class Track implements Obstacles {
    private final int distance;
    public Track(int distance) {
        this.distance = distance;
    }
    public boolean canDoIt(ParticipantsCompetition runs) {       // логический метод выполнилось ли действие(флажек).
        int distanceRun = runs.run();
        System.out.println(" can the distance " + distance);
        return distanceRun >= distance;
    }
}


