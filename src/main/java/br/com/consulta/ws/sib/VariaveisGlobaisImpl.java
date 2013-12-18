package br.com.consulta.ws.sib;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class VariaveisGlobaisImpl {

	public static Properties WEB_SERVICE_CTE_SEFAZ = new Properties();
	public static Properties PROPERTIES_CERTIFICADOS;

	public VariaveisGlobaisImpl() {
		setPropertiesCertificados();
		setWebServiceCteSefaz();
	}

	public Properties carregaProperties(String arquivo) {
		Properties props = new Properties();
		try {

			InputStream in = this.getClass().getResourceAsStream(arquivo);
			props.load(in);

		} catch (FileNotFoundException e) {

			e.printStackTrace();

		} catch (IOException e) {

			e.printStackTrace();
		}

		return props;

	}

	public void setPropertiesCertificados() {
		PROPERTIES_CERTIFICADOS = carregaProperties("SynConfig.properties");
	}

	public void setWebServiceCteSefaz() {

		WEB_SERVICE_CTE_SEFAZ = carregaProperties("CteWebServices.properties");

	}

}
