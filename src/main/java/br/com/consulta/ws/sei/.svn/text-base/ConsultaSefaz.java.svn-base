package br.com.consulta.ws.sei;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

@WebService
@SOAPBinding(style = Style.RPC)
public interface ConsultaSefaz {

	@WebMethod
	String consultaStatus(String uf, String versao);

	@WebMethod
	String consultaCTE(String uf, String versao, String chAcesso);

}
