package window.Webcam;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.videoio.VideoCapture;

class FrameWindow extends JFrame{
	JLabel lableimage;
	public FrameWindow(String title) {
		super(title);
		lableimage=new JLabel();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		add(lableimage);
		setVisible(true);
	}
	public void setImage(Mat matimage) {
		Image image=Mat2BufferedImage(matimage);
		ImageIcon imgicon=new ImageIcon(image);
		setSize(matimage.cols(), matimage.rows());
		lableimage.setIcon(imgicon);
		lableimage.repaint();
	}
	private BufferedImage Mat2BufferedImage(Mat Matrix) {
		// TODO Auto-generated method stub
		int type=BufferedImage.TYPE_BYTE_GRAY;
		if(Matrix.channels()>1) {
			type=BufferedImage.TYPE_3BYTE_BGR;
		}
		int buffersize=Matrix.channels()*Matrix.cols()*Matrix.rows();
		byte[] buffer=new byte[buffersize];
		Matrix.get(0,0,buffer);//get all the pixels.
		BufferedImage image =new BufferedImage(Matrix.cols(),Matrix.rows(),type);
		final byte[] targetpixel=((DataBufferByte) image.getRaster().getDataBuffer()).getData();
		System.arraycopy(buffer, 0, targetpixel, 0, buffer.length);
		return image;
	}
	
}
public class Webcam {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
		FrameWindow fw=new FrameWindow("window capture");
		VideoCapture capture =new VideoCapture(0);// 0 for cam 1.
		if(capture.isOpened()==false) {
			System.out.println("Unable to open camera");
			capture.release();
			System.exit(0);
		}
		Mat frame=new Mat();
		while(true) {
			if(capture.read(frame)) {
				fw.setImage(frame);
			}
		}

	}

}
