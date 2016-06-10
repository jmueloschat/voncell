package view;

import org.opencv.core.Core;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.core.Point;
import org.opencv.core.Size;
import org.opencv.highgui.Highgui;
import org.opencv.imgproc.Imgproc;

public class Teste {

    public static void main(String[] args) {
    	String imageSource = "C:/git/voncell/files/img/circle.png";        
    	String imageDestination = "C:/git/voncell/files/img/circleOut.png";
    	
        System.loadLibrary("opencv_java2413");
        
        Mat source = Highgui.imread(imageSource, Highgui.CV_LOAD_IMAGE_COLOR);
        Mat destination = new Mat(source.rows(), source.cols(), source.type());
        destination = source;

        int erosion_size = 30;
        int dilation_size = 5;
        
        Mat element = Imgproc.getStructuringElement(Imgproc.MORPH_RECT, new  Size(2*erosion_size + 1, 2*erosion_size+1));
        Imgproc.erode(source, destination, element);  
        
        new LoadImage(imageDestination, destination);        
    }      
}
