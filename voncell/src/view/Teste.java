package view;

import org.opencv.core.Mat;

import controller.IMU;

public class Teste {

    public static void main(String[] args) {
    	IMU.init();
    	String path = "C:/git/voncell/files/img/";
    	String fileName = "circle.png";   
 	
        Mat source = IMU.load(path+fileName);
        Mat destination = null;
        
        for(int i = 1; i < 10; i++){
        	destination = IMU.erode(source, i);        
            IMU.save(path+"Dilate"+i+fileName,destination);       	
        }
        
        new DisplayImage(path+fileName);        
    }      
}
