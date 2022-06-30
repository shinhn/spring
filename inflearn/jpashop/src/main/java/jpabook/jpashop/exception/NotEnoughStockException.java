package jpabook.jpashop.exception;

public class NotEnoughStockException extends RuntimeException{
    // cmd + N 으로 쉽게 생성할 수 있음
    public NotEnoughStockException() {
    }

    public NotEnoughStockException(String message) {
        super(message);
    }

    public NotEnoughStockException(String message, Throwable cause) {
        super(message, cause);
    }

    public NotEnoughStockException(Throwable cause) {
        super(cause);
    }
}
