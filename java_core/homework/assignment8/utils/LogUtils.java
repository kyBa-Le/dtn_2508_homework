package java_core.homework.assignment8.utils;

/**
 * Exercise 5 - Question 2: LogUtils
 */
public class LogUtils {

    // Method ghi log exception custom
    public static void writeLog(MyException exception) {
        String path = "ExceptionLog.txt"; // File log sẽ nằm ở thư mục gốc project
        StringBuilder sb = new StringBuilder();

        sb.append("---------- LOG ENTRY ----------\n");
        sb.append("Time: ").append(exception.getTime()).append("\n");
        sb.append("Message: ").append(exception.getMessage()).append("\n");
        sb.append("Reason: ").append(exception.getReason()).append("\n");
        sb.append("Stack Trace: \n");

        // Chỉ lấy vài dòng đầu của stack trace cho gọn
        StackTraceElement[] traces = exception.getStackTrace();
        if (traces != null) {
            for (int i = 0; i < Math.min(3, traces.length); i++) {
                sb.append("\t").append(traces[i].toString()).append("\n");
            }
        }
        sb.append("-------------------------------\n");

        try {
            // isContinuing = true để ghi nối tiếp log, không xóa log cũ
            IOManager.writeFile(path, sb.toString(), true);
        } catch (Exception e) {
            System.err.println("Không thể ghi log: " + e.getMessage());
        }
    }

    // Method ghi log thông thường
    public static void writeLog(String message, String reason) {
        try {
            MyException ex = new MyException(message, reason, Thread.currentThread().getStackTrace());
            writeLog(ex);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Demo
    public static void main(String[] args) {
        System.out.println("Demo LogUtils...");
        try {
            int result = 10 / 0; // Cố tình gây lỗi chia cho 0
        } catch (ArithmeticException e) {
            System.out.println("Bắt được lỗi, đang ghi log...");
            MyException myEx = new MyException(e.getMessage(), "Lỗi chia cho số 0", e.getStackTrace());
            writeLog(myEx);
        }
        System.out.println("Đã ghi xong. Kiểm tra file ExceptionLog.txt");
    }
}
