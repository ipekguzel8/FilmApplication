package core.service;

import com.ozguryaz.core.domain.Film;
import com.ozguryaz.core.service.FilmService;
import com.ozguryaz.ui.component.EnumLanguage;
import org.junit.Test;

public class FilmServiceTest {
    @Test
    public void filmEkle() {

        Film film = new Film();
        film.setName("Titanic");
        film.setYear(1997);
        film.setDescription("Titanik dünyaca ünlüdür. Gişe rekorunu kıran ve yıllarca gişe şampiyonu tacını takan film (Jim Cameron'ın Avatarı tarafından geçilene kadar) özeldir çünkü Titanic felaketini tüm ihtişamıyla sergilemekle kalmaz, film tekniktir. en yüksek düzenin başarısı");
        film.setLanguage(EnumLanguage.İngilizce);
        film.setMedia("Cinema");
        film.setType("Romantic/Dram");
        FilmService filmService = new FilmService();
        filmService.save(film);
    }
}
