package Lessen2;

public class Main {

    public static void main(String[] args) {

        String[][] arr = new String[][]{{"1", "1", "1", "1"},
                                        {"2", "2", "2", "2"},
                                        {"3", "3", "3", "4"},
                                        {"4", "4", "4", "4"}};
        try {
            try {
                int result = method(arr);
                System.out.println(result);
            } catch (MyArraySizeException e) {
                System.out.println("Array size exceeded!");
            }
        }
        catch (MyArrayDataException e) {
            System.out.println("Incorrect array value!");
            System.out.println(String.format("by index arr[%d][%d]", e.getline(),e.getpost()));
        }

    }


    public static int method(String[][] arr) throws MyArraySizeException, MyArrayDataException {
        int count = 0;
        if (arr.length != 4) {
            throw new MyArraySizeException();
        }
        for (int line = 0; line < arr.length; line++) {
            String[] row = arr[line];
            if (arr[line].length != 4) {
                throw new MyArraySizeException();
            }
            for (int post = 0; post < arr[line].length; post++) {
                String value = row[post];
                try {
                    count += Integer.valueOf(value);
                }
                catch (NumberFormatException e) {
                    throw new MyArrayDataException(line, post);
                }
            }

        }
        return count;
    }

}