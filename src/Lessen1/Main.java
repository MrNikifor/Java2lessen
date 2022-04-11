package Lessen1;

public class Main {
    public static void main(String[] args) {
        ParticipantsCompetition[] participantsCompetitions = {
                new Human("BomgMitrofan"),
                new Cat("Pizduc"),
                new Robot("Terminator"),
        };
        Obstacles[] obstacles = {
                new Track(500),
                new Track(1000),
                new Wall(500),
                new Wall(1000),
        };

        crossingObstacle(participantsCompetitions,obstacles);
    }
    private static void crossingObstacle(ParticipantsCompetition[] participantsCompetitions, Obstacles[] obstacles){
        for (ParticipantsCompetition participantsCompetition : participantsCompetitions) {    // массивы участников и
            for (Obstacles obstacle : obstacles) {                                            // препядствий
                System.out.print(participantsCompetition.toString() + " ");
                System.out.println(obstacle.canDoIt(participantsCompetition) + " ");
            }
        }
        System.out.println();
    }

}
