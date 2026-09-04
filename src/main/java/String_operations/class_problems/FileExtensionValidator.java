package String_operations.class_problems;

import java.util.Scanner;

public class FileExtensionValidator {
    public static void validateFileExtension(String filename) {
        int dotIndex = filename.lastIndexOf('.');

        if (dotIndex == -1 || dotIndex == filename.length() - 1) {
            System.out.println("Rejected — invalid file type");
            return;
        }

        String ext = filename.substring(dotIndex + 1).toLowerCase();

        if (ext.equals("pdf") || ext.equals("docx") || ext.equals("zip")) {
            System.out.println("Accepted");
        } else {
            System.out.println("Rejected — invalid file type");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        validateFileExtension(sc.nextLine());
    }
}