package application;

import java.util.ArrayList;
import java.util.List;

public class Player {
	private String name;//�������
	private int number;//��λ��
	private List<Integer> cards = new ArrayList<>();//��ǰ�������
	private int money = 100;//���100
	private int zhuang = -1;//�Ƿ���ׯ ��û�п���  0--������ׯ  1--��ׯ�� 
	
	public int getZhuang() {
		return zhuang;
	}
	public void setZhuang(int zhuang) {
		this.zhuang = zhuang;
	}
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
	public List<Integer> getCards() {
		return cards;
	}
	public void setCards(List<Integer> cards) {
		this.cards = cards;
	}
}
