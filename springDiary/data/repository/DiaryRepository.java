package springDiary.data.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import springDiary.data.model.Diary;

import java.util.Optional;

@Repository
public interface DiaryRepository extends MongoRepository<Diary,String >{
    Optional<Diary> findDiaryByUsername(String username);
    void deleteByUsername(String username);

}
