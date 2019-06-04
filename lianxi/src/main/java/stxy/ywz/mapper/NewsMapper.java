package stxy.ywz.mapper;

import java.util.List;

import stxy.ywz.bean.News;
import stxy.ywz.bean.Pages;

public interface NewsMapper {

	//����һ������
		public void insert(News news);
		
		//��ѯ��������
	    public List<News> list(Pages page);
	    
	  //��ѯ��������
	    public List<News> listall();
	    
	  //����������
	    public Integer searchTotalCount(Pages page);
	    
		//��ѯ״̬Ϊ0��������
	    public List<News> list1();
		
		//ͨ��iD����һ������
		public News selectoneByPrimaryKey(Integer nid);
		
		//�޸�������Ϣ
		public int update(News news);
		
		//�޸�����״̬
		public int edit(News news);
		
		//ɾ��һ������
		public int delete(News news);
		 

}
