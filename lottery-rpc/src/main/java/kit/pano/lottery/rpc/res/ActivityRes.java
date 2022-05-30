package kit.pano.lottery.rpc.res;

import kit.pano.lottery.common.Result;
import kit.pano.lottery.rpc.dto.ActivityDto;
import lombok.Data;

import java.io.Serializable;

/**
 * 活动返回类
 *
 * @author pano
 */
@Data
public class ActivityRes implements Serializable {

    private Result result;
    private ActivityDto activity;

    public ActivityRes() {
    }

    public ActivityRes(Result result) {
        this.result = result;
    }

    public ActivityRes(Result result, ActivityDto activity) {
        this.result = result;
        this.activity = activity;
    }

}
