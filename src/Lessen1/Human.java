package Lessen1;

public class Human implements ParticipantsCompetition{  // данные класса человек

    public String name;

    public Human(String name) {
        this.name = name;
    }

    @Override
    public int jump() {
        return 1200;
    }
    @Override
    public int run() {
        return 800;
    }

    @Override
    public String toString() {
        return "Human{" + "name '" + name + '\'' + '}';
    }

}
