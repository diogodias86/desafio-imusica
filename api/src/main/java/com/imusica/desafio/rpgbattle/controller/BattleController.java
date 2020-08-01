package com.imusica.desafio.rpgbattle.controller;

import com.imusica.desafio.rpgbattle.controller.dto.BattleDTO;
import com.imusica.desafio.rpgbattle.domain.Battle;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("api/battle")
public class BattleController {

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> battle(@RequestBody @Valid BattleDTO dto) {
        System.out.println(dto.getNickname());
        System.out.println(dto.getHerotype());

        Battle battle = dto.newBattle();
        battle.start();

        return ResponseEntity
                .ok()
                .build();
    }
}
