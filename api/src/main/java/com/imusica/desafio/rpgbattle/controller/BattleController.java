package com.imusica.desafio.rpgbattle.controller;

import com.imusica.desafio.rpgbattle.controller.dto.BattleDTO;
import com.imusica.desafio.rpgbattle.domain.Battle;
import com.imusica.desafio.rpgbattle.domain.BattleResult;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("api/battle")
public class BattleController {

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> battle(@RequestBody @Valid BattleDTO dto) {
        Battle battle = dto.newBattle();
        BattleResult result = battle.start();

        return ResponseEntity.ok(result);
    }
}
