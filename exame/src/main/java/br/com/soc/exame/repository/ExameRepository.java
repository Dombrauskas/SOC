package br.com.soc.exame.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.soc.exame.model.Exame;

public interface ExameRepository extends JpaRepository<Exame, Long> {

}
