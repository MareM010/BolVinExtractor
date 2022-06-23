package com.example.bolvinextractor;

import com.google.zxing.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.PixelReader;
import javafx.scene.image.WritableImage;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import net.sourceforge.tess4j.TesseractException;

import java.awt.*;
import java.io.*;
import java.awt.image.BufferedImage;

import javafx.embed.swing.SwingFXUtils;

import java.util.Arrays;
import java.util.Timer;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import nu.pattern.OpenCV;
import org.opencv.core.*;
import org.opencv.highgui.HighGui;
import org.opencv.imgcodecs.Imgcodecs;

import javax.imageio.ImageIO;

import static com.example.bolvinextractor.BarCodeClass.readMultipleBarcodeImageData;


public class Controller {
Image image1;
ImageTextExtraction textExtraction = new ImageTextExtraction();
    // public StackPane image_bol_stack_pane;
    BufferedImage croppedBufferedImage = null;
    Canvas imageCanvas = new Canvas();
    Graphics2D graphics2D;
    double startX, startY, endX, endY;
    Rectangle rect = null;
   public static Group rectGroup = new Group();
    Boolean rectIsBeingDrawn = false;
    static double alpha = 1;
    static double beta = 50;


//    Rectangle updateRectangleOnScreen(double startingPointX, double startingPointY, double endingPointX, double endingPointY, Rectangle currentRectangle){
//
//        double rectWidth = endingPointX - startingPointX;
//        double rectHeight = endingPointY - startingPointY;
//
//        currentRectangle = new Rectangle(startingPointX, startingPointY, rectWidth, rectHeight);
//
//        if ( currentRectangle.getWidth() < 0 )
//        {
//            currentRectangle.setWidth( - currentRectangle.getWidth() ) ;
//            currentRectangle.setX( currentRectangle.getX() - currentRectangle.getWidth() ) ;
//        }
//
//        if ( currentRectangle.getHeight() < 0 )
//        {
//            currentRectangle.setHeight( - currentRectangle.getHeight() ) ;
//            currentRectangle.setY( currentRectangle.getY() - currentRectangle.getHeight() ) ;
//        }
//
//        System.out.println("Width: " + rectWidth);
//        System.out.println("Height: " + rectHeight);
//
//        return currentRectangle;
//    }

    @FXML
    protected RadioButton bar_code_mode;

    @FXML
    private Button copy_1;

    @FXML
    private Button copy_10;

    @FXML
    private Button copy_11;

    @FXML
    private Button copy_12;

    @FXML
    private Button copy_2;

    @FXML
    private Button copy_3;

    @FXML
    private Button copy_4;

    @FXML
    private Button copy_5;

    @FXML
    private Button copy_6;

    @FXML
    private Button copy_7;

    @FXML
    private Button copy_8;

    @FXML
    private Button copy_9;

    @FXML
    private Button delete1;

    @FXML
    private Button delete11;

    @FXML
    private Button delete110;

    @FXML
    private Button delete1101;

    @FXML
    private Button delete12;

    @FXML
    private Button delete13;

    @FXML
    private Button delete14;

    @FXML
    private Button delete15;

    @FXML
    private Button delete16;

    @FXML
    private Button delete17;

    @FXML
    private Button delete18;

    @FXML
    private Button delete19;

    @FXML
    private Button delete_all;

    @FXML
    private ImageView image_bol;

    @FXML
    protected ImageView image_cropped;

    @FXML
    private Button load_image_button;

    @FXML
    private ProgressBar progress_bar;

    @FXML
    protected RadioButton text_recongition_mode;

    @FXML
    private TextField vin_1;

    @FXML
    private TextField vin_10;

    @FXML
    private TextField vin_11;

    @FXML
    private TextField vin_12;

    @FXML
    private TextField vin_2;

    @FXML
    private TextField vin_3;

    @FXML
    private TextField vin_4;

    @FXML
    private TextField vin_5;

    @FXML
    private TextField vin_6;

    @FXML
    private TextField vin_7;

    @FXML
    private TextField vin_8;

    @FXML
    private TextField vin_9;

    @FXML
    void TextRecongitionMode(ActionEvent event) {

    }

    @FXML
    void barCodeMode(ActionEvent event) {

    }

    @FXML
    void copyText1(ActionEvent event) {

    }

    @FXML
    void copyText10(ActionEvent event) {

    }

    @FXML
    void copyText11(ActionEvent event) {

    }

    @FXML
    void copyText12(ActionEvent event) {

    }

    @FXML
    void copyText2(ActionEvent event) {

    }

    @FXML
    void copyText3(ActionEvent event) {

    }

    @FXML
    void copyText4(ActionEvent event) {

    }

    @FXML
    void copyText5(ActionEvent event) {

    }

    @FXML
    void copyText6(ActionEvent event) {

    }

    @FXML
    void copyText7(ActionEvent event) {

    }

    @FXML
    void copyText8(ActionEvent event) {

    }

    @FXML
    void copyText9(ActionEvent event) {

    }

