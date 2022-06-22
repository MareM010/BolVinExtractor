package com.example.bolvinextractor;

import com.google.zxing.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.*;
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

import java.io.*;
import java.awt.image.BufferedImage;

import javafx.embed.swing.SwingFXUtils;

import java.util.Arrays;

import nu.pattern.OpenCV;
import org.opencv.core.*;
import org.opencv.highgui.HighGui;
import org.opencv.imgcodecs.Imgcodecs;

import javax.imageio.ImageIO;

import static com.example.bolvinextractor.BarCodeClass.readMultipleBarcodeImageData;


public class Controller {
Image image1;
    public StackPane image_bol_stack_pane;
    final Canvas imageCanvas = new Canvas();
    WritableImage croppedImage;
    ToggleGroup tg = new ToggleGroup();
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
    void deleteAllButton(ActionEvent event) throws TesseractException {
    }

    @FXML
    void delete_1(ActionEvent event) {

    }

    @FXML
    void imageCropMousePressed(MouseEvent event) {

        startX = event.getX();
        startY = event.getY();

        rect = new Rectangle();
        rect.setFill(Color.SNOW);
    //    rect.setStroke(Color.BLACK);

rectGroup.getChildren().add(rect);


        rectIsBeingDrawn = true;


    }
    BufferedImage croppedBufferedImage = null;
    void capturePane() {


        try {
            image_cropped.setImage(image1);
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
    void imageCropMouseRelased(MouseEvent event) throws TesseractException, NotFoundException, FormatException, IOException {

        if(rectIsBeingDrawn == true){
            rect.setFill(Color.BLUE);
        }
        rect = null;
        rectIsBeingDrawn = false;

        rectGroup.getChildren().clear();

        capturePane();
        textImageExtraction();

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










    public void textImageExtraction() throws TesseractException, NotFoundException, FormatException, IOException {
        BufferedImage bufImage = null;
        // For proper execution of native libraries
        // Core.NATIVE_LIBRARY_NAME must be loaded
        // before calling any of the opencv methods
        try {
            OpenCV.loadLocally();

            Mat src = Imgcodecs.imread("C:\\Users\\ghost\\Documents\\OPENCVTEST\\test.png", Imgcodecs.IMREAD_GRAYSCALE);

            Mat destination = new Mat(src.rows(), src.cols(), src.type());
//
//            Size upscaleSize = new Size(src.cols()*2, src.rows()*2);
//            Imgproc.resize(src, destination, upscaleSize, 0, 0, Imgproc.INTER_AREA);
////
//            Imgproc.adaptiveThreshold(src, destination, 125,
//                    Imgproc.ADAPTIVE_THRESH_MEAN_C,
//                    THRESH_BINARY, 11, 12);

//
//            src.convertTo(destination, -1, alpha, beta);
//            Imgproc.cvtColor(src, destination, Imgproc.COLOR_RGB2GRAY);
            // ove dve linije iznad mi kre[uju kod


            bufImage = (BufferedImage) HighGui.toBufferedImage(destination);
    //       image_cropped.setImage(SwingFXUtils.toFXImage(bufImage,null));


        }
        catch (Exception e){
            System.out.println("Error in OpenCV image processing. Exception: "+ e.getMessage());
        }

//        try {
//            //Reading the image
//            Mat src = Imgcodecs.imread("C:\\Users\\ghost\\IdeaProjects\\BOL VIN Extractor\\src\\main\\resources\\com\\example\\bolvinextractor\\BOL.png");
//            //Creating the empty destination matrix
//            Mat dst = new Mat();
//            //Converting the image to grey scale
//            Imgproc.cvtColor(src, dst, Imgproc.COLOR_RGB2GRAY);
//            //Instantiating the Imagecodecs class
//            Imgcodecs imageCodecs = new Imgcodecs();
//            //Writing the image
//            imageCodecs.imwrite("colortogreyscale.jpg", dst);
//            System.out.println("Image Saved");
//
//        } catch (Exception e) {
//            System.out.println("Error: " + e.getMessage());
//        }



//            Tsseract instance = new Tesseract();
//            instance.setLanguage("eng");
//          //  File imageFile = new File("C:\\Users\\ghost\\Documents\\OPENCVTEST\\outputtest.png");
//
//            instance.setDatapath("C:\\Users\\ghost\\.m2\\repository\\net\\sourceforge\\tess4j\\tess4j\\5.2.1\\tessdata");
//          //  File fileForScanning = new File(String.valueOf(croppedImage));
//            System.out.println(instance.doOCR(bufImage));
//
//
//            BufferedImage buffImage2;
//            buffImage2 = SwingFXUtils.fromFXImage(image1,null);
//
//            BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(
//                    new BufferedImageLuminanceSource(croppedBufferedImage)));
//
//            MultiFormatReader reader2 = new MultiFormatReader();
//
//         //   Result result = new MultiFormatReader().decode(bitmap);
//
//        MultipleBarcodeReader multipleReader = new GenericMultipleBarcodeReader(reader2);
//        Result[] results = multipleReader.decodeMultiple(bitmap);
//        int resultsCount = results.length;
//        int i =0;
//            while (i<resultsCount){
//                System.out.println(results[i]);
//                i++;
//            }

            // zxing kod ali ne radi, baca exception, importovano sve


        //For Read Single Bar Code Image Info
    //
        //    System.out.println(readSingleBarcodeImageData(croppedBufferedImage));

        //For Read Multiple Bar Code Image Info
        System.out.println(Arrays.toString(readMultipleBarcodeImageData(croppedBufferedImage)));




    }





}
