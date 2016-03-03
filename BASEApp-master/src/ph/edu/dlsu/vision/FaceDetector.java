package ph.edu.dlsu.vision;

import org.opencv.core.*;
import org.opencv.imgproc.Imgproc;
import org.opencv.objdetect.CascadeClassifier;


public class FaceDetector {

    private CascadeClassifier faceDetector;

    public FaceDetector() {
        loadCascade();
    }

    private void loadCascade() {
        String cascadePath = "D:\\JC\\2nd Term SY 2016-16\\OBJECTP-L\\BASEApp-master\\BASEApp-master\\res\\cascades\\lbpcascade_frontalface.XML";
        faceDetector = new CascadeClassifier(cascadePath);
    }

    public void detectAndDrawFace(Mat image) {
        MatOfRect faceDetections = new MatOfRect();
        faceDetector.detectMultiScale(image, faceDetections, 1.1, 7, 0, new Size(250, 40), new Size());
        // Draw a bounding box around each face.
        for (Rect rect : faceDetections.toArray()) {
            Imgproc.rectangle(image, new Point(rect.x, rect.y), new Point(rect.x + rect.width, rect.y + rect.height), new Scalar(0, 255, 0));
        }
    }

}
