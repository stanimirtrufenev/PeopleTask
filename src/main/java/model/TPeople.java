package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the t_people database table.
 * 
 */
@Entity
@Table(name="t_people")
@NamedQuery(name="TPeople.findAll", query="SELECT t FROM TPeople t")
public class TPeople implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	@Column(name="FULL_NAME")
	private String fullName;

	private String pin;

	//bi-directional many-to-one association to TAddress
	@OneToMany(mappedBy="TPeople")
	private List<TAddress> TAddresses;

	//bi-directional many-to-one association to TMail
	@OneToMany(mappedBy="TPeople")
	private List<TMail> TMails;

	public TPeople() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFullName() {
		return this.fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getPin() {
		return this.pin;
	}

	public void setPin(String pin) {
		this.pin = pin;
	}

	public List<TAddress> getTAddresses() {
		return this.TAddresses;
	}

	public void setTAddresses(List<TAddress> TAddresses) {
		this.TAddresses = TAddresses;
	}

	public TAddress addTAddress(TAddress TAddress) {
		getTAddresses().add(TAddress);
		TAddress.setTPeople(this);

		return TAddress;
	}

	public TAddress removeTAddress(TAddress TAddress) {
		getTAddresses().remove(TAddress);
		TAddress.setTPeople(null);

		return TAddress;
	}

	public List<TMail> getTMails() {
		return this.TMails;
	}

	public void setTMails(List<TMail> TMails) {
		this.TMails = TMails;
	}

	public TMail addTMail(TMail TMail) {
		getTMails().add(TMail);
		TMail.setTPeople(this);

		return TMail;
	}

	public TMail removeTMail(TMail TMail) {
		getTMails().remove(TMail);
		TMail.setTPeople(null);

		return TMail;
	}

}