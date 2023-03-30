package nono.guilherme.manga.core.gateway;

import com.fasterxml.jackson.core.JsonProcessingException;
import nono.guilherme.manga.core.domain.MangaInfo;
import nono.guilherme.manga.entrypoint.http.request.MangaQueryRequest;

public interface MangaScrapGateway {

    MangaInfo getSerieByQuery(MangaQueryRequest q) throws JsonProcessingException;

}
