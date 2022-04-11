package Lessen1;


public class Robot implements ParticipantsCompetition{     // данные класса робот

    public String name;

    public Robot(String name) {
            this.name = name;
    }

    @Override
    public int jump() {
        return 1500;
    }

    @Override
    public int run() {
        return 1000;
    }

    @Override
    public String toString() {
        return "Robot{" +
                "name '" + name + '\'' +
                '}';
    }
    }


