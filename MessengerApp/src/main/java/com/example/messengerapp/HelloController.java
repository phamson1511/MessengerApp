package com.example.messengerapp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.SnapshotParameters;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

import java.io.IOException;

public class HelloController {
    @FXML
    private TextField srcText;
    @FXML
    private AnchorPane view;

    static int countMess = 0;
    @FXML
    public void Sent(ActionEvent event) throws IOException {
        Label yourMessage = new Label(srcText.getText());

        yourMessage.setMaxWidth(200);
        yourMessage.setMaxHeight(200);

        yourMessage.setFont(new Font("System",15));
        yourMessage.setStyle("-fx-background-color:  #7FFF00;-fx-background-radius: 20;-fx-text-fill: black");

        yourMessage.setLayoutY(0 + countMess * 45);
        yourMessage.setWrapText(true);
        yourMessage.setAlignment(Pos.CENTER_RIGHT);
        yourMessage.setPadding(new Insets(10, 10, 10, 10));


        view.getChildren().add(yourMessage);

        SnapshotParameters params = new SnapshotParameters();
        params.setFill(Color.TRANSPARENT); // Đặt màu nền của ảnh chụp
        WritableImage snapshot = yourMessage.snapshot(params, null);

        // Lấy kích thước của ảnh chụp để xác định chiều rộng thực tế của label
        double labelWidth = snapshot.getWidth();

        // Thiết lập vị trí bắt đầu từ bên phải
        yourMessage.setLayoutX(view.getWidth() - labelWidth );

        countMess ++;
        srcText.clear();

    }
}