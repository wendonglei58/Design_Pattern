package BasicOOD.toInterface;

import BasicOOD.toInterface.imageSoreImp.PrivateImageStore;

import java.io.File;

public class ImageProcessJob {
    private static final String BUCKET_NAME = "my bucket";

    public void processImage(File image) {
        ImageStore imageStore= new PrivateImageStore();
        imageStore.upload(image, BUCKET_NAME);
    }
}
