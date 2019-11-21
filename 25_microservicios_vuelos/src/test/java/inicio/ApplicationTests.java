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
	void testVuelosDisponiblesok() throws Exception {
		mock.perform(get("/disponibilidadvuelos/4")).andDo(print());
	}

	@Test
	void testVuelosDisponiblesbad() throws Exception {
		mock.perform(get("/disponibilidadvuelos/100")).andDo(print());
	}
	
	@Test
	void testactualizarPlazasOk() throws Exception {
		mock.perform(put("/actualizarplazas/2/10")).andDo(print());
	}
	@Test
	void testactualizarPlazasBad() throws Exception {
		mock.perform(put("/actualizarplazas/10/10")).andDo(print());
	}
}
