package com.displaytest;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.highgui.HighGui;
import org.opencv.imgcodecs.Imgcodecs;

public class DisplayTest {

	public static void main(String[] args) {
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
		String filePath = "src/cat.jpg";
		Mat originalImage = Imgcodecs.imread(filePath);
		if(originalImage.dataAddr()==0){
			System.out.println("Couldn't open file " + filePath);
		} else {
			HighGui.namedWindow("original image");
			HighGui.imshow("original image",originalImage);
			HighGui.waitKey();
		}
	}

}
