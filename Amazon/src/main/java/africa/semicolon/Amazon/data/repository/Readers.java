package africa.semicolon.Amazon.data.repository;

import africa.semicolon.Amazon.data.model.Reader;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Readers extends JpaRepository<Reader, Integer> {
}
