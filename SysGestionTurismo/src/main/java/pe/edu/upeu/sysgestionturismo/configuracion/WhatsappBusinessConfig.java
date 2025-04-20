package pe.edu.upeu.sysgestionturismo.configuracion;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

@Configuration
public class WhatsappBusinessConfig {

    @Value("${whatsapp.business.api.url}")
    private String apiUrl;

    @Value("${whatsapp.business.token}")
    private String apiToken;

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    public HttpHeaders buildAuthHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(apiToken);
        headers.setContentType(MediaType.APPLICATION_JSON);
        return headers;
    }

    public String getApiUrl() {
        return apiUrl;
    }
}