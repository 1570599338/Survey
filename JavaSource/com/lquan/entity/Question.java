package com.lquan.entity;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

public class Question {
	  public long ID;
	  public long TemplateID;
	  public int Type;
	  public String Number;
	  public String Title;
	  public String ImageUrl;
	  public String VideoUrl;
	  public boolean Optional;
	  public String Help;
	  public int Layout;
	  public int DispIndex;
	  public boolean Active = true; 
//	  public Timestamp CreatedAt;
	  public String CreatedBy;
//	  public Timestamp UpdatedAt;
	  public String UpdatedBy;
	  public int SelectionMax;
	  public int SelectionMin;
	  public boolean RowDisordered;
	  public boolean MatrixPivot;
	  public boolean RowLastFixed;
	  public boolean ColDisordered;
	  public boolean ColLastFixed;
	  public int ScoreType = 1;
	  public boolean RowReverse = false;
	  public boolean ColReverse = false;
	  public int ChartType;
	  private long logicCount = 0L;
	  private int BusinessType;
	  public int ColumnCount;
	  private List<QueOption> Options;
	  
	  public Object[] getObjectFile(){
		  Object[] obj ={0,ID,CreatedBy,UpdatedBy,TemplateID,Type,Number,Title,ImageUrl,VideoUrl,Optional,Help,Layout,DispIndex,SelectionMax,SelectionMin,RowDisordered,MatrixPivot,RowLastFixed,ColDisordered,ColLastFixed,ColumnCount,BusinessType,ScoreType,RowReverse,ColReverse,ChartType,Active};
		  return obj;
	  }
	  
	  public Object[] getupdateArgs(){
		  Object[] obj ={TemplateID,Type,Number,Title,ImageUrl,VideoUrl,Optional,Help,Layout,DispIndex,SelectionMax,SelectionMin,RowDisordered,MatrixPivot,RowLastFixed,ColDisordered,ColLastFixed,ColumnCount,BusinessType,ScoreType,RowReverse,ColReverse,ChartType,ID};
		  return obj;
	  }
	  
	  
	  
	@Override
	public String toString() {
		return "Question [id=" + ID + ", TemplateID=" + TemplateID + ", Type="
				+ Type + ", Number=" + Number + ", Title=" + Title
				+ ", ImageUrl=" + ImageUrl + ", VideoUrl=" + VideoUrl
				+ ", Optional=" + Optional + ", Help=" + Help + ", Layout="
				+ Layout + ", DispIndex=" + DispIndex + ", Active=" + Active
				+", CreatedBy=" + CreatedBy  + ", UpdatedBy=" + UpdatedBy
				+ ", SelectionMax=" + SelectionMax + ", SelectionMin="
				+ SelectionMin + ", RowDisordered=" + RowDisordered
				+ ", MatrixPivot=" + MatrixPivot + ", RowLastFixed="
				+ RowLastFixed + ", ColDisordered=" + ColDisordered
				+ ", ColLastFixed=" + ColLastFixed + ", ScoreType=" + ScoreType
				+ ", RowReverse=" + RowReverse + ", ColReverse=" + ColReverse
				+ ", ChartType=" + ChartType + ", logicCount=" + logicCount
				+ ", BusinessType=" + BusinessType + ", ColumnCount="
				+ ColumnCount + ", Options=" + Options + "]";
	}
	
	
	  public long getTemplateID() {
			return TemplateID;
		}
	public void setTemplateID(long templateID) {
		TemplateID = templateID;
	}
	public List<QueOption> getOptions() {
		return Options;
	}
	public void setOptions(List<QueOption> options) {
		Options = options;
	}
	
	public long getId() {
		return ID;
	}
	public void setId(long id) {
		ID = id;
	}
	public int getType() {
		return Type;
	}
	public void setType(int type) {
		Type = type;
	}
	public String getNumber() {
		return Number;
	}
	public void setNumber(String number) {
		Number = number;
	}
	public String getTitle() {
		return Title;
	}
	public void setTitle(String title) {
		Title = title;
	}
	public String getImageUrl() {
		return ImageUrl;
	}
	public void setImageUrl(String imageUrl) {
		ImageUrl = imageUrl;
	}
	public String getVideoUrl() {
		return VideoUrl;
	}
	public void setVideoUrl(String videoUrl) {
		VideoUrl = videoUrl;
	}
	public boolean isOptional() {
		return Optional;
	}
	public void setOptional(boolean optional) {
		Optional = optional;
	}
	public String getHelp() {
		return Help;
	}
	public void setHelp(String help) {
		Help = help;
	}
	public int getLayout() {
		return Layout;
	}
	public void setLayout(int layout) {
		Layout = layout;
	}
	public int getDispIndex() {
		return DispIndex;
	}
	public void setDispIndex(int dispIndex) {
		DispIndex = dispIndex;
	}
	public boolean isActive() {
		return Active;
	}
	public void setActive(boolean active) {
		Active = active;
	}

	public String getCreatedBy() {
		return CreatedBy;
	}
	public void setCreatedBy(String createdBy) {
		CreatedBy = createdBy;
	}

	public String getUpdatedBy() {
		return UpdatedBy;
	}
	public void setUpdatedBy(String updatedBy) {
		UpdatedBy = updatedBy;
	}
	public int getSelectionMax() {
		return SelectionMax;
	}
	public void setSelectionMax(int selectionMax) {
		SelectionMax = selectionMax;
	}
	public int getSelectionMin() {
		return SelectionMin;
	}
	public void setSelectionMin(int selectionMin) {
		SelectionMin = selectionMin;
	}
	public boolean isRowDisordered() {
		return RowDisordered;
	}
	public void setRowDisordered(boolean rowDisordered) {
		RowDisordered = rowDisordered;
	}
	public boolean isMatrixPivot() {
		return MatrixPivot;
	}
	public void setMatrixPivot(boolean matrixPivot) {
		MatrixPivot = matrixPivot;
	}
	public boolean isRowLastFixed() {
		return RowLastFixed;
	}
	public void setRowLastFixed(boolean rowLastFixed) {
		RowLastFixed = rowLastFixed;
	}
	public boolean isColDisordered() {
		return ColDisordered;
	}
	public void setColDisordered(boolean colDisordered) {
		ColDisordered = colDisordered;
	}
	public boolean isColLastFixed() {
		return ColLastFixed;
	}
	public void setColLastFixed(boolean colLastFixed) {
		ColLastFixed = colLastFixed;
	}
	public int getScoreType() {
		return ScoreType;
	}
	public void setScoreType(int scoreType) {
		ScoreType = scoreType;
	}
	public boolean isRowReverse() {
		return RowReverse;
	}
	public void setRowReverse(boolean rowReverse) {
		RowReverse = rowReverse;
	}
	public boolean isColReverse() {
		return ColReverse;
	}
	public void setColReverse(boolean colReverse) {
		ColReverse = colReverse;
	}
	public int getChartType() {
		return ChartType;
	}
	public void setChartType(int chartType) {
		ChartType = chartType;
	}
	public long getLogicCount() {
		return logicCount;
	}
	public void setLogicCount(long logicCount) {
		this.logicCount = logicCount;
	}
	public int getBusinessType() {
		return BusinessType;
	}
	public void setBusinessType(int businessType) {
		BusinessType = businessType;
	}
	public int getColumnCount() {
		return ColumnCount;
	}
	public void setColumnCount(int columnCount) {
		ColumnCount = columnCount;
	}
	  
}
