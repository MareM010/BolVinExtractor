package com.example.bolvinextractor;

import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.Image;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
import nu.pattern.OpenCV;
import org.opencv.core.Mat;
import org.opencv.core.Size;
import org.opencv.highgui.HighGui;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

import java.awt.*;
import java.awt.image.BufferedImage;

import static org.opencv.imgproc.Imgproc.THRESH_BINARY;


public class ImageTextExtraction {
    BufferedImage bufImage;
    Image image;
    String result;
    public Image textImageExtraction(){

        // For proper execution of native libraries
        // Core.NATIVE_LIBRARY_NAME must be loaded
        // before calling any of the opencv methods
        try {
            OpenCV.loadLocally();

            Mat src = Imgcodecs.imread("C:\\Users\\ghost\\Documents\\OPENCVTEST\\test.png", Imgcodecs.IMREAD_GRAYSCALE);

            Mat destination = new Mat(src.rows(), src.cols(), src.type());

            Size upscaleSize = new Size(src.cols()*4, src.rows()*4);
            Imgproc.resize(src, destination, upscaleSize, 0, 0, Imgproc.INTER_AREA);

            Imgproc.adaptiveThreshold(src, destination, 125,
                    Imgproc.ADAPTIVE_THRESH_MEAN_C,
                    THRESH_BINARY, 11, 12);

//
//            src.convertTo(destination, -1, alpha, beta);
//            Imgproc.cvtColor(src, destination, Imgproc.COLOR_RGB2GRAY);
            // ove dve linije iznad mi kre[uju kod


            bufImage = (BufferedImage) HighGui.toBufferedImage(destination);
            image = SwingFXUtils.toFXImage(bufImage,null);
      //      image_cropped.setImage(SwingFXUtils.toFXImage(bufImage,null));


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



            Tesseract instance = new Tesseract();
            instance.setLanguage("eng");
          //  File imageFile = new File("C:\\Users\\ghost\\Documents\\OPENCVTEST\\outputtest.png");

        try {
            instance.setDatapath("C:\\Users\\ghost\\.m2\\repository\\net\\sourceforge\\tess4j\\tess4j\\5.2.1\\tessdata");
            //  File fileForScanning = new File(String.valueOf(croppedImage));
            System.out.println(instance.doOCR(bufImage));
            result = instance.doOCR(bufImage);
        }
        catch (TesseractException e){
            System.out.println("Tesseract exception: "+ e.getMessage());
        }


//
//            BufferedImage buffImage2;
//            buffImage2 = SwingFXUtils.fromFXImage(image1,null);
//
//            BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(
//                    new BufferedImageLuminanceSource(croppedBufferedImage)));
//
        return image;
    }

    protected String returnResult(){
        return result;
    }

}
