import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MultipartUpload {
//bucketname, keyname,file path, file size
    private static final String BUCKET_NAME = "your-bucket-name";
    private static final String KEY_NAME = "large-file.zip";
    private static final String FILE_PATH = "path/to/large-file.zip";
    private static final long PART_SIZE = 5*1024*1024;//5MB

    // How do we make chunks upload
    public static void main(String[] args) {

        AmazonS3 s3Client = AmazonS3ClientBuilder.standard().build();

        //Initialize the multipartupload
        InitiateMultipartUploadRequest initRequest = new InitiateMultipartUploadRequest(BUCKET_NAME, KEY_NAME);
        InitiateMultipartUploadResult initResponse = s3Client.initiateMultipartUpload(initRequest);

        File file = new File(FILE_PATH);
        long contentLength = file.length();
        List<PartETag> partETags = new ArrayList<>();
        try{
            //Upload Each part
            FileInputStream fis  = new FileInputStream(file);
            byte[] buffer = new byte[(int) PART_SIZE];
            int bytesRead;
            int partNumber = 1;

            while((bytesRead = fis.read(buffer)) > 0){
                UploadPartRequest uploadRequest = new UploadPartRequest()
                        .withBucketName(BUCKET_NAME)
                        .withKey(KEY_NAME)
                        .withUploadId(initResponse.getUploadId())
                        .withPartNumber(partNumber++)
                        .withInputStream(new FileInputStream(file))
                        .withFileOffset((partNumber-2) * PART_SIZE)
                        .withPartSize(bytesRead)
                        .withLastPart(bytesRead<PART_SIZE);

                partETags.add(s3Client.uploadPart(uploadRequest).getPartETag());
            }
            fis.close();

            CompleteMultipartUploadRequest completeRequest = new CompleteMultipartUploadRequest(BUCKET_NAME,KEY_NAME,initResponse.getUploadId(),partETags);
            s3Client.completeMultipartUpload(completeRequest);
        } catch (Exception e){
            s3Client.abortMultipartUpload(new AbortMultipartUploadRequest(BUCKET_NAME,KEY_NAME,initResponse.getUploadId()));
        }
    }
}
