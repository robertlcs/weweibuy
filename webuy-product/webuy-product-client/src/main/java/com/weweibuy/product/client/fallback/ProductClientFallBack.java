package com.weweibuy.product.client.fallback;

import com.weweibuy.common.dto.CommonJsonResponse;
import com.weweibuy.common.eum.CommonWebMsg;
import com.weweibuy.product.client.ProductClient;
import com.weweibuy.product.common.model.form.WebuyItemForm;
import com.weweibuy.product.common.model.po.WebuyItem;
import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @ClassName ProductClientFallBack
 * @Description
 * @Author durenhao
 * @Date 2019/2/8 10:18
 **/
@Component
@Slf4j
public class ProductClientFallBack implements FallbackFactory<ProductClient>{

    @Override
    public ProductClient create(Throwable throwable) {
        log.error(throwable.getMessage());
        return new ProductClient() {
            @Override
            public CommonJsonResponse<WebuyItem> getItem(Long id) {
                return CommonJsonResponse.fail(CommonWebMsg.FALL_BACK);
            }

            @Override
            public CommonJsonResponse addItem(WebuyItemForm webuyItem) {
                return CommonJsonResponse.fail(CommonWebMsg.FALL_BACK);

            }

            @Override
            public CommonJsonResponse delItem(Long id) {
                return CommonJsonResponse.fail(CommonWebMsg.FALL_BACK);

            }
        };
    }
}
