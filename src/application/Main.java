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
	private int currentNumber;//��ǰ��˭����
	private int village;//ׯ�����Ǹ�
	private List<Player> players = new ArrayList<>();
	/**
	 * ��ʼ��Ϸ
	 * @param main 
	 */
	public void playGame(AnchorPane main) {
		//�����������ж��Ƿ����㹻���
		if (players.size()==3) {
			//��ȡ������
			List<List<Card>> list = CardUtil.fapai();
			for (int i = 0; i < players.size(); i++) {
				Player p = players.get(i);
				//������λ��
				p.setNumber(i);
			}
			//�������ͷ��-����-���
			Player p0 = players.get(0);
			Label p0_head = new Label();
			p0_head.setPrefSize(100, 100);
			p0_head.setLayoutX(30);
			p0_head.setLayoutY((800-100)/2);
			
			Label p0_name = new Label("�ǳ�:"+p0.getName());
			p0_name.setLayoutX(30);
			p0_name.setLayoutY((800-100)/2+40);
			Label p0_money = new Label("����"+p0.getMoney());
			p0_money.setLayoutX(130);
			p0_money.setLayoutY((800-100)/2+40);
		
			main.getChildren().add(p0_head);
			main.getChildren().add(p0_name);
			main.getChildren().add(p0_money);
		
		
		}
	}
	/**
	 * ϵͳ����
	 */
	private void fapai() {
		
		
		
	}
	
	
	/**
	 * ��Ϸ���Ʒ���
	 * @param g2d
	 */
	private void game(AnchorPane main) {
		//��������
		Zoom zoom = new Zoom();
		//���䴴��ʱ��
		zoom.setCreateTime(new Date());
		//��������  д���Ƕ�����
		zoom.setType(2);
		
		//�жϵ�ǰ��Ϸ������
		if (zoom.getType()==2) {
			//ѭ���ȴ���Ҽ���
			while(players.size()<3) {
				Player p1 = new Player();
				//д������ǳ�
				p1.setName("΢Ц��һ��");
				//д����λ��
				p1.setNumber(0);
				Player p2 = new Player();
				p2.setName("���Ŵ�ѩ");
				p2.setNumber(1);
				Player p3 = new Player();
				p3.setName("���޼�");
				p3.setNumber(2);
				
				players.add(p1);
				players.add(p2);
				players.add(p3);
			}
			//��ʼ��Ϸ
			playGame(main);
		}
	}
	private void addComp(BorderPane root) {
		Button btn = new Button("��ʼ��Ϸ");
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
