package mystudy.mystudyspring.domain.test.service;

import mystudy.mystudyspring.domain.test.dao.TestRepository;
import mystudy.mystudyspring.domain.test.domain.TestData;
import mystudy.mystudyspring.domain.test.dto.mapper.TestDataMapper;
import mystudy.mystudyspring.domain.test.dto.request.TestDataCreateRequestDto;
import mystudy.mystudyspring.domain.test.dto.request.TestDataUpdateRequestDto;
import mystudy.mystudyspring.domain.test.exception.NotFoundTestDataEntityException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor // final 멤버 변수용 생성자
public class TestService {

    private final TestRepository testRepository;
    private final TestDataMapper mapper;

    public TestData create(TestDataCreateRequestDto dto){

        TestData entity = mapper.toEntity(dto);
        return testRepository.save(entity);
    }

    public TestData findById(UUID id) {
        return findTestDataById(id);
    }

    public void deleteById(UUID id){
        testRepository.deleteById(id);
    }

    public TestData update(TestDataUpdateRequestDto dto) {
        TestData newTestData = findTestDataById(dto.getId());
        newTestData.update(dto.getName(), dto.getContent());
        return testRepository.save(newTestData);
    }

    private TestData findTestDataById(UUID id) {
        return testRepository.findById(id).orElseThrow(
                NotFoundTestDataEntityException::new
        );
    }

}
