package git.io.web.board.jpa;

import git.io.web.board.Board;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardJpaRepository extends JpaRepository<Board,Long> { }
