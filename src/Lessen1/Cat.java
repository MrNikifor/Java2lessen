package Lessen1;


public class Cat implements ParticipantsCompetition{       // данные класса кот
    public String name;
    public Cat(String name) {
        this.name = name;
    }
    @Override
    public int jump() {
        return 500;
    }
    @Override
    public int run() {
        return 500;
    }
    @Override
    public String toString() {
        return "Cat{" +
                "name '" + name + '\'' +
                '}';
    }
}


