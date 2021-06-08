package BasicOOD.toInterface;

import java.io.File;

public interface ImageStore {
    public String upload(File Image, String bucket);

    public File download(String url);
}
