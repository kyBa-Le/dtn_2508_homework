package java_core.homework.assignment8.utils;

import java.io.*;
import java.nio.charset.StandardCharsets;

/**
 * Exercise 4: IO Stream
 */
public class IOManager {

    public static final String FILE_NOT_EXIST = "Error! File Not Exist.";
    public static final String OBJECT_NULL = "Error! Object is Null.";

    // Q1: Read File
    public static String readFile(String pathFile) throws Exception {
        if (!FileManager.isFileExists(pathFile)) {
            throw new Exception(FILE_NOT_EXIST);
        }

        StringBuilder content = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(pathFile))) {
            String line;
            while ((line = br.readLine()) != null) {
                content.append(line).append("\n");
            }
        }
        return content.toString();
    }

    // Q2: Write Content to File
    public static void writeFile(String pathFile, String content, boolean isContinuing) throws Exception {
        File file = new File(pathFile);
        if (!file.exists()) {
            // Tự động tạo file nếu chưa có (để tiện test), thay vì throw exception ngay
            file.createNewFile();
        }

        try (FileOutputStream fos = new FileOutputStream(pathFile, isContinuing)) {
            fos.write(content.getBytes(StandardCharsets.UTF_8));
            System.out.println("Ghi nội dung vào file thành công!");
        }
    }

    // Q3: Write Object
    public static void writeObject(Object object, String path, String fileName) throws Exception {
        if (object == null)
            throw new Exception(OBJECT_NULL);

        File folder = new File(path);
        if (!folder.exists())
            folder.mkdirs();

        String fullPath = path + "/" + fileName;

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fullPath))) {
            oos.writeObject(object);
            System.out.println("Ghi Object thành công vào: " + fullPath);
        }
    }

    // Q4: Read Object
    public static Object readObject(String filePath) throws Exception {
        if (!FileManager.isFileExists(filePath)) {
            throw new Exception(FILE_NOT_EXIST);
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath))) {
            return ois.readObject();
        }
    }
}
