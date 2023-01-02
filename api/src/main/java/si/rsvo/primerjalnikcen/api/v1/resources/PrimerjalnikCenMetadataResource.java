package si.rsvo.primerjalnikcen.api.v1.resources;

import com.kumuluz.ee.logs.cdi.Log;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.enums.SchemaType;
import org.eclipse.microprofile.openapi.annotations.headers.Header;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.parameters.Parameter;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponses;
import si.rsvo.primerjalnikcen.lib.IzdelkiMetadata;
import si.rsvo.primerjalnikcen.services.beans.PrimerjalnikCenMetadataBean;


import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.logging.Logger;


@Log
@ApplicationScoped
@Path("/primerjalnikCen")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PrimerjalnikCenMetadataResource {

    private Logger log = Logger.getLogger(PrimerjalnikCenMetadataResource.class.getName());

    @Inject
    private PrimerjalnikCenMetadataBean primerjalnikCenMetadataBean;

    @Operation(description = "Get izdelki by naziv", summary = "Get all izdelki by given naziv")
    @APIResponses({
            @APIResponse(responseCode = "200",
                    description = "List of izdelki",
                    content = @Content(schema = @Schema(implementation = IzdelkiMetadata.class, type = SchemaType.ARRAY)),
                    headers = {@Header(name = "X-Total-Count", description = "Number of objects in list")}
            )})
    @GET
    @Path("/byNaziv/{naziv}")
    public Response getUporabnikovaShrambaIzdelkovByUsername(@Parameter(description = "Naziv izdelka.", required = true)
                                                             @PathParam("naziv") String naziv) {

        return primerjalnikCenMetadataBean.getIzdelkiByNaziv(naziv);
    }

    @POST
    @Path("/changeCurrency/{from}/{to}/{amount}")
    public Response changeCurrency(@Parameter(description = "Prvotna valuta", required = true) @PathParam("from") String from,
                                   @Parameter(description = "Željena valuta", required = true) @PathParam("to") String to,
                                   @Parameter(description = "Količina", required = true) @PathParam("amount") Integer amount) {
        System.out.println(from);
        System.out.println(to);
        System.out.println(amount);

        return primerjalnikCenMetadataBean.changeCurrency(from, to, amount);
    }
}
