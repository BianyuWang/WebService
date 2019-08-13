package myRestWeb.entity;

public class Payment {
	
	private String typeOfCard;
	private String  cardNumber;
	

	public Payment(String typeOfCard, String cardNumber) {
		super();
		this.typeOfCard = typeOfCard;
		this.cardNumber = cardNumber;
	}
	public String getTypeOfCard() {
		return typeOfCard;
	}
	public void setTypeOfCard(String typeOfCard) {
		this.typeOfCard = typeOfCard;
	}
	public String getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

}
