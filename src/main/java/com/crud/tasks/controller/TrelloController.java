package com.crud.tasks.controller;

import com.crud.tasks.domain.TrelloBoardDto;
import com.crud.tasks.trello.client.TrelloClient;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/trello")
public class TrelloController {

    private final TrelloClient trelloClient;

    public TrelloController(TrelloClient trelloClient) {
        this.trelloClient = trelloClient;
    }

    @GetMapping("/boards")
    public List<TrelloBoardDto> getTrelloBoards() {
        List<TrelloBoardDto> boards = trelloClient.getTrelloBoards();
        return boards.stream()
                .filter(board -> board.getName() != null && board.getName().contains("Kodilla"))
                .collect(Collectors.toList());
    }
}