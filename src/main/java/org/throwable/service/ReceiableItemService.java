package org.throwable.service;

import org.springframework.stereotype.Service;
import org.throwable.entity.ReceivableItem;

import java.util.Date;

/**
 * @author zhangjinci
 * @version 2017/2/10 18:42
 * @function
 */
@Service
public class ReceiableItemService {


    public ReceivableItem calculateFee(ReceivableItem item) {
        Date now = new Date();
        Double amount = item.getReceiveableAmount();
        amount = 1000 * amount;
        item.setReceiveableAmount(amount);
        item.setUpdateTime(now);
        item.setCollecteDate(now);
        return item;
    }
}
