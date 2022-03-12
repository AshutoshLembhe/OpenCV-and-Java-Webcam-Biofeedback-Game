package com.videotest;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.highgui.HighGui;
import org.opencv.videoio.VideoCapture;
import org.opencv.videoio.Videoio;

public class Videotest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
		
		VideoCapture capture = new VideoCapture(0);// 0 for first webcam.
		capture.set(Videoio.CAP_PROP_FRAME_WIDTH, 640);
		capture.set(Videoio.CAP_PROP_FRAME_WIDTH, 400);
		
		if(capture.isOpened()==false) {
			System.out.println("Unable to open camera");
			capture.release();
			System.exit(0);
		}
		
		HighGui.namedWindow("Webcam Video");
		Mat frame=new Mat();
		while(true) {
			capture.read(frame);
			if(frame.empty()) {
				System.out.println("empty frame");
				break;
			}
			HighGui.imshow("Webcam Video", frame);
			if(HighGui.waitKey(10)==27) {
				break;
			}
		}
		HighGui.destroyAllWindows();
		capture.release();// memory clean up ln 38-39.
		System.exit(0);
	}

}
