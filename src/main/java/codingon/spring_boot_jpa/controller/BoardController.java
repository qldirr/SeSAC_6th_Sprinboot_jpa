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

    @GetMapping
    public List<BoardDTO> getAllBoard(){
        return boardService.getAllBoards();
    }

    @GetMapping("/{id}")
    public BoardDTO getUser(@PathVariable Long id){
        return boardService.getBoard(id);
    }
}
