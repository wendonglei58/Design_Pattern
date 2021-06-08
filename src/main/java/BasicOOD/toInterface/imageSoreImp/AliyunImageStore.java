package BasicOOD.toInterface.imageSoreImp;

import BasicOOD.toInterface.ImageStore;

import java.io.File;

public class AliyunImageStore implements ImageStore {
    @Override
    public String upload(File Image, String bucket) {
        createBucketIfNotExist(bucket);
        String token = getAccessToken();
        // upload image to aliyun
        return null;// return url;
    }

    @Override
    public File download(String url) {
        String token = getAccessToken();
        // download image from aliyun using token by url;
        return null;
    }

    private void createBucketIfNotExist(String bucket) {
        //create bucket if not existing
        // through exception if failed
    }

    private String getAccessToken() {
        // generate token based on Aliyun
        return null;
    }
}
