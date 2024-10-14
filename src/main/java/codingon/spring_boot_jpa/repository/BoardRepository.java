package codingon.spring_boot_jpa.repository;

import codingon.spring_boot_jpa.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board, Long> {
}
