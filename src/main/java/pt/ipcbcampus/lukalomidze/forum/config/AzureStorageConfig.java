package pt.ipcbcampus.lukalomidze.forum.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.azure.storage.blob.BlobContainerClient;
import com.azure.storage.blob.BlobServiceClientBuilder;

@Configuration
public class AzureStorageConfig {

    @Value("${azure.storage_account.name}")
    private String accountName;

    @Value("${azure.storage_account.key}")
    private String accountKey;

    @Value("${azure.storage_account.container.name}")
    private String containerName;

    @Bean
    public BlobContainerClient blobServiceClient() {
        String connectionString = String.format("DefaultEndpointsProtocol=https;AccountName=%s;AccountKey=%s;EndpointSuffix=core.windows.net", accountName, accountKey);
        return new BlobServiceClientBuilder()
            .connectionString(connectionString)
            .buildClient()
        .getBlobContainerClient(containerName);
    }
}
