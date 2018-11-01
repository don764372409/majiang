package application;
	
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import com.sun.javafx.PlatformUtil;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;


public class Main extends Application {
	private int currentNumber;//当前该谁出牌
	private int village;//庄家是那个
	private List<Player> players = new ArrayList<>();
	/**
	 * 开始游戏
	 * @param main 
	 */
	public void playGame(AnchorPane main) {
		//根据类型来判断是否有足够玩家
		if (players.size()==3) {
			//获取起手牌
			List<List<Card>> list = CardUtil.fapai();
			for (int i = 0; i < players.size(); i++) {
				Player p = players.get(i);
				//设置座位号
				p.setNumber(i);
			}
			//生成玩家头像-名字-金币
			Player p0 = players.get(0);
			Label p0_head = new Label();
			p0_head.setPrefSize(100, 100);
			p0_head.setLayoutX(30);
			p0_head.setLayoutY((800-100)/2);
			
			Label p0_name = new Label("昵称:"+p0.getName());
			p0_name.setLayoutX(30);
			p0_name.setLayoutY((800-100)/2+40);
			Label p0_money = new Label("积分"+p0.getMoney());
			p0_money.setLayoutX(130);
			p0_money.setLayoutY((800-100)/2+40);
		
			main.getChildren().add(p0_head);
			main.getChildren().add(p0_name);
			main.getChildren().add(p0_money);
		
		
		}
	}
	/**
	 * 系统发牌
	 */
	private void fapai() {
		
		
		
	}
	
	
	/**
	 * 游戏控制方法
	 * @param g2d
	 */
	private void game(AnchorPane main) {
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
			playGame(main);
		}
	}
	private void addComp(BorderPane root) {
		Button btn = new Button("开始游戏");
		btn.setOnMouseClicked(e->{
			AnchorPane main = new AnchorPane();
			game(main);
			root.setCenter(main);
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
