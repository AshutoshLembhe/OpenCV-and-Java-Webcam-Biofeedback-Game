package pro.Webcam;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

import javax.imageio.ImageIO;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.MatOfByte;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.videoio.VideoCapture;

import processing.core.PApplet;
import processing.core.PConstants;
import processing.core.PImage;

public class ProcessingWebcam extends PApplet{
	Mat img;
	PImage pimg;
	VideoCapture capture;
	public void settings() {
		size(800,600);
		capture = new VideoCapture(0);//zero first webcam
		if(capture.isOpened()==false) {
			System.out.println("unable to open camera");
			capture.release();
			System.exit(0);
		}
		img = new Mat();
	}
	
	public void draw() {
		if(capture.read(img)) {
			pimg=MatToPImage(img);
			image(pimg,0,0,500,500);
		}
	}
	
	
	public static void main(String[] args) {
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
		PApplet.main(ProcessingWebcam.class.getName());

	}
	
	private static PImage MatToPImage(Mat mat) {
		if (mat != null && !mat.empty()) {
			MatOfByte matOfByte = new MatOfByte();
			Imgcodecs.imencode(".jpg", mat, matOfByte); // for OpenCV 4.5.1
			//Highgui.imencode(".jpg", mat, matOfByte);   // for OpenCV 2.4.9
			byte[] byteArray = matOfByte.toArray();
			try {
				InputStream in = new ByteArrayInputStream(byteArray);
				BufferedImage bimg = ImageIO.read(in);
				PImage img = new PImage(bimg.getWidth(), bimg.getHeight(), PConstants.ARGB);
				bimg.getRGB(0, 0, img.width, img.height, img.pixels, 0, img.width);
				img.updatePixels();
				bimg = null;
				return img;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return null;
	}

}
