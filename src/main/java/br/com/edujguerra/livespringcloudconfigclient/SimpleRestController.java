package br.com.edujguerra.livespringcloudconfigclient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClient;

@RefreshScope
@RestController
public class SimpleRestController {

    @Value("${teste-app.api}")
    private String uriApi;

    private final RestClient restClient = RestClient.create();

    @GetMapping("/get")
    public Object getFromService() {
        return this.restClient.get().uri(uriApi).retrieve().toEntity(Object.class).getBody();
    }

}
