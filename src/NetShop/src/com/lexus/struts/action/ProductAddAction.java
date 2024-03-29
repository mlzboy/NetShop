/*
 * Generated by MyEclipse Struts
 * Template path: templates/java/JavaClass.vtl
 */
package com.lexus.struts.action;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import org.apache.struts.upload.FormFile;

import com.lexus.bean.Attachment;
import com.lexus.bean.DictionaryLib;
import com.lexus.bean.Product;
import com.lexus.bean.ProductDetail;
import com.lexus.bean.TableFieldDictMapping;
import com.lexus.struts.form.ProductAddForm;
import com.lexus.util.Constans;
import com.lexus.util.PathAndFileOperate;

/**
 * MyEclipse Struts Creation date: 05-31-2007
 * 
 * XDoclet definition:
 * 
 * @struts.action path="/manage/productAdd" name="productAddForm"
 *                input="/manage/productAdd.jsp" scope="request" validate="true"
 */
public class ProductAddAction extends BaseAction {
	/**
	 * Logger for this class
	 */
	private static final Log log = LogFactory.getLog(ProductAddAction.class);

	/*
	 * Generated Methods
	 */

	/**
	 * Method execute
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return ActionForward
	 * @throws IOException
	 * @throws FileNotFoundException
	 */
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws FileNotFoundException, IOException {
		ProductAddForm productAddForm = (ProductAddForm) form;// TODO
																// Auto-generated
																// method stub
		ActionMessages infos = new ActionMessages();
		String categoryName = productAddForm.getCategoryName();
		int categoryId = Integer.parseInt(productAddForm.getCategoryId());
		String productName = productAddForm.getProductName();
		String productDescription = productAddForm.getProductDescription();
		String status = productAddForm.getStatus();
		long price = Long.parseLong(productAddForm.getPrice());
		String habitat = productAddForm.getHabitat();
		log.info("执行了execute方法");
		if (log.isInfoEnabled()) {
			log.info(String.format("categoryName=" + categoryName));
			log.info("categoryId=" + String.valueOf(categoryId));
			log.info("productName=" + productName);
			log.info("productDescription=" + productDescription);
			log.info("status=" + status);
			log.info("price=" + String.valueOf(price));
			log.info("habitat=" + String.valueOf(habitat));
		}
		// 验证categoryId
		DictionaryLib dictionaryLib = this.getDictionaryLibService().findById(
				categoryId);
		if (dictionaryLib != null) {
			Product product = new Product();
			product.setProductName(productName);
			product.setProductDescription(productDescription);

			Date d = new Date();
			product.setCheckinTime(d);
			product.setUpdateTime(d);
			product.setVersion(new Short("1"));
			product.setStatus(status);

//			product.setProductCategories(String.valueOf(dictionaryLib.getPkDictionaryLibId()));
			
			List temp2=new ArrayList();
			temp2.add(dictionaryLib);
			product.setProductCategories(temp2);

			
			// 设置product_detail表参数
			ProductDetail productDetail = new ProductDetail();
			productDetail.setProductPrice(price);
			productDetail.setProductHabitat(habitat);

			productDetail.setProduct(product);
			product.setProductDetail(productDetail);

			// 上传文件操作
			String fileName = null;
			String fileType = null;
			String fileExt = null;
			String relPath = null;
			String absPath = null;
			FormFile file = productAddForm.getAttachment();
			fileType = file.getContentType();
			if (file.getFileSize() > 0) {
				if (fileType.equals("image/pjpeg")
						|| fileType.equals("image/gif")
						|| fileType.equals("image/bmp")) {
					if (log.isInfoEnabled()) {
						log.info("存在上传的文件，进行上传文件操作");
					}

					// 设置储存路径
					// String
					// path=request.getSession().getServletContext().getRealPath("");
					fileName = PathAndFileOperate.getRandomFileName(file
							.getFileName());
					fileExt = fileName.substring(fileName.lastIndexOf(".") + 1);
					relPath = "manage\\upload\\" + fileName;
					absPath = PathAndFileOperate.getRealPath(request);
					absPath = absPath + relPath;
					InputStream in = file.getInputStream();
					OutputStream out = new FileOutputStream(absPath);
					// 设置缓冲区
					byte[] buffer = new byte[20000];
					int n = 0;
					// 开始保存
					while ((n = in.read(buffer)) != -1) {
						out.write(buffer, 0, n);
					}
					out.close();
					in.close();

					// 设置attachment表的参数
					TableFieldDictMapping tableFieldDictMapping = new TableFieldDictMapping();
					tableFieldDictMapping.setTableName_1("attachment");
					tableFieldDictMapping.setFieldName_1("attachment_type");
					List list = this.getTableFieldDictMappingService()
							.findByExample(tableFieldDictMapping);
					if (log.isInfoEnabled()) {
						log.info("dictionaryId="
								+ String.valueOf(((TableFieldDictMapping) list
										.get(0)).getDictionary()
										.getPkDictionaryId()));
					}
					DictionaryLib conditionDictionaryLib = new DictionaryLib();
					conditionDictionaryLib
							.setDictionary(((TableFieldDictMapping) list.get(0))
									.getDictionary());
					conditionDictionaryLib.setName("图片");
					List list2 = this.getDictionaryLibService().findByExample(
							conditionDictionaryLib);
					if (log.isInfoEnabled()) {
						log.info("dicitonaryLibId="
								+ String.valueOf(((DictionaryLib) list2.get(0))
										.getPkDictionaryLibId()));
					}

					tableFieldDictMapping = new TableFieldDictMapping();
					tableFieldDictMapping.setTableName_1("attachment");
					tableFieldDictMapping.setFieldName_1("extend_name");
					List list3 = this.getTableFieldDictMappingService()
							.findByExample(tableFieldDictMapping);
					if (log.isInfoEnabled()) {
						log.info("dictionaryId="
								+ String.valueOf(((TableFieldDictMapping) list3
										.get(0)).getDictionary()
										.getPkDictionaryId()));
					}
					conditionDictionaryLib = new DictionaryLib();
					conditionDictionaryLib
							.setDictionary(((TableFieldDictMapping) list3
									.get(0)).getDictionary());
					conditionDictionaryLib.setName(fileExt);
					List list4 = this.getDictionaryLibService().findByExample(
							conditionDictionaryLib);
					if (log.isInfoEnabled()) {
						log.info("dicitonaryLibId="
								+ String.valueOf(((DictionaryLib) list4.get(0))
										.getPkDictionaryLibId()));
					}

					Attachment attachment = new Attachment();
					attachment.setCheckinTime(d);
					attachment.setUpdateTime(d);
					attachment.setVersion(new Short("1"));
					attachment.setStatus(status);
					if (log.isInfoEnabled()) {
						log.info("fileExt=" + fileExt);
						log.info("relPath=" + relPath);
						log.info("absPath=" + absPath);
					}

					attachment.setAttachmentUrl(relPath);
					attachment
							.setDictionaryLibByAttachmentType((DictionaryLib) list2
									.get(0));
					attachment
							.setDictionaryLibByExtendName((DictionaryLib) list4
									.get(0));
					// 添加附件
					if (log.isInfoEnabled()) {
						log.info("添加附件入库");
					}
					this.getAttachmentService().save(attachment);

//					product.setProductAttachments(attachment.getPkAttachmentId().toString());
					
					List temp=new ArrayList();
					temp.add(attachment);
					product.setProductAttachments(temp);
					
					if (log.isInfoEnabled()) {
						log.info("添加产品及产品明细入库");
					}
					
				} 
				else
				{
					infos.add("attachment",new ActionMessage("error.struts.action.productadd.attachment.invalid"));
				}
				//释放读取的文件
				file.destroy();
			}
//			 添加产品及产品明细
			this.getProductService().save(product);
			infos.add(Constans.MESSAGE_OF_INFO, new ActionMessage("message.struts.action.productadd.add.success"));
		}
		else
		{
			infos.add("categoryName", new ActionMessage("error.struts.action.productadd.invalid"));
		}
		if (!infos.isEmpty()) {
			this.saveErrors(request, infos);
		}

		return mapping.getInputForward();
	}
}