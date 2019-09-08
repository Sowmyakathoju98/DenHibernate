package com.virtusa.denorm.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class CardDetail {
	@Id
	@GeneratedValue
	private int cardId;
	private long cardNumber;
	private String cardName;
	private String cardType;
	private String expiryDate;
	private long CVV;
	public int getCardId() {
		return cardId;
	}
	public void setCardId(int cardId) {
		this.cardId = cardId;
	}
	public long getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(long cardNumber) {
		this.cardNumber = cardNumber;
	}
	public String getCardName() {
		return cardName;
	}
	public void setCardName(String cardName) {
		this.cardName = cardName;
	}
	public String getCardType() {
		return cardType;
	}
	public void setCardType(String cardType) {
		this.cardType = cardType;
	}
	public String getExpiryDate() {
		return expiryDate;
	}
	public void setExpiryDate(String expiryDate) {
		this.expiryDate = expiryDate;
	}
	public long getCVV() {
		return CVV;
	}
	public void setCVV(long cVV) {
		CVV = cVV;
	}
	
	public CardDetail(long cardNumber, String cardName, String cardType, String expiryDate, long cVV) {
		super();
		this.cardNumber = cardNumber;
		this.cardName = cardName;
		this.cardType = cardType;
		this.expiryDate = expiryDate;
		CVV = cVV;
	}
	@Override
	public String toString() {
		return "CardDetail [cardId=" + cardId + ", cardNumber=" + cardNumber + ", cardName=" + cardName + ", cardType="
				+ cardType + ", ExpiryDate=" + expiryDate + ", CVV=" + CVV + "]";
	}
	public CardDetail() {
		// TODO Auto-generated constructor stub
	}

}
