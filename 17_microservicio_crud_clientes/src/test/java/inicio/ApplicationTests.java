package inicio;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
class ApplicationTests {
	@Autowired
	MockMvc mock;
	@Test
	void testAuthOk() throws Exception {
		mock.perform(get("/opercliente/test1/test1")).andDo(print());
	}
	@Test
	void testAuthBad() throws Exception {
		mock.perform(get("/opercliente/tessdfsdt1/tesdfd")).andDo(print());
	}
	
	/*@Test
	void testAlta() throws Exception{
		mock.perform(post("/opercliente")
				.contentType(MediaType.APPLICATION_JSON)
				.content("{\"email\":\"boot@gmail.com\",\"password\":\"bootmicro\",\"telefono\":77777,\"usuario\":\"bootmicro\"}")
				).andDo(print());
	}*/
	
	@Test
	void eliminar() throws Exception{
		mock.perform(delete("/opercliente/59"));
	}
}
