package com.jt.manage.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jt.common.po.ItemCat;
import com.jt.manage.mapper.ItemCatMapper;
import com.jt.manage.vo.EasyUITree;

@Service
public class ItemCatServiceImpl implements ItemCatService {
	
	@Autowired
	private ItemCatMapper itemCatMapper;
	
	
	/*if(itemCatTemp.getIsParent()){
	//是父级  closed
	easyUITree.setState("closed");
}else{
	//是子级  open
	easyUITree.setState("open");
}*/
	//根据parentId查询商品分类信息
	@Override
	public List<EasyUITree> findItemCatAll(long parentId) {
		ItemCat itemCat = new ItemCat();
		itemCat.setParentId(parentId);
		List<ItemCat> itemCatList = 
				itemCatMapper.select(itemCat);
		//需要将数据进行转换
		List<EasyUITree> treeList = new ArrayList<>();
		for (ItemCat itemCatTemp : itemCatList) {
			EasyUITree easyUITree = new EasyUITree();
			easyUITree.setId(itemCatTemp.getId());
			easyUITree.setText(itemCatTemp.getName());
			String state = 
			itemCatTemp.getIsParent() ? "closed" : "open";
			easyUITree.setState(state);
			treeList.add(easyUITree);
		}
		
		return treeList;
	}
}
