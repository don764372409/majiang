package application;
	
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;


public class Main extends Application implements Runnable{
	private int currentNumber;//当前该谁出牌
	private int zhuang = -1;//庄家是那个  默认没有庄家
	private List<Player> players = new ArrayList<>();
	private AnchorPane main;
	private List<Label> selectCard = new ArrayList<>();
	private Random rd = new Random();
	public void run() {
		Platform.runLater(()->{
			game();
		});
	}
	private void startThread() {
		new Thread(this).start();
	}
	/**
	 * 开始游戏
	 * @param main 
	 */
	public void playGame() {
		//设置为没有庄家
		zhuang = -1;
		//根据类型来判断是否有足够玩家
		if (players.size()==3) {
			//获取起手牌
			List<List<Integer>> list = CardUtil.fapai();
			for (int i = 0; i < players.size(); i++) {
				Player p = players.get(i);
				//设置座位号
				p.setNumber(i);
			}
			//生成玩家0头像-名字-金币
			Player p0 = players.get(0);
			Label p0_head = new Label();
			try {
				p0_head.setBackground(new Background(new BackgroundImage(new Image(new FileInputStream("resource/head0.jpg")),null,null,null,new BackgroundSize(1200, 800,true,true,true,true))));
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			p0_head.setPrefSize(100, 100);
			p0_head.setLayoutX(30);
			p0_head.setLayoutY((800-100)/2-100);
			Label p0_name = new Label("昵称:"+p0.getName());
			p0_name.setLayoutX(30);
			p0_name.setLayoutY((800-100)/2+110-100);
			p0_name.setTextFill(Color.WHITE);
			Label p0_money = new Label("积分"+p0.getMoney());
			p0_money.setLayoutX(30);
			p0_money.setLayoutY((800-100)/2+110-100+20);
			p0_money.setTextFill(Color.WHITE);
		
			main.getChildren().add(p0_head);
			main.getChildren().add(p0_name);
			main.getChildren().add(p0_money);
			//生成玩家1头像-名字-金币
			Player p1 = players.get(1);
			Label p1_head = new Label();
			try {
				p1_head.setBackground(new Background(new BackgroundImage(new Image(new FileInputStream("resource/head1.jpg")),null,null,null,new BackgroundSize(1200, 800,true,true,true,true))));
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			p1_head.setPrefSize(100, 100);
			p1_head.setLayoutX((1200-100)/2);
			p1_head.setLayoutY(800-100-50);
			Label p1_name = new Label("昵称:"+p1.getName());
			p1_name.setLayoutX((1200-100)/2);
			p1_name.setLayoutY(800-100-50+110);
			p1_name.setTextFill(Color.WHITE);
			Label p1_money = new Label("积分"+p1.getMoney());
			p1_money.setLayoutX((1200-100)/2);
			p1_money.setLayoutY(800-100-50+110+20);
			p1_money.setTextFill(Color.WHITE);
			
			main.getChildren().add(p1_head);
			main.getChildren().add(p1_name);
			main.getChildren().add(p1_money);
			
			//生成玩家1头像-名字-金币
			Player p2 = players.get(2);
			Label p2_head = new Label();
			try {
				p2_head.setBackground(new Background(new BackgroundImage(new Image(new FileInputStream("resource/head2.jpg")),null,null,null,new BackgroundSize(1200, 800,true,true,true,true))));
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			p2_head.setPrefSize(100, 100);
			p2_head.setLayoutX(1200-100-30);
			p2_head.setLayoutY((800-100)/2-100);
			Label p2_name = new Label("昵称:"+p2.getName());
			p2_name.setLayoutX(1200-100-30);
			p2_name.setLayoutY((800-100)/2+110-100);
			p2_name.setTextFill(Color.WHITE);
			Label p2_money = new Label("积分"+p2.getMoney());
			p2_money.setLayoutX(1200-100-30);
			p2_money.setLayoutY((800-100)/2+110-100+20);
			p2_money.setTextFill(Color.WHITE);
			
			main.getChildren().add(p2_head);
			main.getChildren().add(p2_name);
			main.getChildren().add(p2_money);
			
			//拿到牌
			List<List<Integer>> pais = CardUtil.fapai();
			List<Integer> cards0 = pais.get(0);
			p0.setCards(cards0);
			List<Integer> cards1 = pais.get(1);
			p1.setCards(cards1);
			List<Integer> cards2 = pais.get(2);
			p2.setCards(cards2);
			
			
			//p1为玩家  p0和p2为电脑
			//创建一个容器来装扑克牌
			AnchorPane ap = new AnchorPane();
			ap.setPrefSize(1200, 170);
			ap.setLayoutX(0);
			ap.setLayoutY(800-100-200-20);
			main.getChildren().add(ap);
			Collections.sort(cards1,new Comparator<Integer>() {
				public int compare(Integer o1, Integer o2) {
					return o2-o1;
				}
			});
			//发牌到窗口
			for (int i=0;i<cards1.size();i++) {
				Integer card = cards1.get(i);
				Label card_lb = new Label();
				card_lb.setPrefSize(100, 150);
				if (i==cards0.size()-1) {
					card_lb.setLayoutX(950);
				}else {
					card_lb.setLayoutX(150+i*50);
				}
				card_lb.setOnMouseClicked(event->{
					Label lb = (Label)event.getSource();
					if (selectCard.contains(lb)) {
						//将选择的牌添加到集合中
						double y = lb.getLayoutY();
						lb.setLayoutY(y+20);
						selectCard.remove(lb);
					}else {
						//将选择的牌添加到集合中
						selectCard.add(lb);
						double y = lb.getLayoutY();
						lb.setLayoutY(y-20);
					}
				});
				try {
					card_lb.setBackground(new Background(new BackgroundImage(new Image(new FileInputStream("resource/card/"+card+".JPG")),null,null,null,new BackgroundSize(100, 150,true,true,true,true))));
					ap.getChildren().add(card_lb);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			//洗牌 排序
//			ap.getChildren().clear();
			//左边背面牌
			Font font = Font.font(32);
			Label p0_back = new Label();
			p0_back.setTextAlignment(TextAlignment.CENTER);
			p0_back.setText(cards0.size()+"");
			p0_back.setTextFill(Color.WHITE);
			p0_back.setFont(font);
			try {
				p0_back.setBackground(new Background(new BackgroundImage(new Image(new FileInputStream("resource/card/back.png")),null,null,null,new BackgroundSize(100, 150,true,true,true,true))));
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			p0_back.setPrefSize(100, 150);
			p0_back.setLayoutX(30+100+10);
			p0_back.setLayoutY((800-100)/2-125);
			main.getChildren().add(p0_back);
			//右边背面
			Label p2_back = new Label();
			try {
				p2_back.setBackground(new Background(new BackgroundImage(new Image(new FileInputStream("resource/card/back.png")),null,null,null,new BackgroundSize(100, 150,true,true,true,true))));
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			p2_back.setPrefSize(100, 150);
			p2_back.setFont(font);
			p2_back.setLayoutX(1200-100-30-100-10);
			p2_back.setLayoutY((800-100)/2-125);
			p2_back.setTextFill(Color.WHITE);
			p2_back.setTextAlignment(TextAlignment.RIGHT);
			p2_back.setText(cards2.size()+"");
			main.getChildren().add(p2_back);
			
			//抢庄
			
			//没有人抢庄就从新循环
			while(this.zhuang == -1) {
				//默认3个玩家都属于未抢状态
				int[] is = {1,1,1};
				//随机开抢位置
				int beginIndex = rd.nextInt(3);//0 1 2 
				//默认抢四次
				for (int i = 0; i < is.length+1; i++) {
					//随机是否抢庄
					//没有抢过 或者处于抢庄状态 过滤抢的总次数
					if (is[beginIndex]==1||is[beginIndex]==2) {
						int qiang = rd.nextInt(2);// 0 1
						//没有抢
						if (qiang==0) {
							//将玩家状态设置为 放弃
							is[beginIndex] =0;
						}else {
							//如果玩家没有抢过，将玩家状态设置为抢庄1次状态
							if (is[beginIndex]==1) {
								is[beginIndex] =2;
							}
							//如果玩家抢过一次，将玩家状态设置为抢庄1次状态
							if (is[beginIndex]==2) {
								is[beginIndex] =3;
							}
							
						}
					}
					beginIndex++;
					if (beginIndex==3) {
						beginIndex=0;
					}
				}
				//判断庄
				if () {
					
				}
				
			}
			
			
		}
	}
	
	/**
	 * 游戏控制方法
	 * @param g2d
	 */
	private void game() {
		//创建房间
		Zoom zoom = new Zoom();
		//房间创建时间
		zoom.setCreateTime(new Date());
		//房间类型  写死是斗地主
		zoom.setType(2);
		
		//判断当前游戏的类型
		if (zoom.getType()==2) {
			//循环等待玩家加入
			while(players.size()<3) {
				Player p1 = new Player();
				//写死玩家昵称
				p1.setName("微笑い一刀");
				//写死座位号
				p1.setNumber(0);
				Player p2 = new Player();
				p2.setName("西门吹雪");
				p2.setNumber(1);
				Player p3 = new Player();
				p3.setName("张无忌");
				p3.setNumber(2);
				
				players.add(p1);
				players.add(p2);
				players.add(p3);
			}
			//开始游戏
			playGame();
		}
	}
	private void addComp(BorderPane root) {
		Button btn = new Button("开始游戏");
		btn.setOnMouseClicked(e->{
			main = new AnchorPane();
			root.setCenter(main);
			startThread();
		});
		root.setCenter(btn);
	}
	public void start(Stage stage) {
		try {
			BorderPane root = new BorderPane();
			root.setBackground(new Background(new BackgroundImage(new Image(new FileInputStream("resource/majiangzhuo.jpg")),null,null,null,new BackgroundSize(1200, 800,true,true,true,true))));
			addComp(root);
			Scene scene = new Scene(root,1200,800);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			stage.setScene(scene);
			stage.setResizable(false);
			stage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
