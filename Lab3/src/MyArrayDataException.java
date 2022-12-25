public class MyArrayDataException extends RuntimeException {
    public MyArrayDataException(String message) {
        super("Ошибка преобразования элемента массива в целое число.\n"  + message);
    }
}
