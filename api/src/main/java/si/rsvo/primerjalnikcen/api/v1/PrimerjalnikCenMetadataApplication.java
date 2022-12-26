package si.rsvo.primerjalnikcen.api.v1;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;


import org.eclipse.microprofile.openapi.annotations.OpenAPIDefinition;
import org.eclipse.microprofile.openapi.annotations.info.Contact;
import org.eclipse.microprofile.openapi.annotations.info.Info;
import org.eclipse.microprofile.openapi.annotations.info.License;
import org.eclipse.microprofile.openapi.annotations.servers.Server;

@OpenAPIDefinition(info = @Info(title = "Primerjalnik cen API", version = "v1",
        contact = @Contact(email = "rso.skupina50@gmail.com"),
        license = @License(name = "dev"), description = "API for comparing prices."),
        servers = @Server(url = "http://20.73.139.35/primerjalnik-cen/"))
@ApplicationPath("/v1")
public class PrimerjalnikCenMetadataApplication extends Application {

}
