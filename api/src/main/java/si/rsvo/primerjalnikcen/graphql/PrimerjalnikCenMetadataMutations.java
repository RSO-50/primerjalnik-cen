package si.rsvo.primerjalnikcen.graphql;

import com.kumuluz.ee.graphql.annotations.GraphQLClass;
import io.leangen.graphql.annotations.GraphQLArgument;
import io.leangen.graphql.annotations.GraphQLMutation;
import si.rsvo.primerjalnikcen.services.beans.PrimerjalnikCenMetadataBean;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@GraphQLClass
@ApplicationScoped
public class PrimerjalnikCenMetadataMutations {
    /*@Inject
    private PrimerjalnikCenMetadataBean primerjalnikCenMetadataBean;

    @GraphQLMutation
    public PrimerjalnikCenMetadata addPrimerjalnikCenMetadata(@GraphQLArgument(name = "primerjevalnikCenMetadata") PrimerjalnikCenMetadata primerjevalnikCenMetadata) {
        primerjalnikCenMetadataBean.createUporabnikoviIzdelkiMetadata(primerjevalnikCenMetadata);
        return primerjevalnikCenMetadata;
    }

    @GraphQLMutation
    public DeleteResponse deletePrimerjalnikCenMetadata(@GraphQLArgument(name = "uporabnikId") Integer uporabnikId,
                                                            @GraphQLArgument(name = "izdelekId") Integer izdelekId) {
        return new DeleteResponse(primerjalnikCenMetadataBean.deleteUporabnikoviIzdelkiMetadata(uporabnikId, izdelekId));
    }*/
}
