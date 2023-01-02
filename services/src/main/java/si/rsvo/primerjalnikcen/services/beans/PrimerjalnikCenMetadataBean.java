package si.rsvo.primerjalnikcen.services.beans;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.ws.rs.InternalServerErrorException;
import javax.ws.rs.ProcessingException;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.Response;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import org.eclipse.microprofile.faulttolerance.CircuitBreaker;
import org.eclipse.microprofile.faulttolerance.Fallback;
import org.eclipse.microprofile.faulttolerance.Timeout;


@RequestScoped
public class PrimerjalnikCenMetadataBean {

    private Logger log = Logger.getLogger(PrimerjalnikCenMetadataBean.class.getName());

    @Inject
    private EntityManager em;

    private Client httpClient;
    private String baseUrl;

    @PostConstruct
    private void init() {
        httpClient = ClientBuilder.newClient();
        baseUrl = "http://20.73.139.35/"; // ingress
    }

    @Timeout(value = 2, unit = ChronoUnit.SECONDS)
    @CircuitBreaker(requestVolumeThreshold = 3)
    @Fallback(fallbackMethod = "getIzdelkiByNazivFallback")
    public Response getIzdelkiByNaziv(String naziv) {

        log.info("Calling users service: getting user's id.");

        try {
            return httpClient
                    .target(baseUrl + "izdelki/v1/izdelki/byNaziv/" + naziv)
                    .request().get();
        }
        catch (WebApplicationException | ProcessingException e) {
            log.severe(e.getMessage());
            throw new InternalServerErrorException(e);
        }
    }

    @Timeout(value = 2, unit = ChronoUnit.SECONDS)
    @CircuitBreaker(requestVolumeThreshold = 3)
    @Fallback(fallbackMethod = "changeCurrencyFallback")
    public Response changeCurrency(String from, String to, Integer amount) {

        log.info("Calling currency API from RapidAPI marketplace");

        try {
            return httpClient
                    .target("https://currency-converter5.p.rapidapi.com/currency/convert")
                    .queryParam("format", "json")
                    .queryParam("from", from)
                    .queryParam("to", to)
                    .queryParam("amount", amount)
                    .queryParam("language", "en")
                    .request()
                    .header("X-RapidAPI-Key", "89fb19875bmsh587f5c2b402a175p14f26fjsnb4cb50778b70")
                    .header("X-RapidAPI-Host", "currency-converter5.p.rapidapi.com")
                    .get();
        }
        catch (WebApplicationException | ProcessingException e) {
            log.severe(e.getMessage());
            throw new InternalServerErrorException(e);
        }
    }

    public Response changeCurrencyFallback() { return null; }

    public Response getIzdelkiByNazivFallback(String username) {
        return null;
    }

    private void beginTx() {
        if (!em.getTransaction().isActive()) {
            em.getTransaction().begin();
        }
    }

    private void commitTx() {
        if (em.getTransaction().isActive()) {
            em.getTransaction().commit();
        }
    }

    private void rollbackTx() {
        if (em.getTransaction().isActive()) {
            em.getTransaction().rollback();
        }
    }
}
