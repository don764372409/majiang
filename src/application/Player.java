package application;

import java.util.ArrayList;
import java.util.List;

public class Player {
	private String name;//�������
	private int number;//��λ��
	private List<Card> cards = new ArrayList<>();//��ǰ�������
	private int money = 100;//���100
	
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public List<Card> getCards() {
		return cards;
	}
	public void setCards(List<Card> cards) {
		this.cards = cards;
	}
}
