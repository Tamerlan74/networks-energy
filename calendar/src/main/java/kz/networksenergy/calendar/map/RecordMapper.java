package kz.networksenergy.calendar.map;

import kz.networksenergy.calendar.dto.request.RecordRequest;
import kz.networksenergy.calendar.dto.response.RecordResponse;
import kz.networksenergy.calendar.entity.Record;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface RecordMapper {

    List<RecordResponse> toListResponse(List<Record> records);

    RecordResponse toResponse(Record recordEntity);

    Record toEntity(RecordRequest request);

    Record toUpdateEntity(RecordRequest request, Long id);
}
