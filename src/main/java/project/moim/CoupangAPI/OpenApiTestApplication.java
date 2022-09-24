package project.moim.CoupangAPI;

import org.apache.http.entity.StringEntity;
import org.apache.http.util.EntityUtils;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.IOException;

public class OpenApiTestApplication {    private final static String REQUEST_METHOD = "POST";
    private final static String DOMAIN = "https://api-gateway.coupang.com";
    private final static String URL = "/v2/providers/affiliate_open_api/apis/openapi/deeplink";
    // Replace with your own ACCESS_KEY and SECRET_KEY
    private final static String ACCESS_KEY = "988e16cf-8d5b-4071-acf5-287e7262374b";
    private final static String SECRET_KEY = "4d58a3020a7785a02e4d522ef8fd2188b7061639";

    private final static String REQUEST_JSON = "{\"coupangUrls\": [\"https://www.coupang.com/np/search?component=&q=good&channel=user\",\"https://www.coupang.com/np/coupangglobal\"]}";

    public static void main(String[] args) throws IOException {
        // Generate HMAC string
        String authorization = HmacGenerator.generate(REQUEST_METHOD, URL, SECRET_KEY, ACCESS_KEY);

        // Send request
        StringEntity entity = new StringEntity(REQUEST_JSON, "UTF-8");
        entity.setContentEncoding("UTF-8");
        entity.setContentType("application/json");

        org.apache.http.HttpHost host = org.apache.http.HttpHost.create(DOMAIN);
        org.apache.http.HttpRequest request = org.apache.http.client.methods.RequestBuilder
                .post(URL).setEntity(entity)
                .addHeader("Authorization", authorization)
                .build();

        org.apache.http.HttpResponse httpResponse = org.apache.http.impl.client.HttpClientBuilder.create().build().execute(host, request);

        // verify
        System.out.println(EntityUtils.toString(httpResponse.getEntity()));
    }
}