package com.iadmin.ui.exception;

/**
 * Сообщение об ошибке возникающей при слиянии объектов.
 */
public class MergeException extends Exception {

    private String detailMessage;

    /**
     * Ошибка возникала между двумя объектами
     * Исключение используется в том случае, если известна информация только об объектах.
     * @param one Объект 1
     * @param two Объект 2
     * @param ex Возникшая ошибка
     */
    public MergeException(Object one, Object two, Exception ex) {
        super(ex);
        detailMessage = String.format("Failed to merge objects one=%s ans two=%s", one, two);
    }

    @Override
    public String getMessage() {
        return detailMessage;
    }
}
