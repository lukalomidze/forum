package pt.ipcbcampus.lukalomidze.forum.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.azure.storage.blob.BlobContainerClient;
import com.azure.storage.blob.BlobServiceClientBuilder;
import com.azure.storage.blob.models.PublicAccessType;

@Configuration
public class AzureStorageConfig {

    @Value("${spring.cloud.azure.storage.name}")
    private String accountName;

    @Value("${spring.cloud.azure.storage.key}")
    private String accountKey;

    @Value("${spring.cloud.azure.storage.container.name}")
    private String containerName;

    @Bean
    public BlobContainerClient blobServiceClient() {
        String connectionString = String.format("DefaultEndpointsProtocol=https;AccountName=%s;AccountKey=%s;EndpointSuffix=core.windows.net", accountName, accountKey);
        
        var blobContainerClient = new BlobServiceClientBuilder()
            .connectionString(connectionString)
            .buildClient()
        .createBlobContainerIfNotExists(containerName);

        blobContainerClient.setAccessPolicy(
            PublicAccessType.BLOB, null
        );

        return blobContainerClient;
    }
}
