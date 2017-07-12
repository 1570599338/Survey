package com.lquan.business.option;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lquan.entity.Orders;
import com.lquan.entity.QueOption;

import snt.common.dao.base.CommonDAO;
import snt.common.dao.base.PrimaryKeyGenerator;

@Service(value="optionServer")
public class OptionServerImpl implements IOptionServer {

	@Autowired
	@Qualifier("commonDAO")
	private CommonDAO commonDao;
	
	
	/**
	 * 插入选项数据
	 * @param arg
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<QueOption> createOPtion(List<QueOption> list,String username) throws Exception {
		List<Object[]> args = new ArrayList<Object[]>();
		List<QueOption> tem = new ArrayList<QueOption>();
		for(QueOption option:list){
			long pk_id = PrimaryKeyGenerator.getLongKey();
			option.setId(pk_id);
			option.setCreatedBy(username);
			Object[]  arg = option.getObjectFile();
			arg[0]=pk_id;
			args.add(arg);
			tem.add(option);
		}
		
		StringBuffer sql = new StringBuffer();
		sql.append("insert into queoption(pk_id,id,CreatedBy,UpdatedBy,QuestionID,Code,Title,ImageUrl,VideoUrl,[Open],Help,DispIndex,BlankType,BlankMax,BlankMin,BlankOptional,Value,Exclusive,ThumbUrl,BlankRows,BlankCols,Orientation,ShowValue,ShowTip,ShowCancel,SelectionMax,SelectionMin,Active,CreatedAt,UpdatedAt) ");
		sql.append(" values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,getdate(),getdate())");
		int[] a = commonDao.batchUpdate(sql.toString(), args);
		return tem;
	}
	
	
	/**
	 * 对选项进行排序
	 * @param firstID
	 * @param firstDispIndex
	 * @return
	 * @throws Exception
	 */
	public List<Orders> moveQueOPtion(List<Orders> list) throws Exception {
		List<Object[]> args = new ArrayList<Object[]>();
		for(Orders order:list){
			args.add(new Object[] { order.getDispIndex(),order.getId() });
		}
		
		StringBuffer sql = new StringBuffer();
		sql.append(" update queoption set dispIndex =? where pk_id=?");
		int[] a = commonDao.batchUpdate(sql.toString(), args);
		
		return list;
		
	}
	
	

	
	/**
	 * 删除选项
	 * @param ID 选项的主键
	 * @return
	 * @throws Exception
	 */
	@Override
	public QueOption deleteOption(QueOption option) throws Exception{
		StringBuffer sql = new StringBuffer();
		sql.append(" delete from queoption   where pk_id=").append(option.getId());
		int a = commonDao.update(sql.toString());
		
		return option;
	}
	
	
	/**
	 * 更新选项的内容
	 * @param arg
	 * @return
	 * @throws Exception
	 */
	@Override
	public QueOption updateOption(QueOption option) throws Exception {
		StringBuffer sql = new StringBuffer();
		//sql.append(" update queoption set updatedBy=?,QuestionID=?,code=?,title=?,imageUrl=?,videoUrl=?,[open]=?,help=?,dispIndex=?,blankType=?,blankMax=?,blankMin=?,blankOptional=?,value=?,exclusive=?,thumbUrl=?,blankRows=?,blankCols=?,orientation=?,showValue=?,showTip=?,showCancel=?,selectionMax=?,selectionMin=?,active=?,UpdatedAt=getdate()  where pk_id=?");
		sql.append(" update queoption set title=?,UpdatedAt=getdate()  where pk_id=?");
		commonDao.update(sql.toString(),new Object[]{option.getTitle(),option.getId()});
		
		return option;
	}
	
	
	
// ******************************************************************************
	
	/**
	 * 更新选项内容
	 * @param arg
	 * @return
	 * @throws Exception
	 */
	@Override
	public Boolean updateOption(Object[] arg) throws Exception {
		StringBuffer sql = new StringBuffer();
		sql.append(" update queoption set updatedBy=?,QuestionID=?,code=?,title=?,imageUrl=?,videoUrl=?,[open]=?,help=?,dispIndex=?,blankType=?,blankMax=?,blankMin=?,blankOptional=?,value=?,exclusive=?,thumbUrl=?,blankRows=?,blankCols=?,orientation=?,showValue=?,showTip=?,showCancel=?,selectionMax=?,selectionMin=?,active=?,UpdatedAt=getdate()  where pk_id=?");
		int a = commonDao.update(sql.toString(),arg);
		
		if(a>0)
			return true;
		return false;
		
	}



	
}
