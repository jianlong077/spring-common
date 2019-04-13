

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.spring.base.common.io.IoUtil;
import com.spring.base.common.json.JsonUtil;
import com.spring.base.entity.BaseEntity;

public class text {	
	private static final Logger log = LoggerFactory.getLogger(text.class);
	static String fromFile="G:\\IoText/text.txt";
	static int num=3;
	static String contet="。本次编程任务要求创建一个配置文件，该配置文件存储三";
	/**
	 * 测试写入
	 * @param args
	 */
	public static void writeFile() {
		try {
			List<BaseEntity> list=new ArrayList<>(num);
			for(int i=0;i<num;i++) {
				BaseEntity a=new BaseEntity();
				a.setCreateTime(new Date());
				a.setUpdateTime(new Date());
				a.setId(contet);
				a.setCreateUserId(contet);
				a.setCreateUserName(contet);
				a.setUpdateUserId(contet);
				a.setUpdateUserName(contet);
				list.add(a);
			}
			IoUtil.writeFile(fromFile,list.toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * 测试大数量写入读取 json转化耗时
	 * @param args
	 */
	public static void useTime() {
			long startTime =System.currentTimeMillis() ;		
			List<BaseEntity> list=new ArrayList<>(num);
			
			for(int i=0;i<num;i++) {
				BaseEntity a=new BaseEntity();
				a.setCreateTime(new Date());
				a.setUpdateTime(new Date());
				a.setId(contet);
				a.setCreateUserId(contet);
				a.setCreateUserName(contet);
				a.setUpdateUserId(contet);
				a.setUpdateUserName(contet);
				list.add(a);
			}
			long endTime =System.currentTimeMillis() ;
			log.info("构建 数据耗时：  "+(endTime-startTime)/1000+" 秒" +"  数据大小 ："+list.size());
			long startTime1 =System.currentTimeMillis() ;
			StringBuffer sb=new StringBuffer(JsonUtil.toJsonString(list));
			System.out.println(sb);
			long endTime1 =System.currentTimeMillis() ;
			log.info("构建 数据耗时  "+(endTime1-startTime1)/1000+" 秒");
			try {
				IoUtil.writeFile(fromFile,sb.toString());
				String json=IoUtil.readFile(fromFile);
				long startTime2 =System.currentTimeMillis() ;
				log.info("json 长度" +json.length());
				List<BaseEntity> clazz =JsonUtil.getBeean(json);
				long endTime2 =System.currentTimeMillis() ;
				log.info("json 转 实体类 "+(endTime2-startTime2)/1000+" 秒" +"  数据大小 ："+(clazz!=null?clazz.size():0));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	public static void main(String[] args) {
		 writeFile();
	}
}
