package com.lquan.business.question;

import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.gson.Gson;
import com.lquan.entity.QueOption;
import com.lquan.entity.Question;

import snt.common.dao.base.CommonDAO;
import snt.common.dao.base.PrimaryKeyGenerator;

@Service(value="questionServer")
public class QuestionServerImpl implements IQuestionServer  {
	
	@Autowired
	@Qualifier("commonDAO")
	private CommonDAO commonDao;

	
	/**
	 * 插入题目
	 * @param arg
	 * @return
	 * @throws Exception
	 */
	@Override
	@Transactional
	public Boolean createQuestion(Object[] arg) throws Exception{
		StringBuffer sql = new StringBuffer();
		sql.append("insert into question( pk_id,ID,CreatedBy,UpdatedBy,TemplateID,Type,Number,Title,ImageUrl,VideoUrl,Optional,Help,Layout,DispIndex,SelectionMax,SelectionMin,RowDisordered,MatrixPivot,RowLastFixed,ColDisordered,ColLastFixed,ColumnCount,BusinessType,ScoreType,RowReverse,ColReverse,ChartType,Active,CreatedAt, UpdatedAt) ");
		sql.append(" values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,getdate(),getdate())");
		int a = commonDao.update(sql.toString(), arg);
		return true;
	}

	
	/**
	 * 插入选项数据
	 * @param arg
	 * @return
	 * @throws Exception
	 */
	@Override
	public Boolean createOPtion(Object[] arg) throws Exception {
		StringBuffer sql = new StringBuffer();
		sql.append("insert into queoption(pk_id,id,CreatedBy,UpdatedBy,QuestionID,Code,Title,ImageUrl,VideoUrl,[Open],Help,DispIndex,BlankType,BlankMax,BlankMin,BlankOptional,Value,Exclusive,ThumbUrl,BlankRows,BlankCols,Orientation,ShowValue,ShowTip,ShowCancel,SelectionMax,SelectionMin,Active,CreatedAt,UpdatedAt) ");
		sql.append(" values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,getdate(),getdate())");
		int a = commonDao.update(sql.toString(), arg);
		return true;
	}

	/**
	 * 转换器讲Json数据转换成Question
	 * @param json
	 * @return
	 */
	@Override
	public Question ConverterQuestion(JSONObject json,String userName) {
		long pk_id = PrimaryKeyGenerator.getLongKey();
		Question question = (Question) json.toBean(json, Question.class);
		question.setId(pk_id);
		question.setCreatedBy(userName);
		question.setUpdatedBy(userName);
		Object[] arg = question.getObjectFile();
		
		return question;
	}


	/**
	 * 讲Json数据转换成Bean
	 * @param json
	 * @param question
	 * @param userName
	 * @return
	 */
	@Override
	public List<QueOption> ConverterQueOption(JSONObject json, Long questionId,String userName) {
		List<JSONObject> list=  (List<JSONObject>) json.get("options");
		List<QueOption> qolist = new ArrayList<QueOption>();
		for(JSONObject optionJS:list){
		//	QueOption questionx = (QueOption) optionJS.toBean(optionJS, QueOption.class);
			Gson gson=new Gson();
			QueOption option = gson.fromJson(optionJS.toString(), QueOption.class);
			long id = PrimaryKeyGenerator.getLongKey();
			option.setId(id);
			option.setCreatedBy(userName);
			option.setUpdatedBy(userName);
			option.setQuestionID(questionId);
			Object[] args = option.getObjectFile();
			args[0]=id;
			try {
				createOPtion(args);
			} catch (Exception e) {
				e.printStackTrace();
			}
			qolist.add(option);
		}
		return qolist;
	}

	/**
	 * 删除题目
	 * @param json
	 * @return
	 * @throws Exception
	 */
	@Override
	@Transactional
	public Boolean deleteQuestion(JSONObject json) throws Exception {
		StringBuffer sql = new StringBuffer();
		sql.append(" delete from question where pk_id=").append(json.get("id"));
		int a = commonDao.update(sql.toString());
		
		StringBuffer sb = new StringBuffer();
		sb.append("delete from queoption where QuestionID=").append(json.get("id"));
		int b = commonDao.update(sb.toString());
		if(a>0||b>0)
			return true;
		return false;
		
	}

	
	
