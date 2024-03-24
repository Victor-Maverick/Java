package springDiary.data.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import springDiary.data.model.Diary;

import java.util.List;

@Repository
public interface DiaryRepository extends MongoRepository<Diary,String >{
//    Diary save(Diary diary);
//    List<Diary> findAll();
//    Diary findBy(String username);
//    long count();
//    void delete(String username);
//    void delete(Diary diary);
}
