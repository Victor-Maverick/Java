package springDiary.data.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import springDiary.data.model.Entry;

import java.util.Optional;


@Repository
public interface EntryRepository extends MongoRepository<Entry , String> {


    Optional<Entry> findByTitle(String title);

    boolean findEntryByAuthor(String author);

    void deleteByTitleAndAuthor(String title, String author);
}
