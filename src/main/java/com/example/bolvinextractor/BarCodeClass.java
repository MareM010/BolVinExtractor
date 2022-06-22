package com.example.bolvinextractor;

import com.google.zxing.*;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;
import com.google.zxing.multi.GenericMultipleBarcodeReader;
import com.google.zxing.multi.MultipleBarcodeReader;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Hashtable;

public class BarCodeClass {

    static Result[] readMultipleBarcodeImageData(BufferedImage croppedImage) throws NotFoundException, IOException {//
        BinaryBitmap bb = new BinaryBitmap(new HybridBinarizer(new BufferedImageLuminanceSource(croppedImage)));
        MultipleBarcodeReader mbReader = new GenericMultipleBarcodeReader(new MultiFormatReader());
        Hashtable<DecodeHintType, Object> hints = new Hashtable<>();
        hints.put(DecodeHintType.TRY_HARDER, Boolean.TRUE);
        /*List<BarcodeInfo> list = new ArrayList<>();//if have any custom data then convert to dto like this
        for (Result result : mbReader.decodeMultiple(bb, hints)) {
            list.add(new BarcodeInfo(result.getText(), result.getBarcodeFormat().name()));
        }
        return list;*/
        Result[] currentBarCodeResult = mbReader.decodeMultiple(bb, hints);//every result represent a bar code
        return currentBarCodeResult;
    }

    private static String readSingleBarcodeImageData(BufferedImage croppedImage) throws NotFoundException, IOException {

        BinaryBitmap bb = new BinaryBitmap(new HybridBinarizer(new BufferedImageLuminanceSource(croppedImage)));
        MultipleBarcodeReader mbReader = new GenericMultipleBarcodeReader(new MultiFormatReader());
        Hashtable<DecodeHintType, Object> hints = new Hashtable<>();
        hints.put(DecodeHintType.TRY_HARDER, Boolean.TRUE);
        Result[] currentBarCodeResult = mbReader.decodeMultiple(bb, hints);
        return currentBarCodeResult[0].getText();
    }
}
