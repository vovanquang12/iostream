package CalculateFileSize;

import java.util.Scanner;
import java.io.File;;

public class CalculateFileSize {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("nhap duong dan: ");
		String filePath;
		filePath = sc.nextLine();

		File file = new File(filePath);

		if (!file.exists()) {
			System.out.println("file khong ton tai!");
			return;
		}

		if (!file.isFile()) {
			System.out.println("khong phai file!");
			return;
		}

		double fileSizeByte = file.length();
		double fileSizeKB = fileSizeByte / 1024;
		double fileSizeMB = fileSizeKB / 1024;
		double fileSizeGB = fileSizeMB / 1024;

		System.out.println("Kich thuoc tep: ");
		System.out.println("Byte: " + fileSizeByte);
		System.out.println("Mega Byte: " + fileSizeMB);
		System.out.println("Giga Byte " + fileSizeGB);

	}
}
