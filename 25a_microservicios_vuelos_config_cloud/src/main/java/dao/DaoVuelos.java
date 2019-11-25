package dao;

import org.springframework.data.jpa.repository.JpaRepository;

import model.Vuelo;

public interface DaoVuelos extends JpaRepository<Vuelo, Integer> {

}
