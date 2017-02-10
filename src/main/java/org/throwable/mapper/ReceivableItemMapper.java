package org.throwable.mapper;

import org.apache.ibatis.annotations.Param;
import org.throwable.entity.ReceivableItem;

import java.util.List;

/**
 * @author zhangjinci
 * @version 2017/2/10 16:44
 * @function
 */
public interface ReceivableItemMapper {

    ReceivableItem fetchById(@Param("id")Long id);

    List<ReceivableItem> batchProcess();

    void updateSingle(ReceivableItem item);
}
