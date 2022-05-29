import kit.pano.lottery.LotteryApplication;
import kit.pano.lottery.domain.strategy.model.req.DrawReq;
import kit.pano.lottery.domain.strategy.service.draw.IDrawExec;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest(classes = LotteryApplication.class)
class IDrawExecTest {

    @Resource
    private IDrawExec drawExec;

    @Test
    void doDrawExec() {
        drawExec.doDrawExec(new DrawReq("小傅哥", 10001L));
        drawExec.doDrawExec(new DrawReq("小佳佳", 10001L));
        drawExec.doDrawExec(new DrawReq("小蜗牛", 10001L));
        drawExec.doDrawExec(new DrawReq("八杯水", 10001L));
    }
}