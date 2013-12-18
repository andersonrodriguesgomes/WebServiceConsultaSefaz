package br.com.consulta.ws.sib;

import java.io.FileInputStream;
import java.io.IOException;
import java.security.Security;
import java.util.Properties;

public class SetCertificadoImpl {

	private String sistOper;
	private Properties props = new Properties();
	private String ptRaiz;

	public SetCertificadoImpl() {
		this.sistOper = String.valueOf(System.getProperties().get("os.name"));
		buscaPtRaiz();

		try {
			props = lerProperties();
			setSystem();
		} catch (IOException e) {
			e.printStackTrace();

		}

	}

	public void setSystem() {

		System.setProperty("java.protocol.handler.pkgs",
				"com.sun.net.ssl.internal.www.protocol");

		Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());

		System.clearProperty("javax.net.ssl.keyStore");

		System.clearProperty("javax.net.ssl.keyStorePassword");

		System.clearProperty("javax.net.ssl.trustStore");

		if (this.sistOper.toLowerCase().contains("windows")) {

			System.setProperty("javax.net.ssl.trustStore", getProps()
					.getProperty("arquivoTrustStoreProdWindows"));

			System.setProperty("javax.net.ssl.keyStore", getProps()
					.getProperty("arquivoKeyStoreWindows"));

		} else {

			System.setProperty("javax.net.ssl.trustStore", getProps()
					.getProperty("arquivoTrustStoreProdLinux"));

			System.setProperty("javax.net.ssl.keyStore", getProps()
					.getProperty("arquivoKeyStoreLinux"));

		}

		System.setProperty("javax.net.ssl.keyStorePassword", getProps()
				.getProperty("senhaKeyStore"));

		System.setProperty("javax.net.ssl.trustStorePassword", getProps()
				.getProperty("senhaTrustStoreProd"));

		System.setProperty("javax.net.ssl.keyStoreType", getProps()
				.getProperty("keyStoreType"));

	}

	public Properties getProps() {
		return props;
	}

	public void setProps(Properties props) {
		this.props = props;
	}

	public Properties lerProperties() throws IOException {

		Properties props = new Properties();

		FileInputStream file = new FileInputStream(this.ptRaiz
				+ "SynConfig.properties");

		props.load(file);

		return props;

	}

	public void buscaPtRaiz() {

		if (this.ptRaiz == null) {

			this.ptRaiz = System.getProperty("user.dir");

			if (this.ptRaiz.contains("bin")) {

				if (this.sistOper.toLowerCase().contains("windows")) {

					this.ptRaiz = this.ptRaiz.substring(0,
							this.ptRaiz.indexOf("\\bin"))
							+ "\\appclient\\conf\\";

				} else

					this.ptRaiz = this.ptRaiz.substring(0,
							ptRaiz.indexOf("/bin"))
							+ "/appclient/conf/";
			} else
				this.ptRaiz = "C:\\Synchro\\Synchro_Recebimento_Avancado_Oracle_R12\\jboss7\\appclient\\conf\\";

		}

	}

}
