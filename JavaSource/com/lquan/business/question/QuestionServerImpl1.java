package com.lquan.business.question;

import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.gson.Gson;
import com.lquan.entity.Orders;
import com.lquan.entity.QueOption;
import com.lquan.entity.Question;
import com.lquan.web.util.AbstractService;

import snt.common.dao.base.CommonDAO;
import snt.common.dao.base.PrimaryKeyGenerator;

@Service(value="questionServer1")
public class QuestionServerImpl1 extends AbstractService implements IQuestionServer1 {
	
	@Autowired
	@Qualifier("commonDAO")
	private CommonDAO commonDao;
	
	/**
	 * 创建题目并返回题目
	 */
	@Override
	public Question createQuestion(Question question, String user) throws Exception {
		long pk_id = PrimaryKeyGenerator.getLongKey();
		question.setId(pk_id);
		question.setCreatedBy(user);
		question.setUpdatedBy(user);
		Object[] arg = question.getObjectFile();
		arg[0]=pk_id;
		Boolean bq = createQuestion(arg);
		List<QueOption> qolist = question.getOptions();
		List<QueOption> list = new ArrayList<QueOption>();
		for(QueOption option:qolist){
			long id = PrimaryKeyGenerator.getLongKey();
			option.setId(id);
			option.setCreatedBy(user);
			option.setUpdatedBy(user);
			option.setQuestionID(pk_id);
			Object[] optionargs = option.getObjectFile();
			optionargs[0]=id;
			try {
				createOPtion(optionargs);
			} catch (Exception e) {
				e.printStackTrace();
			}
			list.add(option);
		}
		question.setOptions(list);
		return question;
	}
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
	 * 删除题目
	 */
	@Override
	public Question deleteQuestion(Question question) throws Exception {
		StringBuffer sql = new StringBuffer();
		sql.append(" delete from question where pk_id=").append(question.getId());
		int a = commonDao.update(sql.toString());
		
		StringBuffer sb = new StringBuffer();
		sb.append("delete from queoption where QuestionID=").append(question.getId());
		int b = commonDao.update(sb.toString());
		return question;
	}
	
	/**
	 *  调换题目的顺序
	 * @param id 第一个题目的ID
	 * @param dispIndex 第一个题目的序号
	 * @return
	 * @throws Exception
	 */
	public List<Orders> moveQuestion(List<Orders> list) throws Exception {
		List<Object[]> args = new ArrayList<Object[]>();
		for(Orders order:list){
			args.add(new Object[] { order.getDispIndex(),order.getId() });
		}
		
		StringBuffer sql = new StringBuffer();
		sql.append(" update question set dispIndex =?  where pk_id=?");
		int[] a = commonDao.batchUpdate(sql.toString(), args);
		
		return list;
		
	}


	
	/**
	 * 题目的题目的相关的设置
	 * @param arg
	 * @return
	 * @throws Exception
	 */
	@Override
	public Question updateTitleQuestion(Question question) throws Exception {
		StringBuffer sql = new StringBuffer();
		//sql.append(" update question set TemplateID=?,Type=?,Number=?,Title=?,ImageUrl=?,VideoUrl=?,Optional=?,Help=?,Layout=?,DispIndex=?,SelectionMax=?,SelectionMin=?,RowDisordered=?,MatrixPivot=?,RowLastFixed=?,ColDisordered=?,ColLastFixed=?,ColumnCount=?,BusinessType=?,ScoreType=?,RowReverse=?,ColReverse=?,ChartType=?,UpdatedAt=getdate()  where pk_id=?");
		sql.append(" update question set Title=?,UpdatedAt=getdate()  where pk_id=?");
		commonDao.update(sql.toString(),new Object[]{question.getTitle(),question.getId()});
		return question;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//************************************************************************************
	
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
