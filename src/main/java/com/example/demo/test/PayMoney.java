package com.example.demo.test;

import com.example.demo.cmp.BatchSenderCmp;
import com.yomahub.liteflow.annotation.LiteflowComponent;
import com.yomahub.liteflow.core.NodeComponent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicReference;

@LiteflowComponent(id="pay",name="PayMoney")
public class PayMoney extends NodeComponent {
    private static final Logger log = LoggerFactory.getLogger(BatchSenderCmp.class);

    /**
     * @throws Exception
     */
    @Override
    public void process() throws Exception {

        log.info("构造了支付流程组件：计算总价流程，延迟一秒");
        int time = new Random().nextInt(1000);
        Thread.sleep(time);
        BuyContext context = this.getContextBean(BuyContext.class);
        List<Goods>  requestData = this.getRequestData();
        AtomicReference<Double> count = new AtomicReference<>(context.getAllCount());
        requestData.stream().forEach(goods1 -> {
            count.updateAndGet(v -> v + goods1.getCost());
        });
        context.setAllCount(count.get());
    }
}
