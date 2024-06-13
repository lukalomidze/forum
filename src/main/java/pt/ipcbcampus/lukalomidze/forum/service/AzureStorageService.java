package pt.ipcbcampus.lukalomidze.forum.service;

import java.io.IOException;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.azure.storage.blob.BlobContainerClient;

@Service
public class AzureStorageService {
    
    @Autowired
    private BlobContainerClient containerClient;

    public String uploadBlob(MultipartFile file) throws IOException {        
        String fileName = file.getOriginalFilename();

        var blobClient = containerClient.getBlobClient(
            UUID.randomUUID().toString() + fileName.substring(fileName.lastIndexOf("."))
        );

        blobClient.upload(file.getInputStream(), file.getSize(), true);

        return blobClient.getBlobUrl();
    }
}
