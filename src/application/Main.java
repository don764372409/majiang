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
	private int currentNumber;//��ǰ��˭����
	private int zhuang = -1;//ׯ�����Ǹ�  Ĭ��û��ׯ��
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
	 * ��ʼ��Ϸ
	 * @param main 
	 */
	public void playGame() {
		//����Ϊû��ׯ��
		zhuang = -1;
		//�����������ж��Ƿ����㹻���
		if (players.size()==3) {
			//��ȡ������
			List<List<Integer>> list = CardUtil.fapai();
			for (int i = 0; i < players.size(); i++) {
				Player p = players.get(i);
				//������λ��
				p.setNumber(i);
			}
			//�������0ͷ��-����-���
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
			Label p0_name = new Label("�ǳ�:"+p0.getName());
			p0_name.setLayoutX(30);
			p0_name.setLayoutY((800-100)/2+110-100);
			p0_name.setTextFill(Color.WHITE);
			Label p0_money = new Label("����"+p0.getMoney());
			p0_money.setLayoutX(30);
			p0_money.setLayoutY((800-100)/2+110-100+20);
			p0_money.setTextFill(Color.WHITE);
		
			main.getChildren().add(p0_head);
			main.getChildren().add(p0_name);
			main.getChildren().add(p0_money);
			//�������1ͷ��-����-���
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
			Label p1_name = new Label("�ǳ�:"+p1.getName());
			p1_name.setLayoutX((1200-100)/2);
			p1_name.setLayoutY(800-100-50+110);
			p1_name.setTextFill(Color.WHITE);
			Label p1_money = new Label("����"+p1.getMoney());
			p1_money.setLayoutX((1200-100)/2);
			p1_money.setLayoutY(800-100-50+110+20);
			p1_money.setTextFill(Color.WHITE);
			
			main.getChildren().add(p1_head);
			main.getChildren().add(p1_name);
			main.getChildren().add(p1_money);
			
			//�������1ͷ��-����-���
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
			Label p2_name = new Label("�ǳ�:"+p2.getName());
			p2_name.setLayoutX(1200-100-30);
			p2_name.setLayoutY((800-100)/2+110-100);
			p2_name.setTextFill(Color.WHITE);
			Label p2_money = new Label("����"+p2.getMoney());
			p2_money.setLayoutX(1200-100-30);
			p2_money.setLayoutY((800-100)/2+110-100+20);
			p2_money.setTextFill(Color.WHITE);
			
			main.getChildren().add(p2_head);
			main.getChildren().add(p2_name);
			main.getChildren().add(p2_money);
			
			//�õ���
			List<List<Integer>> pais = CardUtil.fapai();
			List<Integer> cards0 = pais.get(0);
			p0.setCards(cards0);
			List<Integer> cards1 = pais.get(1);
			p1.setCards(cards1);
			List<Integer> cards2 = pais.get(2);
			p2.setCards(cards2);
			
			
			//p1Ϊ���  p0��p2Ϊ����
			//����һ��������װ�˿���
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
			//���Ƶ�����
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
						//��ѡ�������ӵ�������
						double y = lb.getLayoutY();
						lb.setLayoutY(y+20);
						selectCard.remove(lb);
					}else {
						//��ѡ�������ӵ�������
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
			//ϴ�� ����
//			ap.getChildren().clear();
			//��߱�����
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
			//�ұ߱���
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
			
			//��ׯ
			
			//û������ׯ�ʹ���ѭ��
			while(this.zhuang == -1) {
				//Ĭ��3����Ҷ�����δ��״̬
				int[] is = {1,1,1};
				//�������λ��
				int beginIndex = rd.nextInt(3);//0 1 2 
				//Ĭ�����Ĵ�
				for (int i = 0; i < is.length+1; i++) {
					//����Ƿ���ׯ
					//û������ ���ߴ�����ׯ״̬ ���������ܴ���
					if (is[beginIndex]==1||is[beginIndex]==2) {
						int qiang = rd.nextInt(2);// 0 1
						//û����
						if (qiang==0) {
							//�����״̬����Ϊ ����
							is[beginIndex] =0;
						}else {
							//������û�������������״̬����Ϊ��ׯ1��״̬
							if (is[beginIndex]==1) {
								is[beginIndex] =2;
							}
							//����������һ�Σ������״̬����Ϊ��ׯ1��״̬
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
				//�ж�ׯ
				if () {
					
				}
				
			}
			
			
		}
	}
	
	/**
	 * ��Ϸ���Ʒ���
	 * @param g2d
	 */
	private void game() {
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
			playGame();
		}
	}
	private void addComp(BorderPane root) {
		Button btn = new Button("��ʼ��Ϸ");
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
