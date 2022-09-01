package git.io.web.board;

import git.io.web.board.jpa.BoardJpaRepository;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

public interface BoardRepository {
    void create(Request request);

    Board findById(Long id);

    Page<Board> findAll(Pageable pageable);


    @Repository
    @RequiredArgsConstructor
    class BoardRdbmsRepository implements BoardRepository {
        private final BoardJpaRepository repository;

        @Override
        @Transactional
        public void create(Request request) {
            repository.save(Board.of(request.getTitle(), request.getContent(), request.getAuthor()));
        }

        @Override
        public Board findById(Long id) {
            return repository.findById(id)
                    .orElseThrow(() -> new IllegalArgumentException("NOT FOUND"));
        }

        @Override
        public Page<Board> findAll(Pageable pageable) {
            return repository.findAll(pageable);
        }

    }

    @Getter
    @NoArgsConstructor
    class Request {
        private String title;
        private String content;
        private String author;

        public Request(String title, String content, String author) {
            this.title = title;
            this.content = content;
            this.author = author;
        }
    }
}
