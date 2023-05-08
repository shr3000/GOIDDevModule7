package client;

import downloader.HttpStatusImageDownloader;

import java.util.Scanner;

public class HttpImageStatusCli {
    private HttpStatusImageDownloader downloader;

    public HttpImageStatusCli() {
        this.downloader = new HttpStatusImageDownloader();
    }

    public void askStatus() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter HTTP status code: ");
        String input = scanner.nextLine();

        int code;
        try {
            code = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            System.out.println("Please enter valid number");
            return;
        }
        try {
            downloader.downloadStatusImage(code);
        } catch (Exception e) {
            System.out.println("There is not image for HTTP status " + code);
        }
    }
}