    @FXML
    void deleteAllButton(ActionEvent event){
        vin_1.setText("");
        vin_2.setText("");
        vin_3.setText("");
        vin_4.setText("");
        vin_5.setText("");
        vin_6.setText("");
        vin_7.setText("");
        vin_8.setText("");
        vin_9.setText("");
        vin_10.setText("");
        vin_11.setText("");
        vin_12.setText("");

    }

    @FXML
    void delete_1(ActionEvent event) {
        vin_1.setText("");

    }

    @FXML
    void delete_10(ActionEvent event) {
        vin_10.setText("");
    }

    @FXML
    void delete_11(ActionEvent event) {
        vin_11.setText("");
    }

    @FXML
    void delete_12(ActionEvent event) {
        vin_12.setText("");
    }

    @FXML
    void delete_2(ActionEvent event) {
        vin_2.setText("");
    }

    @FXML
    void delete_3(ActionEvent event) {
        vin_3.setText("");
    }

    @FXML
    void delete_4(ActionEvent event) {
        vin_4.setText("");
    }

    @FXML
    void delete_5(ActionEvent event) {
        vin_5.setText("");
    }

    @FXML
    void delete_6(ActionEvent event) {
        vin_6.setText("");
    }

    @FXML
    void delete_7(ActionEvent event) {
        vin_7.setText("");
    }

    @FXML
    void delete_8(ActionEvent event) {
        vin_8.setText("");
    }

    @FXML
    void delete_9(ActionEvent event) {
        vin_9.setText("");
    }




    @FXML
    void imageCropMousePressed(MouseEvent event) {

        startX = event.getX();
        startY = event.getY();

        rect = new Rectangle();
        rect.setFill(Color.RED);

     rectGroup.getChildren().add(rect);
        rectIsBeingDrawn = true;


    }
    void capturePane() {

        try {
            PixelReader reader = image1.getPixelReader();
            WritableImage newImage = new WritableImage(reader, (int) startX, (int) startY, (int) (endX - startX), (int) (endY - startY));

            croppedBufferedImage= SwingFXUtils.fromFXImage(newImage, croppedBufferedImage);
            image_cropped.setImage(newImage);

            ImageIO.write(SwingFXUtils.fromFXImage(newImage, null),
                    "png", new File("C:\\Users\\ghost\\Documents\\OPENCVTEST\\test.png"));
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Program crashed while making a screenshot");
        }
    }

    @FXML
    void imageCropMouseDragged(MouseEvent event) {

        progress_bar.setProgress(ProgressIndicator.INDETERMINATE_PROGRESS);
        if (rectIsBeingDrawn == true) {
            endX = event.getX();
            endY = event.getY();

            rect.setX(startX);
            rect.setY(startY);
            rect.setWidth(endX - startX);
            rect.setHeight(endY - startY);


         if ( rect.getWidth() < 0 )
         {
          rect.setWidth( - rect.getWidth() ) ;
          rect.setX( rect.getX() - rect.getWidth() ) ;
         }

         if ( rect.getHeight() < 0 )
         {
          rect.setHeight( - rect.getHeight() ) ;
          rect.setY( rect.getY() - rect.getHeight() ) ;
         }
        }

    }

    @FXML
    void imageCropMouseRelased(MouseEvent event) {
        int rectCount = rectGroup.getChildren().size();


        if(rectIsBeingDrawn == true){
            rect.setFill(Color.BLUE);
        }
        rect = null;
        rectIsBeingDrawn = false;

        rectGroup.getChildren().remove(rectCount-1);
        resultToTextField();
        progress_bar.setProgress(0);

    }



    @FXML
    void loadImageButton(ActionEvent event) {

        System.out.println("Majmuneee");
        FileChooser chooser = new FileChooser();
        chooser.setTitle("Open BOL Picture");
        chooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("JPG", "*.jpg"),
                new FileChooser.ExtensionFilter("PNG", "*.png"),
                new FileChooser.ExtensionFilter("All Images", "*.*")
        );
      File file = chooser.showOpenDialog(new Stage());

        image1 = new Image(file.toURI().toString(), 576, 878, true, true);
        image_bol.setFitHeight(858);
        image_bol.setFitWidth(565);
        image_bol.setImage(image1);



        // setting canvas frame size depending on image width and height properties
        imageCanvas.setWidth(image1.getWidth());
        imageCanvas.setHeight(image1.getHeight());




    }
