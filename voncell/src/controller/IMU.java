package controller;

import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.awt.image.WritableRaster;

import org.opencv.core.Mat;
import org.opencv.core.Size;
import org.opencv.highgui.Highgui;
import org.opencv.imgproc.Imgproc;

//Image Utility

public class IMU {
	
	public static void init(){
		//10/06/2016
		System.loadLibrary("opencv_java2413");
	}	
	
	public static Mat load(String file){
		return Highgui.imread(file, Highgui.CV_LOAD_IMAGE_COLOR);
	}
	
	public static Mat dilate(Mat source, int size){
		Mat destination = source.clone();
        Mat element = Imgproc.getStructuringElement(Imgproc.MORPH_RECT, new Size(2*size, 2*size));
        Imgproc.dilate(source, destination, element);     
        return destination;
	}
	
	public static Mat erode(Mat source, int size){
		Mat destination = source.clone();
        Mat element = Imgproc.getStructuringElement(Imgproc.MORPH_RECT, new Size(2*size, 2*size));
        Imgproc.erode(destination, destination, element);
        return destination;		
	}

	public static void save(String file, Mat source){
		Highgui.imwrite(file, source);
	}
	
	public static BufferedImage MatToImage(Mat mat) {        
	    int type = 0;
	    if (mat.channels() == 1) {
	        type = BufferedImage.TYPE_BYTE_GRAY;
	    } else if (mat.channels() == 3) {
	        type = BufferedImage.TYPE_3BYTE_BGR;
	    } else {
	        return null;
	    }

	    BufferedImage image = new BufferedImage(mat.width(), mat.height(), type);
	    WritableRaster raster = image.getRaster();
	    DataBufferByte dataBuffer = (DataBufferByte) raster.getDataBuffer();
	    byte[] data = dataBuffer.getData();
	    mat.get(0, 0, data);

	    return image;
	}
}
