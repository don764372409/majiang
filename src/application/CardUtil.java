package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 棋牌工具类
 */
public class CardUtil {
	private static Random rd = new Random();
	// 没有花牌的斗地主
	public static List<Integer> cards1 = new ArrayList<>();

	static {
		for (int i = 9; i <= 62; i++) {
			cards1.add(i);
		}
	}
	// 得到3副牌 和底牌
	public static List<List<Integer>> fapai() {
		// 装4副牌
		List<List<Integer>> list = new ArrayList<>();
		List<Integer> list1 = new ArrayList<>();
		List<Integer> list2 = new ArrayList<>();
		List<Integer> list3 = new ArrayList<>();
		List<Integer> list4 = new ArrayList<>();
		list.add(list1);
		list.add(list2);
		list.add(list3);
		list.add(list4);
		// 随机第一幅牌
		while (list1.size()<17) {
			int card = rd.nextInt(54)+9;
			if (!isExsit(list, card)) {
				list1.add(card);
			}
		}
		while (list2.size()<17) {
			int card = rd.nextInt(54)+9;
			if (!isExsit(list, card)) {
				list2.add(card);
			}
		}
		while (list3.size()<17) {
			int card = rd.nextInt(54)+9;
			if (!isExsit(list, card)) {
				list3.add(card);
			}
		}
		while (list4.size()<3) {
			int card = rd.nextInt(54)+9;
			if (!isExsit(list, card)) {
				list4.add(card);
			}
		}
		return list;
	}

	private static boolean isExsit(List<List<Integer>> list,int card) {
		for (List<Integer> list2 : list) {
			if (list2.contains(card)) {
				return true;
			}
		}
		return false;
	}
}
