package si.rsvo.primerjalnikcen.models.converters;

import si.rsvo.primerjalnikcen.lib.IzdelkiMetadata;
import si.rsvo.primerjalnikcen.models.entities.UporabnikoviIzdelkiMetadataEntity;

public class UporabnikoviIzdelkiMetadataConverter {

    public static IzdelkiMetadata toDto(UporabnikoviIzdelkiMetadataEntity entity) {

        IzdelkiMetadata dto = new IzdelkiMetadata();
        dto.setId(entity.getId());
        dto.setUporabnikId(entity.getUporabnikId());
        dto.setIzdelekId(entity.getIzdelekId());

        return dto;

    }

    public static UporabnikoviIzdelkiMetadataEntity toEntity(IzdelkiMetadata dto) {

        UporabnikoviIzdelkiMetadataEntity entity = new UporabnikoviIzdelkiMetadataEntity();
        entity.setId(dto.getId());
        entity.setUporabnikId(dto.getUporabnikId());
        entity.setIzdelekId(dto.getIzdelekId());

        return entity;

    }

}
