package nono.guilherme.manga.infra.gateway.mangaScrapper;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import nono.guilherme.manga.core.domain.MangaInfo;
import nono.guilherme.manga.core.gateway.MangaScrapGateway;
import nono.guilherme.manga.entrypoint.http.request.MangaQueryRequest;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
@Slf4j
public class MangaScrapperGatewayImpl implements MangaScrapGateway {

    private RestTemplate restTemplate;

    public MangaScrapperGatewayImpl(final RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    @Override
    public MangaInfo getSerieByQuery(MangaQueryRequest q) throws JsonProcessingException {

        if (q.getName() == null) {
           throw new RuntimeException();
        }

        final ObjectMapper objectMapper = new ObjectMapper();
        final String url = "https://mangalivre.net/lib/search/series.json";

        final HttpHeaders headers = new HttpHeaders();
        headers.set("X-Requested-With", "XMLHttpRequest");
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        MultiValueMap<String, String> bodyPair = new LinkedMultiValueMap<>();
        bodyPair.set("search", q.getName());

        final HttpEntity entity = new HttpEntity<>(bodyPair, headers);

        String response;

        try {
            response = this.restTemplate.postForObject(url, entity, String.class);
            final MangaInfo series = objectMapper.readValue(response, MangaInfo.class);
            return series;
        } catch (Exception e) {
            log.info(e.getMessage());
            throw e;
        }
    }
}
//const search = async (mangaName: string) => {
//        const data = qs.stringify({
//        search: `${mangaName}`,
//        });
//        const config:AxiosRequestConfig = {
//        method: "post",
//        url: "https://mangalivre.net/lib/search/series.json",
//        headers: {
//        "X-Requested-With": "XMLHttpRequest",
//        "Content-Type": "application/x-www-form-urlencoded",
//        },
//        data: data,
//        };
//
//        try {
//        const response = await axios(config);
//        return JSON.parse(JSON.stringify(response.data));
//        } catch (error) {
//        return console.log(error);
//        }
//        };