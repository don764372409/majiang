package application;

import java.util.Date;

/**
 * ��ǰ�����������
 */
public class Zoom {
	private int zoomNumber;//�����
	private int type;//��������   0-��  1-��ţ  2-������  3-�Ĵ��齫
	private Date createTime;//���䴴��ʱ��
	public int getZoomNumber() {
		return zoomNumber;
	}
	public void setZoomNumber(int zoomNumber) {
		this.zoomNumber = zoomNumber;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
}
