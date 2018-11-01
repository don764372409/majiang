package application;

import java.util.Date;

/**
 * 当前房间的数据类
 */
public class Zoom {
	private int zoomNumber;//房间号
	private int type;//房间类型   0-金花  1-斗牛  2-斗地主  3-四川麻将
	private Date createTime;//房间创建时间
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
