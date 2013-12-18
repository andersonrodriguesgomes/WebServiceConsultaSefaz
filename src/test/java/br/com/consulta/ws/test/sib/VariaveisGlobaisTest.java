package br.com.consulta.ws.test.sib;

import org.junit.Assert;
import org.junit.Test;

import br.com.consulta.ws.sib.VariaveisGlobaisImpl;

public class VariaveisGlobaisTest {
	@Test
	public void sequenciaTestSetPropertiesWebService() {
		new VariaveisGlobaisImpl();
		Assert.assertEquals(
				"https://nfe.fazenda.sp.gov.br/cteWEB/services/cteConsulta.asmx",
				VariaveisGlobaisImpl.WEB_SERVICE_CTE_SEFAZ
						.getProperty("uf35ProdSefaz"));
	}

	@Test
	public void sequenciaTestSetPropertiesUfInexistenteWebService() {
		new VariaveisGlobaisImpl();
		Assert.assertEquals(null, VariaveisGlobaisImpl.WEB_SERVICE_CTE_SEFAZ
				.getProperty("uf54ProdSefaz"));
	}

	@Test
	public void sequenciaTestSetPropertiesCertificado() {
		new VariaveisGlobaisImpl();
		Assert.assertEquals("sefaz",
				VariaveisGlobaisImpl.PROPERTIES_CERTIFICADOS
						.getProperty("senhaTrustStoreProd"));
	}

	@Test
	public void sequenciaTestSetPropertiesValoresInexistentesCertificado() {
		new VariaveisGlobaisImpl();
		Assert.assertEquals(null, VariaveisGlobaisImpl.PROPERTIES_CERTIFICADOS
				.getProperty("arquivoTrustStoreHomoWindowsTeste"));
	}
}
