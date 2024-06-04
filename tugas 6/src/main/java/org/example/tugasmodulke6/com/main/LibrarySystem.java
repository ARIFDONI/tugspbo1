package org.example.tugasmodulke6.com.main;

import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.example.tugasmodulke6.books.*;
import org.example.tugasmodulke6.data.Admin;
import org.example.tugasmodulke6.data.Student;

import java.util.ArrayList;

public class LibrarySystem {
    public static ArrayList<Book> daftarBuku = new ArrayList<>();
    public static ArrayList<Student> studentList = new ArrayList<>();

    public static void startLibrarySystem(Stage stage) {
        daftarBuku.add(new StoryBook("SB32F", "OPM", 17, "Story", "Genos"));
        daftarBuku.add(new HistoryBook("HB324", "HxH", 2, "History", "Gon"));
        daftarBuku.add(new TextBook("TB323", "OP", 4, "Text", "Zoro"));

        studentList.add(new Student("202310370311202", "Revaldo", "Teknik", "Informatika"));
        studentList.add(new Student("202310370311203", "Reval", "Teknik", "DKV"));
        studentList.add(new Student("202310370311204", "Valdo", "Teknik", "Sistem Informasi"));

        VBox root = new VBox(10);
        Scene scene = new Scene(root, 400, 300);

        Label label = new Label("===== Library System =====");
        Button studentLoginButton = new Button("Login sebagai Mahasiswa");
        Button adminLoginButton = new Button("Login sebagai Admin");
        Button exitButton = new Button("Keluar");

        studentLoginButton.setOnAction(event -> studentLogin(stage));
        adminLoginButton.setOnAction(event -> {
            try {
                new Admin().login(stage);
            } catch (Exception e) {
                showErrorDialog("Error", e.getMessage());
            }
        });
        exitButton.setOnAction(event -> stage.close());

        root.getChildren().addAll(label, studentLoginButton, adminLoginButton, exitButton);

        stage.setScene(scene);
        stage.setTitle("Library System");
        stage.show();
    }

    private static void studentLogin(Stage stage) {
        VBox root = new VBox(10);
        Scene scene = new Scene(root, 400, 300);

        Label label = new Label("Masukkan NIM : ");
        TextField nimField = new TextField();
        Button loginButton = new Button("Login");
        Button backButton = new Button("Kembali");

        loginButton.setOnAction(event -> {
            String nimStudent = nimField.getText();
            if (nimStudent.length() == 15 && checkNim(nimStudent)) {
                Student student = new Student(nimStudent);
                student.login(stage);
            } else {
                showErrorDialog("Error", "Nim tidak terdaftar atau tidak valid!");
            }
        });

        backButton.setOnAction(event -> startLibrarySystem(stage));

        root.getChildren().addAll(label, nimField, loginButton, backButton);

        stage.setScene(scene);
    }

    private static void showErrorDialog(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setContentText(message);
        alert.showAndWait();
    }

    public static boolean checkNim(String nim) {
        for (Student student : studentList) {
            if (student.getNim().equals(nim)) {
                return true;
            }
        }
        return false;
    }
}
