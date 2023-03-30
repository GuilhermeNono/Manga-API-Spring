package nono.guilherme.manga.core.usecase;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import nono.guilherme.manga.core.domain.MangaInfo;
import nono.guilherme.manga.core.gateway.MangaScrapGateway;
import nono.guilherme.manga.entrypoint.http.request.MangaQueryRequest;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class GetSerieByQuery {
    private final MangaScrapGateway mangaScrapGateway;

    public MangaInfo process(MangaQueryRequest q) throws JsonProcessingException {
        return mangaScrapGateway.getSerieByQuery(q);
    }
}
