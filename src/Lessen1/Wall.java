package Lessen1;

public class Wall implements Obstacles{
    private final int height;
    public Wall(int height) {
        this.height = height;
    }
    public boolean canDoIt(ParticipantsCompetition jumps){   // логический метод выполнилось ли действие(флажек).
        int heightJump = jumps.jump();
        System.out.println(" get the height " + height);
        return heightJump >= height;
    }
}

