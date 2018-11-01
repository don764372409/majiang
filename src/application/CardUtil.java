package application;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * 棋牌工具类
 */
public class CardUtil {
	private static Random rd = new Random();
	// 没有花牌的斗地主
	public static List<Card> cards1 = new ArrayList<>();

	static {
		cards1.add(Card.Heart_1);
		cards1.add(Card.Heart_2);
		cards1.add(Card.Heart_3);
		cards1.add(Card.Heart_4);
		cards1.add(Card.Heart_5);
		cards1.add(Card.Heart_6);
		cards1.add(Card.Heart_7);
		cards1.add(Card.Heart_8);
		cards1.add(Card.Heart_9);
		cards1.add(Card.Heart_10);
		cards1.add(Card.Heart_11);
		cards1.add(Card.Heart_12);
		cards1.add(Card.Heart_13);
		cards1.add(Card.Spade_1);
		cards1.add(Card.Spade_2);
		cards1.add(Card.Spade_3);
		cards1.add(Card.Spade_4);
		cards1.add(Card.Spade_5);
		cards1.add(Card.Spade_6);
		cards1.add(Card.Spade_7);
		cards1.add(Card.Spade_8);
		cards1.add(Card.Spade_9);
		cards1.add(Card.Spade_10);
		cards1.add(Card.Spade_11);
		cards1.add(Card.Spade_12);
		cards1.add(Card.Spade_13);
		cards1.add(Card.Flower_1);
		cards1.add(Card.Flower_2);
		cards1.add(Card.Flower_3);
		cards1.add(Card.Flower_4);
		cards1.add(Card.Flower_5);
		cards1.add(Card.Flower_6);
		cards1.add(Card.Flower_7);
		cards1.add(Card.Flower_8);
		cards1.add(Card.Flower_9);
		cards1.add(Card.Flower_10);
		cards1.add(Card.Flower_11);
		cards1.add(Card.Flower_12);
		cards1.add(Card.Flower_13);
		cards1.add(Card.Block_1);
		cards1.add(Card.Block_2);
		cards1.add(Card.Block_3);
		cards1.add(Card.Block_4);
		cards1.add(Card.Block_5);
		cards1.add(Card.Block_6);
		cards1.add(Card.Block_7);
		cards1.add(Card.Block_8);
		cards1.add(Card.Block_9);
		cards1.add(Card.Block_10);
		cards1.add(Card.Block_11);
		cards1.add(Card.Block_12);
		cards1.add(Card.Block_13);
		cards1.add(Card.Block_small);
		cards1.add(Card.Block_big);
	}

	// 得到3副牌 和底牌
	public static List<List<Card>> fapai() {
		// 装4副牌
		List<List<Card>> list = new ArrayList<>();
		List<Card> list1 = new ArrayList<>();
		List<Card> list2 = new ArrayList<>();
		List<Card> list3 = new ArrayList<>();
		List<Card> list4 = new ArrayList<>();
		list.add(list1);
		list.add(list2);
		list.add(list3);
		list.add(list4);
		// 随机第一幅牌
		while (list1.size()<17) {
			int index = rd.nextInt(54);
			Card card = cards1.get(index);
			if (!isExsit(list, card)) {
				list1.add(card);
			}
		}
		while (list2.size()<17) {
			int index = rd.nextInt(54);
			Card card = cards1.get(index);
			if (!isExsit(list, card)) {
				list2.add(card);
			}
		}
		while (list3.size()<17) {
			int index = rd.nextInt(54);
			Card card = cards1.get(index);
			if (!isExsit(list, card)) {
				list3.add(card);
			}
		}
		while (list4.size()<3) {
			int index = rd.nextInt(54);
			Card card = cards1.get(index);
			if (!isExsit(list, card)) {
				list4.add(card);
			}
		}

		return list;
	}

	private static boolean isExsit(List<List<Card>> list,Card card) {
		for (List<Card> list2 : list) {
			if (list2.contains(card)) {
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		List<List<Card>> list = CardUtil.fapai();
		for (List<Card> list2 : list) {
			System.err.println(list2);
			System.err.println(list2.size());
		}
	}
}
