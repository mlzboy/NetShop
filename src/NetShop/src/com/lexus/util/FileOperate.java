package com.lexus.util;

import java.io.File;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;



public class FileOperate {
	/**
	 * Logger for this class
	 */
	private static final Log log = LogFactory.getLog(FileOperate.class);

	public static void delete(HttpServletRequest request,String relPath)
	{
		String absPath=PathAndFileOperate.getRealPath(request);
		String fullPath=absPath+relPath;
		if (log.isInfoEnabled()) {
			log.info("fullPath="+fullPath);
		}	
		File file=new File(fullPath);
		if(file.exists())
		{
			if(log.isInfoEnabled())
			{
				log.info("删除文件");
			}
			file.delete();
		}
	}
}