// mode = true for bar code text recognition
// mode = false for text extraction
    public void resultToTextField(){
        int i = 0;
        double progress, p = 1;
        capturePane();
        if (bar_code_mode.isSelected()){
            try {
                progress = 0.33;
                while (readMultipleBarcodeImageData(croppedBufferedImage).length > i){
                    if (vin_1.getText().isEmpty())
                    vin_1.setText(String.valueOf(readMultipleBarcodeImageData(croppedBufferedImage)[i]));
                else if (vin_2.getText().isEmpty())
                    vin_2.setText(String.valueOf(readMultipleBarcodeImageData(croppedBufferedImage)[i]));
                else if (vin_3.getText().isEmpty())
                    vin_3.setText(String.valueOf(readMultipleBarcodeImageData(croppedBufferedImage)[i]));
                else if (vin_4.getText().isEmpty())
                    vin_4.setText(String.valueOf(readMultipleBarcodeImageData(croppedBufferedImage)[i]));
                else if (vin_5.getText().isEmpty())
                    vin_5.setText(String.valueOf(readMultipleBarcodeImageData(croppedBufferedImage)[i]));
                else if (vin_6.getText().isEmpty())
                    vin_6.setText(String.valueOf(readMultipleBarcodeImageData(croppedBufferedImage)[i]));
                else if (vin_7.getText().isEmpty())
                    vin_7.setText(String.valueOf(readMultipleBarcodeImageData(croppedBufferedImage)[i]));
                else if (vin_8.getText().isEmpty())
                    vin_8.setText(String.valueOf(readMultipleBarcodeImageData(croppedBufferedImage)[i]));
                else if (vin_9.getText().isEmpty())
                    vin_9.setText(String.valueOf(readMultipleBarcodeImageData(croppedBufferedImage)[i]));
                else if (vin_10.getText().isEmpty())
                    vin_10.setText(String.valueOf(readMultipleBarcodeImageData(croppedBufferedImage)[i]));
                else if (vin_11.getText().isEmpty())
                    vin_11.setText(String.valueOf(readMultipleBarcodeImageData(croppedBufferedImage)[i]));
                else if (vin_12.getText().isEmpty())
                    vin_12.setText(String.valueOf(readMultipleBarcodeImageData(croppedBufferedImage)[i]));

                 //   progress = progress + 0.33;
                    i++;
                }

//                if (vin_1.getText().isEmpty())
//                    vin_1.setText((Arrays.toString(readMultipleBarcodeImageData(croppedBufferedImage))));
//                else if (vin_2.getText().isEmpty())
//                    vin_2.setText((Arrays.toString(readMultipleBarcodeImageData(croppedBufferedImage))));
//                else if (vin_3.getText().isEmpty())
//                    vin_3.setText((Arrays.toString(readMultipleBarcodeImageData(croppedBufferedImage))));
//                else if (vin_4.getText().isEmpty())
//                    vin_4.setText((Arrays.toString(readMultipleBarcodeImageData(croppedBufferedImage))));
//                else if (vin_5.getText().isEmpty())
//                    vin_5.setText((Arrays.toString(readMultipleBarcodeImageData(croppedBufferedImage))));
//                else if (vin_6.getText().isEmpty())
//                    vin_6.setText((Arrays.toString(readMultipleBarcodeImageData(croppedBufferedImage))));
//                else if (vin_7.getText().isEmpty())
//                    vin_7.setText((Arrays.toString(readMultipleBarcodeImageData(croppedBufferedImage))));
//                else if (vin_8.getText().isEmpty())
//                    vin_8.setText((Arrays.toString(readMultipleBarcodeImageData(croppedBufferedImage))));
//                else if (vin_9.getText().isEmpty())
//                    vin_9.setText((Arrays.toString(readMultipleBarcodeImageData(croppedBufferedImage))));
//                else if (vin_10.getText().isEmpty())
//                    vin_10.setText((Arrays.toString(readMultipleBarcodeImageData(croppedBufferedImage))));
//                else if (vin_11.getText().isEmpty())
//                    vin_11.setText((Arrays.toString(readMultipleBarcodeImageData(croppedBufferedImage))));
//                else if (vin_12.getText().isEmpty())
//                    vin_12.setText((Arrays.toString(readMultipleBarcodeImageData(croppedBufferedImage))));
            }
            catch (Exception e){
                System.out.println("Exception: "  + e.getMessage());
            }
        }
        else if (text_recongition_mode.isSelected()){
            image_cropped.setImage(textExtraction.textImageExtraction());
            if (vin_1.getText().isEmpty())
                vin_1.setText(textExtraction.returnResult());
            else if (vin_2.getText().isEmpty())
                vin_2.setText(textExtraction.returnResult());
            else if (vin_3.getText().isEmpty())
                vin_3.setText(textExtraction.returnResult());
            else if (vin_4.getText().isEmpty())
                vin_4.setText(textExtraction.returnResult());
            else if (vin_5.getText().isEmpty())
                vin_5.setText(textExtraction.returnResult());
            else if (vin_6.getText().isEmpty())
                vin_6.setText(textExtraction.returnResult());
            else if (vin_7.getText().isEmpty())
                vin_7.setText(textExtraction.returnResult());
            else if (vin_8.getText().isEmpty())
                vin_8.setText(textExtraction.returnResult());
            else if (vin_9.getText().isEmpty())
                vin_9.setText(textExtraction.returnResult());
            else if (vin_10.getText().isEmpty())
                vin_10.setText(textExtraction.returnResult());
            else if (vin_11.getText().isEmpty())
                vin_11.setText(textExtraction.returnResult());
            else if (vin_12.getText().isEmpty())
                vin_12.setText(textExtraction.returnResult());
        }
        else {
            System.out.println("Select mode please");
        }

    }

    void drawRectangles(Graphics graphics){

    }


}
