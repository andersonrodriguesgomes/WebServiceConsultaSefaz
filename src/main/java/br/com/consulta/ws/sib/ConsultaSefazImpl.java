package br.com.consulta.ws.sib;

import javax.ejb.Stateless;
import javax.jws.WebParam;
import javax.jws.WebService;

import br.com.consulta.ws.sei.ConsultaSefaz;

@Stateless
@WebService(endpointInterface = "br.com.consulta.ws.sei.ConsultaSefaz")
public class ConsultaSefazImpl implements ConsultaSefaz {

	@Override
	public String consultaStatus(@WebParam(name = "uf") String uf,
			@WebParam(name = "versao") String versao) {
		new VariaveisGlobaisImpl();
		ExecConsultaCteImp consultStatus = new ExecConsultaCteImp();
		consultStatus.setWebService(VariaveisGlobaisImpl.WEB_SERVICE_CTE_SEFAZ
				.getProperty("uf" + uf + "ProdSefazServico"));
		consultStatus.setUf(uf);
		consultStatus.setVersao(versao);
		return consultStatus.consultaStatus();
	}

	@Override
	public String consultaCTE(@WebParam(name = "uf") String uf,
			@WebParam(name = "versao") String versao,
			@WebParam(name = "chCTe") String chCTe) {
		new VariaveisGlobaisImpl();
		ExecConsultaCteImp consultStatus = new ExecConsultaCteImp();
		consultStatus.setWebService(VariaveisGlobaisImpl.WEB_SERVICE_CTE_SEFAZ
				.getProperty("uf" + uf + "ProdSefaz"));
		consultStatus.setUf(uf);
		consultStatus.setVersao(versao);
		consultStatus.setChCTe(chCTe);
		return consultStatus.ConsultaSituacaoCTe();
	}

}
