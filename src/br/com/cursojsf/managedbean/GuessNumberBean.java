package br.com.cursojsf.managedbean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIInput;

@SessionScoped
@ManagedBean(name = "guessBean")
public class GuessNumberBean {
	/** Numero a ser adivinado. */
	private Integer numero;
	/** Palpite do usuário. */
	private Integer palpite;
	/** Tentativas. */
	private Integer tentativas;
	/** Mensagem de erro. */
	private String mensagem;
	/** Input do palpite. */
	private UIInput palpiteInput;
	
	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public Integer getPalpite() {
		return palpite;
	}

	public void setPalpite(Integer palpite) {
		this.palpite = palpite;
	}

	public Integer getTentativas() {
		return tentativas;
	}

	public void setTentativas(Integer tentativas) {
		this.tentativas = tentativas;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public UIInput getPalpiteInput() {
		return palpiteInput;
	}

	public void setPalpiteInput(UIInput palpiteInput) {
		this.palpiteInput = palpiteInput;
	}
	
	public String init() {
		numero = (int) (1 + (Math.random() * 100));
		palpite = null;
		tentativas = 0;
		mensagem = "page.guess.label.branco";
		if (palpiteInput != null) {
			palpiteInput.setRendered(true);
		}
		return "guess";
	}

	public String guess() {
		if (palpite.equals(numero)) {
			mensagem = "page.guess.acerto";
			palpiteInput.setRendered(false);
		} else if (numero.compareTo(palpite) < 0) {
			mensagem = "page.guess.menor";
		} else {
			mensagem = "page.guess.maior";
		}
		tentativas++;
		return "guess";
	}

}