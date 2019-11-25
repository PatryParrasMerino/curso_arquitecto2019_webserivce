package dao;

import org.springframework.data.jpa.repository.JpaRepository;

import model.Hotel;

public interface DaoHoteles extends JpaRepository<Hotel, Integer> {

}
