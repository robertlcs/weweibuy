package com.weweibuy.inventory.service.impl;

import com.weweibuy.common.dto.CommonJsonResponse;
import com.weweibuy.inventory.common.model.po.WebuyInventory;
import com.weweibuy.inventory.common.model.po.WebuyInventoryExample;
import com.weweibuy.inventory.mapper.WebuyInventoryMapper;
import com.weweibuy.inventory.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

/**
 * @ClassName InventoryServiceImpl
 * @Description
 * @Author durenhao
 * @Date 2019/2/9 11:10
 **/
@Service
public class InventoryServiceImpl implements InventoryService {

    @Autowired
    private WebuyInventoryMapper inventoryMapper;

    @Override
    public CommonJsonResponse<List<WebuyInventory>> getInventoryNumBuySkuIds(Long[] skuIds) {
        WebuyInventoryExample example = new WebuyInventoryExample();
        example.createCriteria().andSkuIdIn(Arrays.asList(skuIds));
        List<WebuyInventory> inventoryList = inventoryMapper.selectByExample(example);
        return CommonJsonResponse.success(inventoryList);
    }
}
