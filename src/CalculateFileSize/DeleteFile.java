package CalculateFileSize;

import java.io.File;
import java.util.Scanner;

public class DeleteFile {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Nhập đường dẫn thư mục hoặc tệp tin: ");
		String path = scanner.nextLine();
		scanner.close();

		File fileOrDir = new File(path);

		if (!fileOrDir.exists()) {
			System.out.println("Thư mục hoặc tệp tin không tồn tại!");
			return;
		}

		if (fileOrDir.isFile()) {
			if (fileOrDir.delete()) {
				System.out.println("Đã xóa tệp tin thành công!");
			} else {
				System.out.println("Không thể xóa tệp tin!");
			}
		} else if (fileOrDir.isDirectory()) {
			if (deleteDirectory(fileOrDir)) {
				System.out.println("Đã xóa thư mục thành công!");
			} else {
				System.out.println("Không thể xóa thư mục!");
			}
		}
	}

	private static boolean deleteDirectory(File directory) {
		if (directory.exists()) {
			File[] files = directory.listFiles();
			if (files != null) {
				for (File file : files) {
					if (file.isDirectory()) {
						deleteDirectory(file);
					} else {
						file.delete();
					}
				}
			}
			return directory.delete();
		}
		return false;
	}
}
