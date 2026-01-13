package java_core.homework.assignment8.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;

/**
 * Exercise 3: File Management
 */
public class FileManager {

    public static final String FILE_EXISTS = "Error! File Exist.";
    public static final String FILE_NOT_EXIST = "Error! File Not Exist.";
    public static final String FOLDER_EXIST = "Error! Folder Exist.";
    public static final String PATH_NOT_FOLDER = "Error! Path is not folder.";
    public static final String SOURCE_FILE_NOT_EXIST = "Error! Source File Not Exist.";
    public static final String DESTINATION_FILE_EXIST = "Error! newPath has File same name.";
    public static final String NAME_EXIST = "Error! Name is Exist.";

    // Q1: Check File Exists
    public static boolean isFileExists(String pathFile) {
        File file = new File(pathFile);
        return file.exists();
    }

    // Q2: Create new file
    public static void createNewFile(String pathFile) throws Exception {
        File file = new File(pathFile);
        if (file.exists()) {
            throw new Exception(FILE_EXISTS);
        }
        boolean success = file.createNewFile();
        System.out.println(success ? "Tạo file thành công!" : "Tạo file thất bại!");
    }

    // Q4: Delete file
    public static void deleteFile(String pathFile) throws Exception {
        File file = new File(pathFile);
        if (!file.exists()) {
            throw new Exception(FILE_NOT_EXIST);
        }
        boolean success = file.delete();
        System.out.println(success ? "Xóa file thành công!" : "Xóa file thất bại!");
    }

    // Q5: Check path is File or Folder
    public static boolean isFolder(String path) {
        File file = new File(path);
        return file.isDirectory();
    }

    // Q6: Get all File name of Folder
    public static List<String> getAllFileName(String path) throws Exception {
        File folder = new File(path);
        if (!folder.isDirectory()) {
            throw new Exception(PATH_NOT_FOLDER);
        }
        File[] files = folder.listFiles();
        List<String> fileNames = new ArrayList<>();
        if (files != null) {
            for (File f : files) {
                if (f.isFile()) {
                    fileNames.add(f.getName());
                }
            }
        }
        return fileNames;
    }

    // Q7: Copy File
    public static void copyFile(String sourceFile, String destinationPath) throws Exception {
        File source = new File(sourceFile);
        if (!source.exists())
            throw new Exception(SOURCE_FILE_NOT_EXIST);

        File dest = new File(destinationPath);
        if (dest.exists())
            throw new Exception(DESTINATION_FILE_EXIST);

        Files.copy(source.toPath(), dest.toPath(), StandardCopyOption.REPLACE_EXISTING);
        System.out.println("Copy file thành công!");
    }

    // Q8: Move File
    public static void moveFile(String sourceFile, String destinationPath) throws Exception {
        File source = new File(sourceFile);
        if (!source.exists())
            throw new Exception(FILE_NOT_EXIST);

        File dest = new File(destinationPath);
        Files.move(source.toPath(), dest.toPath(), StandardCopyOption.REPLACE_EXISTING);
        System.out.println("Di chuyển file thành công!");
    }

    // Q9: Rename File
    public static void renameFile(String pathFile, String newName) throws Exception {
        File file = new File(pathFile);
        if (!file.exists())
            throw new Exception(FILE_NOT_EXIST);

        File newFile = new File(file.getParent() + "/" + newName);
        if (newFile.exists())
            throw new Exception(NAME_EXIST);

        boolean success = file.renameTo(newFile);
        System.out.println(success ? "Đổi tên thành công!" : "Đổi tên thất bại!");
    }

    // Q10: Create new folder
    public static void createNewFolder(String newPathFolder) throws Exception {
        File folder = new File(newPathFolder);
        if (folder.exists())
            throw new Exception(FOLDER_EXIST);

        boolean success = folder.mkdirs();
        System.out.println(success ? "Tạo folder thành công!" : "Tạo folder thất bại!");
    }

    // Q11: Download File (Simplified based on instructions)
    public static void downloadFile(String fileLink, String folderSave) throws Exception {
        File folder = new File(folderSave);
        if (!folder.exists())
            folder.mkdirs();

        String fileName = fileLink.substring(fileLink.lastIndexOf("/") + 1);
        File file = new File(folderSave + "/" + fileName);

        // Xử lý trùng tên (thêm số 1, 2...)
        int count = 1;
        while (file.exists()) {
            String name = fileName.substring(0, fileName.lastIndexOf("."));
            String ext = fileName.substring(fileName.lastIndexOf("."));
            file = new File(folderSave + "/" + name + "(" + count + ")" + ext);
            count++;
        }

        URL url = new URL(fileLink);
        URLConnection connection = url.openConnection();
        InputStream in = connection.getInputStream();
        FileOutputStream output = new FileOutputStream(file);

        byte[] buffer = new byte[1024];
        int bytesRead;
        while ((bytesRead = in.read(buffer)) != -1) {
            output.write(buffer, 0, bytesRead);
        }

        output.close();
        in.close();
        System.out.println("Download thành công: " + file.getAbsolutePath());
    }
}
