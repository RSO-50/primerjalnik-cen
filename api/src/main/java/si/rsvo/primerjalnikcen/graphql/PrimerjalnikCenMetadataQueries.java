package si.rsvo.primerjalnikcen.graphql;

import com.kumuluz.ee.graphql.annotations.GraphQLClass;

import javax.enterprise.context.ApplicationScoped;

@GraphQLClass
@ApplicationScoped
public class PrimerjalnikCenMetadataQueries {
/*
    @Inject
    private PrimerjalnikCenMetadataBean primerjalnikCenMetadataBean;

    @GraphQLQuery
    public PaginationWrapper<UporabnikoviIzdelkiMetadata> allUporabnikovaShrambaMetadata(
             @GraphQLArgument(name = "pagination") Pagination pagination,
             @GraphQLArgument(name = "sort") Sort sort,
             @GraphQLArgument(name = "filter") Filter filter) {

        return GraphQLUtils.process(primerjalnikCenMetadataBean.getUporabnikoviIzdelkiMetadata(), pagination, sort, filter);
    }

    @GraphQLQuery
    public List<UporabnikoviIzdelkiMetadata> getUporabnikoviIzdelkiMetadata(@GraphQLArgument(name = "id") Integer id) {
        return primerjalnikCenMetadataBean.getIzdelkiByUporabnik(id);
    }*/

}
