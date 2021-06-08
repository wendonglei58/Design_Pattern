package BasicOOD.toInterface.imageSoreImp;

import BasicOOD.toInterface.ImageStore;

import java.io.File;

public class PrivateImageStore implements ImageStore {
    @Override
    public String upload(File Image, String bucket) {
        createBucketIfNotExist(bucket);
        //upload image to bucket
        return null;
    }

    @Override
    public File download(String url) {
        // get image by url
        return null;
    }

    private void createBucketIfNotExist(String bucket) {
        //create bucket if not existing
        // through exception if failed
    }
}
