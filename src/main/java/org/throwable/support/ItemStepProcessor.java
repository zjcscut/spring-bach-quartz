package org.throwable.support;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.throwable.entity.ReceivableItem;
import org.throwable.service.ReceiableItemService;

import java.util.Map;

/**
 * @author zhangjinci
 * @version 2017/2/10 18:40
 * @function
 */
@Component
@Scope("prototype")
public class ItemStepProcessor implements ItemProcessor<ReceivableItem, ReceivableItem> {

    @Autowired
    private ReceiableItemService receiableItemService;

    private Map<String, Object> parameterValues;


    @Override
    public ReceivableItem process(ReceivableItem item) throws Exception {
        return receiableItemService.calculateFee(item);
    }

    public void setParameterValues(Map<String, Object> parameterValues) {
        this.parameterValues = parameterValues;
    }

    public Map<String, Object> getParameterValues() {
        return parameterValues;
    }
}
