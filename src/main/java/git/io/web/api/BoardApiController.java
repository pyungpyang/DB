package git.io.web.api;

import git.io.web.board.Board;
import git.io.web.board.BoardRepository;
import git.io.web.board.BoardRepository.Request;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/board")
@RequiredArgsConstructor
public class BoardApiController {
    private final BoardRepository repository;

    @GetMapping("/create")
    @ResponseStatus(CREATED)
    public void create(
            String title,
            String content,
            String author) {
        repository.create(new Request(title,content,author));
    }
    @GetMapping()
    @ResponseStatus(OK)
    public ResponseEntity<Page<Board>> paged(
            Pageable pageable) {
        return ResponseEntity.status(OK)
                .body(repository.findAll(pageable));
    }

    @GetMapping("/{id}")
    @ResponseStatus(OK)
    public ResponseEntity<Board> findId(
            @PathVariable("id") Long id) {
        return ResponseEntity.status(OK)
                .body(repository.findById(id));
    }
}
