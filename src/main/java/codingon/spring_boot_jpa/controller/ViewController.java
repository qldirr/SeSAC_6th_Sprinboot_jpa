package codingon.spring_boot_jpa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

// 템플릿 엔진을 렌더링하는 코드들
@Controller
public class ViewController {

    // GET / 요청시 /users 경로로 리다이렉트
    @GetMapping("/")
    public String redirectToUsers() {
        return "redirect:/users";
    }

    // GET /users 요청시 userList.html 템플릿 뷰 반환
    @GetMapping("/users")
    public String listUsers() {
        return "userList";
    }

    // GET /users/new 요청시 userForm.html 템플릿 뷰 반환
    @GetMapping("/users/new")
    public String newUserForm() {
        return "userForm";
    }

    // GET /users/{id}/new 요청시 userForm.html 템플릿 뷰 반환 ("기존 유저 정보 수정")
    @GetMapping("/users/{id}/edit")
    public String editUserForm() {
        return "userForm";
    }

//    @GetMapping("/")
//    public String redirectToBoards() {
//        return "redirect:/boards";
//    }

    @GetMapping("/boards")
    public String listBoards() {
        return "boardList";
    }

    @GetMapping("/boards/new")
    public String newBoardForm() {
        return "boardForm";
    }

    @GetMapping("/boards/{id}/edit")
    public String editBoardForm() {
        return "boardForm";
    }
}

