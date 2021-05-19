package restclient;

import com.ozguryaz.core.domain.Film;
import com.ozguryaz.restclient.RestClient;
import org.junit.Test;

import java.util.List;

public class RestClientTest {
    @Test
    public void findAllFilmFromRest() throws Exception {
        RestClient restClient = new RestClient();
        List<Film> filmList = restClient.findAllFilmFromRest();
        for (Film film : filmList) {
            System.out.println(film.getName());
        }
    }
}
