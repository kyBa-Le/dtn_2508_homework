package java_core.homework.assignment8.utils;

import java.time.LocalDateTime;

public class MyException extends Exception {
    private String message;
    private String reason;
    private LocalDateTime time;
    private StackTraceElement[] stackTrace;

    public MyException(String message, String reason, StackTraceElement[] stackTrace) {
        this.message = message;
        this.reason = reason;
        this.stackTrace = stackTrace;
        this.time = LocalDateTime.now();
    }

    @Override
    public String getMessage() {
        return message;
    }

    public String getReason() {
        return reason;
    }

    public LocalDateTime getTime() {
        return time;
    }

    @Override
    public String toString() {
        return "MyException [" +
                "Time=" + time +
                ", Message='" + message + '\'' +
                ", Reason='" + reason + '\'' +
                ']';
    }
}
