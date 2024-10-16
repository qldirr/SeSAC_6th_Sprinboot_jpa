package codingon.spring_boot_jpa.service;

import codingon.spring_boot_jpa.dto.BoardDTO;
import codingon.spring_boot_jpa.dto.UserDTO;
import codingon.spring_boot_jpa.entity.Board;
import codingon.spring_boot_jpa.entity.User;
import codingon.spring_boot_jpa.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BoardService {
    @Autowired
    private BoardRepository boardRepository;

    // 리스트 조회
    public List<BoardDTO> getAllBoards() {
        List<Board> boards = boardRepository.findAll();
        List<BoardDTO> boardDTOS = new ArrayList<>();
        for (Board board : boards) {
            BoardDTO boardDTO = convertToDTO(board);
            boardDTOS.add(boardDTO);
        }
        return boardDTOS;
    }

    // 단건 조회
    public BoardDTO getBoard(Long id){
        Board board = boardRepository.findById(id).orElse(null);
        if (board == null){
            throw new RuntimeException("Board not found");
        }
        return convertToDTO(board);
    }

    // 생성
    public void createBoard(BoardDTO boardDTO) {
        Board board = convertToEntity(boardDTO);
        boardRepository.save(board);
    }

    // 수정
    public void updateBoard(Long id, BoardDTO boardDTO) {
        Board board = convertToEntityWithId(id, boardDTO);
        boardRepository.save(board);
    }

    // 삭제
    public void deleteBoard(Long id) {
        boardRepository.deleteById(id);
    }

    private BoardDTO convertToDTO(Board board) {
        return BoardDTO.builder().id(board.getId())
                .writer(board.getWriter())
                .title(board.getTitle())
                .content(board.getContent())
                .no((int) (board.getId() + 100))
                .build();
    }

    // dto to domain
    private Board convertToEntity(BoardDTO dto) {
        return Board.builder()
                .id(dto.getId())
                .title(dto.getTitle())
                .content(dto.getContent())
                .build();
    }

    private Board convertToEntityWithId(Long id, BoardDTO dto) {
        return Board.builder()
                .id(id)
                .title(dto.getTitle())
                .content(dto.getContent())
                .build();
    }
}

