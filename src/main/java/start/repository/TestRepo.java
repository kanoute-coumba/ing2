package start.repository;


import start.model.Test;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
    public interface TestRepo extends JpaRepository<Test, Integer> {
    }