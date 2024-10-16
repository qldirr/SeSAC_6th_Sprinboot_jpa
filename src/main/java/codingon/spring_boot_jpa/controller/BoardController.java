package codingon.spring_boot_jpa.controller;
import codingon.spring_boot_jpa.dto.BoardDTO;
import codingon.spring_boot_jpa.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.nio.file.AccessDeniedException;
import java.util.List;

@RestController
@RequestMapping("/api/boards")
public class BoardController {
    @Autowired
    BoardService boardService;

    // 리스트
    @GetMapping
    public List<BoardDTO> getAllBoard(){
        return boardService.getAllBoards();
    }

    // 단건 조회
    @GetMapping("/{id}")
    public BoardDTO getBoard(@PathVariable Long id){
        return boardService.getBoard(id);
    }

    // 생성
    @PostMapping
    public BoardDTO createBoard(@RequestBody BoardDTO boardDTO) {
        boardService.createBoard(boardDTO);
        return boardDTO;
    }

    // 수정
    @PutMapping("/{id}")
    public BoardDTO updateBoard(@PathVariable Long id, @RequestBody BoardDTO boardDTO) {
        boardService.updateBoard(id, boardDTO);
        return boardDTO;
    }

    // 삭제
    @DeleteMapping("/{id}")
    public void deleteBoard(@PathVariable Long id){
        boardService.deleteBoard(id);
    }

}
