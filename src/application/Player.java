package application;

import java.util.ArrayList;
import java.util.List;

public class Player {
	private String name;//玩家名称
	private int number;//座位号
	private List<Integer> cards = new ArrayList<>();//当前手里的牌
	private int money = 100;//金币100
	private int zhuang = -1;//是否抢庄 还没有开抢  0--放弃抢庄  1--抢庄了 
	
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