	/**
	 *  调换题目的顺序
	 * @param id 第一个题目的ID
	 * @param dispIndex 第一个题目的序号
	 * @return
	 * @throws Exception
	 */
	@Override
	@Transactional
	public Boolean moveQuestion(Long firstID,int firstDispIndex) throws Exception {
		StringBuffer sql = new StringBuffer();
		sql.append(" update question set dispIndex =? from question where pk_id=").append(firstID);
		int a = commonDao.update(sql.toString(),new Object[]{firstDispIndex});
		
		if(a>0)
			return true;
		return false;
		
	}


	/**
	 * 获取问卷所有数据
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<Question> searchQuestionList(Long id) throws Exception {
		StringBuffer sb = new StringBuffer();
		//sb.append("select ID,TemplateID,Type,Number,Title,ImageUrl,VideoUrl,Optional,Help,Layout,DispIndex,SelectionMax,SelectionMin,RowDisordered,MatrixPivot,RowLastFixed,ColDisordered,ColLastFixed,ColumnCount,BusinessType,ScoreType,RowReverse,ColReverse,ChartType,Active,CreatedAt,CreatedBy,UpdatedAt,UpdatedBy from dbo.question ");
		  sb.append("select ID,TemplateID,Type,Number,Title,ImageUrl,VideoUrl,Optional,Help,Layout,DispIndex,SelectionMax,SelectionMin,RowDisordered,MatrixPivot,RowLastFixed,ColDisordered,ColLastFixed,ColumnCount  ,BusinessType,ScoreType,RowReverse,ColReverse,ChartType,Active,CreatedAt,CreatedBy,UpdatedAt,UpdatedBy from dbo.question ");
		sb.append(" where TemplateID = ").append(id);
		sb.append(" order by DispIndex asc");
		List<Question> questionList = commonDao.queryForPojoList(sb.toString(), Question.class);
		List<Question> list = new ArrayList<Question>();
		for(Question question :questionList){
			List<QueOption> optionList = getQueOption(question.getId());
			if(optionList!=null && optionList.size()>0){
				question.setOptions(optionList);
				list.add(question);
			}else {
				list.add(question);
			}
		}
		//return list;
		return questionList;
	}


	/**
	 * 获取问卷的选项
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<QueOption> getQueOption(Long id) throws Exception {
		StringBuffer sql = new StringBuffer();
		//sql.append("SELECT ID,QuestionID,Code,Title,ImageUrl,VideoUrl,[open],Help,DispIndex,BlankType,BlankMax,BlankMin,BlankOptional,Value,Exclusive,ThumbUrl,BlankRows,BlankCols,Orientation,ShowValue,ShowTip,ShowCancel,SelectionMax,SelectionMin,Active,CreatedAt,CreatedBy,UpdatedAt,UpdatedBy From queoption ");
		sql.append("SELECT ID,QuestionID,Code,Title,ImageUrl,VideoUrl,[open],Help,DispIndex,BlankType,BlankMax,BlankMin,BlankOptional,Value,Exclusive,ThumbUrl,BlankRows,BlankCols,Orientation,ShowValue,ShowTip,ShowCancel,SelectionMax,SelectionMin,Active,CreatedAt,CreatedBy,UpdatedAt,UpdatedBy From queoption ");
		sql.append(" Where QuestionID=").append(id);
		sql.append(" order by DispIndex asc");
		List<QueOption> optionList = this.commonDao.queryForPojoList(sql.toString(), QueOption.class);
		return optionList;
	}
	
	/**
	 * 题目的题目的相关的设置
	 * @param arg
	 * @return
	 * @throws Exception
	 */
	@Override
	@Transactional
	public Boolean updateQuestion(Object[] arg) throws Exception {
		StringBuffer sql = new StringBuffer();
		sql.append(" update question set TemplateID=?,Type=?,Number=?,Title=?,ImageUrl=?,VideoUrl=?,Optional=?,Help=?,Layout=?,DispIndex=?,SelectionMax=?,SelectionMin=?,RowDisordered=?,MatrixPivot=?,RowLastFixed=?,ColDisordered=?,ColLastFixed=?,ColumnCount=?,BusinessType=?,ScoreType=?,RowReverse=?,ColReverse=?,ChartType=?,UpdatedAt=getdate()  where pk_id=?");
		int a = commonDao.update(sql.toString(),arg);
		
		if(a>0)
			return true;
		return false;
		
	}
	
}
