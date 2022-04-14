package Lessen2;

public class MyArrayDataException extends RuntimeException {
    private int line;
    private int post;

    public MyArrayDataException(int line, int post) {
        
    }

    public MyArrayDataException(String message, int line, int post) {
        super(message);
        this.line = line;
        this.post = post;
    }

    public MyArrayDataException(String message, Throwable cause, int line, int post) {
        super(message, cause);
        this.line = line;
        this.post = post;
    }

    public MyArrayDataException(Throwable cause, int line, int post) {
        super(cause);
        this.line = line;
        this.post = post;
    }

    public MyArrayDataException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, int line, int post) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.line = line;
        this.post = post;
    }

    public int getline() {
        return line;
    }

    public int getpost() {
        return post;
    }
}
