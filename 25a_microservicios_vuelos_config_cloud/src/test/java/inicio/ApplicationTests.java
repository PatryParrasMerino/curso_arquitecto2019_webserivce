package inicio;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
class ApplicationTests {
	@Autowired
	MockMvc mock;

	@Test
	void testVuelosDisponiblesOk() throws Exception {
		mock.perform(get("/disponibilidadVuelos/4")).andDo(print());
	}
	@Test
	void testVuelosDisponiblesBad() throws Exception {
		mock.perform(get("/disponibilidadVuelos/100")).andDo(print());
	}
	@Test
	void testActualizarPlazasOK() throws Exception {
		mock.perform(put("/actualizarPlazas/2/10")).andDo(print());
	}
	@Test
	void testActualizarPlazasBad() throws Exception {
		mock.perform(put("/actualizarPlazas/10/10")).andDo(print());
	}

}
