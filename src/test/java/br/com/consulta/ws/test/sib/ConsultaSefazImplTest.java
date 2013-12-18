package br.com.consulta.ws.test.sib;

import org.junit.Assert;
import org.junit.Test;

import br.com.consulta.ws.sib.ConsultaSefazImpl;

public class ConsultaSefazImplTest {
	@Test
	public void consultaStatusTesteSimples() {
		ConsultaSefazImpl consultaSefaz = new ConsultaSefazImpl();
		Assert.assertNotNull(consultaSefaz.consultaStatus("35", "1.04"));
	}
}
