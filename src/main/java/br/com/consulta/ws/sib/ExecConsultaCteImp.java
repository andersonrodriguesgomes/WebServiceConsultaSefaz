package br.com.consulta.ws.sib;

import java.net.URL;

import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.util.AXIOMUtil;

import br.inf.portalfiscal.www.cte.wsdl.cteconsulta.CteConsultaStub;
import br.inf.portalfiscal.www.cte.wsdl.ctestatusservico.CteStatusServicoStub;

public class ExecConsultaCteImp extends SetCertificadoImpl {

	private String versao;
	private String uf;
	private String chCTe;
	private String webService;

	public String motaXmlConsultaStatusServico() {
		StringBuilder xml = new StringBuilder();
		xml.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>")
				.append("<consStatServCte versao=\"" + this.versao
						+ "\" xmlns=\"http://www.portalfiscal.inf.br/cte\">")
				.append("<tpAmb>1</tpAmb>").append("<xServ>STATUS</xServ>")
				.append("</consStatServCte>");

		return xml.toString();
	}

	public String motaXmlConsultaSituacaoCte() {
		StringBuilder xml = new StringBuilder();
		xml.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>")
				.append("<consSitCTe versao=\"" + this.versao
						+ "\" xmlns=\"http://www.portalfiscal.inf.br/cte\">")
				.append("<tpAmb>1</tpAmb>").append("<xServ>CONSULTAR</xServ>")
				.append("<chCTe>" + this.chCTe + "</chCTe>")
				.append("</consSitCTe>");
		return xml.toString();
	}

	public String consultaStatus() {

		String retorno = null;

		try {

			URL url = new URL(this.webService);

			CteStatusServicoStub.CteDadosMsg dadosMsg = new CteStatusServicoStub.CteDadosMsg();
			dadosMsg.setExtraElement(AXIOMUtil
					.stringToOM(motaXmlConsultaStatusServico()));

			CteStatusServicoStub.CteCabecMsg cteCabecMsg = new CteStatusServicoStub.CteCabecMsg();

			cteCabecMsg.setCUF(this.uf);
			cteCabecMsg.setVersaoDados(this.versao);

			CteStatusServicoStub.CteCabecMsgE cteCabecMsgE = new CteStatusServicoStub.CteCabecMsgE();
			cteCabecMsgE.setCteCabecMsg(cteCabecMsg);

			CteStatusServicoStub stub = new CteStatusServicoStub(url.toString());
			CteStatusServicoStub.CteStatusServicoCTResult result = stub
					.cteStatusServicoCT(dadosMsg, cteCabecMsgE);

			retorno = result.getExtraElement().toString();

		} catch (Exception e) {
			e.printStackTrace();
			retorno = e.toString();
		}

		return retorno;
	}

	public String ConsultaSituacaoCTe() {

		String retorno = null;

		try {

			URL url = new URL(this.webService);

			/**
			 * Xml de Consulta.
			 */

			OMElement ome = AXIOMUtil.stringToOM(motaXmlConsultaSituacaoCte());

			CteConsultaStub.CteDadosMsg dadosMsg = new CteConsultaStub.CteDadosMsg();
			dadosMsg.setExtraElement(ome);

			CteConsultaStub.CteCabecMsg cteCabecMsg = new CteConsultaStub.CteCabecMsg();

			/**
			 * Codigo do Estado.
			 */
			cteCabecMsg.setCUF(this.uf);

			/**
			 * Versao do XML
			 */
			cteCabecMsg.setVersaoDados(this.versao);

			CteConsultaStub.CteCabecMsgE cteCabecMsgE = new CteConsultaStub.CteCabecMsgE();
			cteCabecMsgE.setCteCabecMsg(cteCabecMsg);

			CteConsultaStub stub = new CteConsultaStub(url.toString());
			CteConsultaStub.CteConsultaCTResult result = stub.cteConsultaCT(
					dadosMsg, cteCabecMsgE);

			retorno = result.getExtraElement().toString();

		} catch (Exception e) {
			e.printStackTrace();
			retorno = e.toString();

		}
		return retorno;
	}

	/**
	 * @param log
	 */

	public String getVersao() {
		return versao;
	}

	public void setVersao(String versao) {
		this.versao = versao;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public String getWebService() {
		return webService;
	}

	public void setWebService(String webService) {
		this.webService = webService;
	}

	public String getChCTe() {
		return chCTe;
	}

	public void setChCTe(String chCTe) {
		this.chCTe = chCTe;
	}

}
