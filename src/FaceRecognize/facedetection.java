package FaceRecognize;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.MatOfRect;
import org.opencv.core.Point;
import org.opencv.core.Rect;
import org.opencv.core.Scalar;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;
import org.opencv.objdetect.CascadeClassifier;

public class facedetection {
	public static void main(String [] args)
	{
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
		String imgfile="images/IMG_3036.jpg";
		Mat src= Imgcodecs.imread(imgfile);
		
		String xmlfile="xmls/lbpcascade_frontalface.xml";
		CascadeClassifier cc = new CascadeClassifier(xmlfile);
		
		MatOfRect facedetect = new MatOfRect();
		cc.detectMultiScale(src, facedetect);
		System.out.println(String.format("Detected faces: %d", facedetect.toArray().length));
		
		for(Rect rect: facedetect.toArray())
		{
			Imgproc.rectangle(src, new Point(rect.x,rect.y), new Point(rect.x + rect.width,rect.y + rect.height), new Scalar(0,0,255),3);
		}
		
		Imgcodecs.imwrite("images/IMG_3036_out.jpg",	src);
		System.out.println("Image Detection Finished");
		}

}
