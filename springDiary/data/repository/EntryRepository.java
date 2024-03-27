package springDiary.data.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import springDiary.data.model.Entry;


@Repository
public interface EntryRepository extends MongoRepository<Entry , String> {


}
