package com.fatec.sp.gov.br.teamLol;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.fatec.sp.gov.br.teamLol.entity.Jogador;
import com.fatec.sp.gov.br.teamLol.repository.JogadorRepository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
@Rollback
class TeamLolApplicationTests {

    @Autowired
    private JogadorRepository jogadorRepo;

	@Test
	void contextLoads() {
    }
    
    @Test
    void testaInsercaoJogador(){
        Jogador jogador = new Jogador();
        jogador.setNick("Nefarian");
        jogador.setRank("Ouro");

        jogadorRepo.save(jogador);

        assertNotNull(jogador.getId());

    }

}
