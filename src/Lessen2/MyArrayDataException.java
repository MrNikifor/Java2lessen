package Lessen2;

public class MyArrayDataException extends Throwable {
    private int line;
    private int post;

    public MyArrayDataException(int line, int post) {
        
    }

    public int getline() {
        return line;
    }

    public int getpost() {
        return post;
    }
}
