package com.lquan.entity;

import java.util.Date;


public class QueOption {
	  public long id;
	  public long QuestionID;
	  public String code;
	  public String title;
	  public boolean open;
	  public String help;
	  public int dispIndex;
	  public int blankType;
	  public int blankMin;
	  public int blankMax;
	  public boolean blankOptional;
	  public int value;
	  public boolean exclusive;
	  public String imageUrl;
	  public String videoUrl;
	  public String thumbUrl;
	  public int blankRows;
	  public int blankCols;
	  public int orientation;
	  public boolean showValue;
	  public boolean showTip;
	  public boolean showCancel;
	  public int selectionMax;
	  public int selectionMin;
	  public boolean active = true;
//	  public Date createdAt;
	  public String createdBy;
//	  public Date updatedAt;
	  public String updatedBy;
	  
	  public Object[] getObjectFile(){
		  Object[] obj ={0,id,createdBy,updatedBy,QuestionID,code,title,imageUrl,videoUrl,open,help,dispIndex,blankType,blankMax,blankMin,blankOptional,value,exclusive,thumbUrl,blankRows,blankCols,orientation,showValue,showTip,showCancel,selectionMax,selectionMin,active};
		  return obj;
	  }
	  
	  public Object[] getupdateArgs(){
		  Object[] obj ={updatedBy,QuestionID,code,title,imageUrl,videoUrl,open,help,dispIndex,blankType,blankMax,blankMin,blankOptional,value,exclusive,thumbUrl,blankRows,blankCols,orientation,showValue,showTip,showCancel,selectionMax,selectionMin,active,id};
		  return obj;
	  }

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getQuestionID() {
		return QuestionID;
	}

	public void setQuestionID(long questionID) {
		QuestionID = questionID;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public boolean isOpen() {
		return open;
	}

	public void setOpen(boolean open) {
		this.open = open;
	}

	public String getHelp() {
		return help;
	}

	public void setHelp(String help) {
		this.help = help;
	}

	public int getDispIndex() {
		return dispIndex;
	}

	public void setDispIndex(int dispIndex) {
		this.dispIndex = dispIndex;
	}

	public int getBlankType() {
		return blankType;
	}

	public void setBlankType(int blankType) {
		this.blankType = blankType;
	}

	public int getBlankMin() {
		return blankMin;
	}

	public void setBlankMin(int blankMin) {
		this.blankMin = blankMin;
	}

	public int getBlankMax() {
		return blankMax;
	}

	public void setBlankMax(int blankMax) {
		this.blankMax = blankMax;
	}

	public boolean isBlankOptional() {
		return blankOptional;
	}

	public void setBlankOptional(boolean blankOptional) {
		this.blankOptional = blankOptional;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public boolean isExclusive() {
		return exclusive;
	}

	public void setExclusive(boolean exclusive) {
		this.exclusive = exclusive;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getVideoUrl() {
		return videoUrl;
	}

	public void setVideoUrl(String videoUrl) {
		this.videoUrl = videoUrl;
	}

	public String getThumbUrl() {
		return thumbUrl;
	}

	public void setThumbUrl(String thumbUrl) {
		this.thumbUrl = thumbUrl;
	}

	public int getBlankRows() {
		return blankRows;
	}

	public void setBlankRows(int blankRows) {
		this.blankRows = blankRows;
	}

	public int getBlankCols() {
		return blankCols;
	}

	public void setBlankCols(int blankCols) {
		this.blankCols = blankCols;
	}

	public int getOrientation() {
		return orientation;
	}

	public void setOrientation(int orientation) {
		this.orientation = orientation;
	}

	public boolean getShowValue() {
		return showValue;
	}

	public void setShowValue(boolean showValue) {
		this.showValue = showValue;
	}

	public boolean getShowTip() {
		return showTip;
	}

	public void setShowTip(boolean showTip) {
		this.showTip = showTip;
	}

	public boolean getShowCancel() {
		return showCancel;
	}

	public void setShowCancel(boolean showCancel) {
		this.showCancel = showCancel;
	}

	public int getSelectionMax() {
		return selectionMax;
	}

	public void setSelectionMax(int selectionMax) {
		this.selectionMax = selectionMax;
	}

	public int getSelectionMin() {
		return selectionMin;
	}

	public void setSelectionMin(int selectionMin) {
		this.selectionMin = selectionMin;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

/*	public Date getCreatedAt() {
		return createdAt;
	}*/

/*	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}*/

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

/*	public Date getUpdatedAt() {
		return updatedAt;
	}*/
/*
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
*/
	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	@Override
	public String toString() {
		return "QueOption [id=" + id + ", QuestionID=" + QuestionID + ", code="
				+ code + ", title=" + title + ", open=" + open + ", help="
				+ help + ", dispIndex=" + dispIndex + ", blankType="
				+ blankType + ", blankMin=" + blankMin + ", blankMax="
				+ blankMax + ", blankOptional=" + blankOptional + ", value="
				+ value + ", exclusive=" + exclusive + ", imageUrl=" + imageUrl
				+ ", videoUrl=" + videoUrl + ", thumbUrl=" + thumbUrl
				+ ", blankRows=" + blankRows + ", blankCols=" + blankCols
				+ ", orientation=" + orientation + ", showValue=" + showValue
				+ ", showTip=" + showTip + ", showCancel=" + showCancel
				+ ", selectionMax=" + selectionMax + ", selectionMin="
				+ selectionMin + ", active=" + active + ", createdAt="
				+ ", createdBy=" + createdBy + ", updatedAt="
				+ ", updatedBy=" + updatedBy + "]";
	}
	  
	  
}
