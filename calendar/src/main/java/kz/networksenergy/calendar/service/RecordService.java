package kz.networksenergy.calendar.service;

import kz.networksenergy.calendar.dto.request.RecordRequest;
import kz.networksenergy.calendar.dto.response.RecordResponse;
import kz.networksenergy.calendar.entity.Record;
import kz.networksenergy.calendar.exception.RecordNotFoundException;
import kz.networksenergy.calendar.map.RecordMapper;
import kz.networksenergy.calendar.repository.RecordRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class RecordService {

    private final RecordRepository recordRepository;
    private final RecordMapper mapper;

    public RecordService(RecordRepository recordRepository, RecordMapper mapper) {
        this.recordRepository = recordRepository;
        this.mapper = mapper;
    }

    @Transactional(readOnly = true)
    public List<RecordResponse> getAllRecords() {
        List<Record> records = recordRepository.findAll();
        return mapper.toListResponse(records);
    }

    @Transactional(readOnly = true)
    public RecordResponse getRecord(Long id) {
        Record recordEntity = recordRepository.findById(id).orElseThrow(() -> new RecordNotFoundException(id));
        return mapper.toResponse(recordEntity);
    }

    public Long createRecord(RecordRequest request) {
        Record recordEntity = mapper.toEntity(request);
        return recordRepository.save(recordEntity).getId();
    }

    public RecordResponse updateRecord(Long id, RecordRequest request) {
        Record recordEntity = mapper.toUpdateEntity(request, id);
        Record updatedEntity = recordRepository.save(recordEntity);
        return mapper.toResponse(updatedEntity);
    }

    public void deleteRecord(Long id) {
        recordRepository.deleteById(id);
    }
}
