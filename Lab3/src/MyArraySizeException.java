public class MyArraySizeException extends RuntimeException{
    public MyArraySizeException(String message) {
        super("Ошибка размерности массива.\n" + message);
    }
}
