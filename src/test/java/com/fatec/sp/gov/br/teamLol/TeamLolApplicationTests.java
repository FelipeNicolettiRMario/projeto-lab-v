package com.fatec.sp.gov.br.teamLol;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.HashSet;

import com.fatec.sp.gov.br.teamLol.entity.Coach;
import com.fatec.sp.gov.br.teamLol.entity.Jogador;
import com.fatec.sp.gov.br.teamLol.entity.Time;
import com.fatec.sp.gov.br.teamLol.repository.CoachRepository;
import com.fatec.sp.gov.br.teamLol.repository.JogadorRepository;
import com.fatec.sp.gov.br.teamLol.repository.TimeRepository;

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

    @Autowired
    private CoachRepository coachRepo;

    @Autowired
    private TimeRepository timeRepo;

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

    @Test
    void testaInsercaoJogadorComTime(){
        Time time = new Time();
        time.setNome("Vivo Keyd");

        timeRepo.save(time);

        Jogador jogador = new Jogador();
        jogador.setNick("Varian");
        jogador.setRank("Platina");
        jogador.setTime(time);

        assertNotNull(jogador.getTime().getId());
    }

    @Test
    void testaInsercaoCoach(){
        Coach coach = new Coach();
        coach.setNome("Invictus");
        
        coachRepo.save(coach);

        assertNotNull(coach.getId());
    }

    @Test
    void testaInsercaoTime(){
        Time time = new Time();
        time.setNome("Pain");

        timeRepo.save(time);

        assertNotNull(time.getId());
    }

    @Test 
    void testaInsercaoTimeComCoach(){
        Coach coach = new Coach();
        coach.setNome("Invicutos");

        coachRepo.save(coach);

        Time time = new Time();
        time.setNome("Pain");
        time.setCoach(coach);

        timeRepo.save(time);

        assertNotNull(time.getCoach());

    }

    @Test
    void testaInsercaoTimeComJogador(){
        Time time = new Time();
        time.setNome("T1");
        time.setJogadores(new HashSet<Jogador>());

        Jogador jogador = new Jogador();
        jogador.setNick("Aslan");
        jogador.setRank("Ouro");

        jogadorRepo.save(jogador);

        time.getJogadores().add(jogador);

        assertEquals("Aslan",time.getJogadores().iterator().next().getNick());
    }

}
